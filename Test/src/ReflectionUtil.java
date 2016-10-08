import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * ���乤����
 * 
 * @author ���
 *
 */
public class ReflectionUtil {

	private ReflectionUtil() {
		throw new AssertionError();
	}

	/**
	 * ͨ������ȡ����ָ���ֶ�(����)��ֵ
	 * 
	 * @param target
	 *            Ŀ�����
	 * @param fieldName
	 *            �ֶε�����
	 * @throws ���ȡ��������ָ���ֶε�ֵ���׳��쳣
	 * @return �ֶε�ֵ
	 */
	public static Object getValue(Object target, String fieldName) {
		Class<?> clazz = target.getClass();
		String[] fs = fieldName.split("\\.");

		try {
			for (int i = 0; i < fs.length - 1; i++) {
				Field f = clazz.getDeclaredField(fs[i]);
				f.setAccessible(true);
				target = f.get(target);
				clazz = target.getClass();
			}

			Field f = clazz.getDeclaredField(fs[fs.length - 1]);
			f.setAccessible(true);
			return f.get(target);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * ͨ������������ָ���ֶθ�ֵ
	 * 
	 * @param target
	 *            Ŀ�����
	 * @param fieldName
	 *            �ֶε�����
	 * @param value
	 *            ֵ
	 */
	public static void setValue(Object target, String fieldName, Object value) {
		Class<?> clazz = target.getClass();
		String[] fs = fieldName.split("\\.");
		try {
			for (int i = 0; i < fs.length - 1; i++) {
				Field f = clazz.getDeclaredField(fs[i]);
				f.setAccessible(true);
				Object val = f.get(target);
				if (val == null) {
					Constructor<?> c = f.getType().getDeclaredConstructor();
					c.setAccessible(true);
					val = c.newInstance();
					f.set(target, val);
				}
				target = val;
				clazz = target.getClass();
			}

			Field f = clazz.getDeclaredField(fs[fs.length - 1]);
			f.setAccessible(true);
			f.set(target, value);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}