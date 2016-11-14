import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MyUtil {

	private MyUtil() {
		throw new AssertionError();
	}

	@SuppressWarnings("unchecked")
	public static <T> T clone(T obj) throws Exception {
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream oout = new ObjectOutputStream(bout);
		oout.writeObject(obj);

		ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
		ObjectInputStream oin = new ObjectInputStream(bin);
		return (T) oin.readObject();

		// ˵��������ByteArrayInputStream��ByteArrayOutputStream�����close����û���κ�����
		// �����������ڴ����ֻҪ�������������������ܹ��ͷ���Դ����һ�㲻ͬ�ڶ��ⲿ��Դ�����ļ��������ͷ�
	}

	/**
	 * ͳ�Ƹ����ļ��и����ַ����ĳ��ִ���
	 * 
	 * @param filename
	 *            �ļ���
	 * @param word
	 *            �ַ���
	 * @return �ַ������ļ��г��ֵĴ���
	 */
	public static int countWordInFile(String filename, String word) {
		int counter = 0;
		//java 7 TWR
		try (FileReader fr = new FileReader(filename)) {
			try (BufferedReader br = new BufferedReader(fr)) {
				String line = null;
				int index = -1;
				while ((line = br.readLine()) != null) {
					while (line.length() >= word.length() && (index = line.indexOf(word)) >= 0) {
						counter++;
						line = line.substring(index + word.length());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return counter;
	}

}