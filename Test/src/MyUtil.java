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

		// 说明：调用ByteArrayInputStream或ByteArrayOutputStream对象的close方法没有任何意义
		// 这两个基于内存的流只要垃圾回收器清理对象就能够释放资源，这一点不同于对外部资源（如文件流）的释放
	}

	/**
	 * 统计给定文件中给定字符串的出现次数
	 * 
	 * @param filename
	 *            文件名
	 * @param word
	 *            字符串
	 * @return 字符串在文件中出现的次数
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