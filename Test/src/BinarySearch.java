import java.util.Comparator;

public class BinarySearch {

	public static <T> int binarySearch(T[] x, T key, Comparator<T> comp) {
		int low = 0;
		int high = x.length - 1;
		while (low <= high) {
			int mid = (low + high) >>> 1;
			int cmp = comp.compare(x[mid], key);
			if (cmp < 0) {
				low = mid + 1;
			} else if (cmp > 0) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	public static <T extends Comparable<T>> int binarySearch(T[] x, T key) {
		return binarySearch(x, 0, x.length - 1, key);
	}

	// ʹ�õݹ�ʵ�ֵĶ��ֲ���
	private static <T extends Comparable<T>> int binarySearch(T[] x, int low, int high, T key) {
		if (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (key.compareTo(x[mid]) == 0) {
				return mid;
			} else if (key.compareTo(x[mid]) < 0) {
				return binarySearch(x, low, mid - 1, key);
			} else {
				return binarySearch(x, mid + 1, high, key);
			}
		}
		return -1;
	}

	/*
	 * ˵��������Ĵ����и������۰���ҵ������汾��һ���õݹ�ʵ�֣�һ����ѭ��ʵ�֡���Ҫע����Ǽ����м�λ��ʱ��Ӧ��ʹ��(high+ low) /2�ķ�ʽ��
	 * ��Ϊ�ӷ�������ܵ�������Խ�磬����Ӧ��ʹ���������ַ�ʽ֮һ��
	 * low + (high - low) / 2
	 * ��low + (high �C low) >> 1
	 * ��(low + high) >>> 1��>>>���߼����ƣ��ǲ�������λ�����ƣ�
	 */
}
