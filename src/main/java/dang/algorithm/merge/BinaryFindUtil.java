package dang.algorithm.merge;

public class BinaryFindUtil {
	/**
	 * 二分查找，用循环实现
	 * 
	 * @param array
	 *            数组必须有序
	 * @param begin
	 *            数组起始坐标
	 * @param end
	 *            数组结束下标
	 * @param key
	 * @return
	 */
	public static int loopBinaryFind(int[] array, int begin, int end, int key) {
		int mid;
		while (begin <= end) {
			mid = (begin + end) / 2;

			if (array[mid] == key) {
				return mid;
			} else if (array[mid] < key) {
				begin = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

	/**
	 * 二分查找，递归实现
	 * 
	 * @param array
	 *            有序数组
	 * @param begin
	 * @param end
	 * @param key
	 * @return
	 */
	public static int recursiveBinaryFind(int[] array, int begin, int end, int key) {
		if (begin > end) {
			return -1;
		} else {
			int mid = (begin + end) / 2;
			if (array[mid] == key) {
				return mid;
			} else if (array[mid] < key) {
				begin = mid + 1;
				//return recursiveBinaryFind(array, begin, end, key);
			} else {
				end = mid - 1;
				//return recursiveBinaryFind(array, begin, end, key);
			}
			return recursiveBinaryFind(array, begin, end, key);
		}
	}

	/**
	 * 二分排序
	 * 
	 * @param array
	 *            有序数组
	 * @param beggin
	 *            起始坐标
	 * @param end
	 *            结束坐标
	 */
	public static void binarySort(int[] array, int beggin, int end) {

	}
	public static void main(String[] args) {

	}
}
