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

	// 使用递归实现的二分查找
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
	 * 说明：上面的代码中给出了折半查找的两个版本，一个用递归实现，一个用循环实现。需要注意的是计算中间位置时不应该使用(high+ low) /2的方式，
	 * 因为加法运算可能导致整数越界，这里应该使用以下三种方式之一：
	 * low + (high - low) / 2
	 * 或low + (high – low) >> 1
	 * 或(low + high) >>> 1（>>>是逻辑右移，是不带符号位的右移）
	 */
}
