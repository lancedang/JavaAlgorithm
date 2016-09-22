package dang.algorithm.advanceSort;

/**
 * MergeUtil包括归并排序算法
 * @author Dangdang
 *
 */
public class MergeUtil {
	/**
	 * 用归并的思想对两个有序数组进行归并排序
	 * 
	 * @param one
	 *            有序数组1
	 * @param two
	 *            有序数组2
	 * @param result
	 *            存放最终合并的有序数组
	 */
	public static void mergeTwoArray(int[] one, int[] two, int[] result) {
		int p1 = 0;
		int p2 = 0;
		int p3 = 0;
		int size1 = one.length;
		int size2 = two.length;

		while (p1 < size1 && p2 < size2) {
			if (one[p1] < two[p2]) {
				result[p3++] = one[p1++];
			} else {
				result[p3++] = two[p2++];
			}
		}

		while (p1 < size1) {
			result[p3++] = one[p1++];
		}

		while (p2 < size2) {
			result[p3++] = two[p2++];
		}
		/*
		 * if(p1 == size1) { for(int i = p2; i < size2; i++) { result[p3 ++] =
		 * two[i]; }
		 * 
		 * }
		 * 
		 * if(p2 == size2) { for(int j = p1; j < size1; j++) { result[p3 ++] =
		 * one[j]; }
		 * 
		 * }
		 */

	}

	/**
	 * merge 方法用于对同一个数组的相邻两个有序部分进行归并排序
	 * @param sourArray	需要归并的数组
	 * @param begin 数组左侧 有序部分的起始地址
	 * @param pivot 数组右侧 有序部分的起始地址
	 * @param end	数组右侧有序部分的截止地址
	 */
	public static void merge(int[] sourArray, int begin, int pivot, int end) {

		int p1 = begin;
		int p2 = pivot;
		
		int[] temp = new int[end - begin + 1];	//归并的结果暂存 temp数组，最后复制到sourArray里
		int p = 0;
		while (p1 < pivot && p2 < (end + 1)) {	//注意是end + 1
			if (sourArray[p1] < sourArray[p2]) {
				temp[p++] = sourArray[p1++];
			} else {
				temp[p++] = sourArray[p2++];
			}
		}

		while (p1 < pivot) {
			temp[p++] = sourArray[p1++];
		}

		while (p2 < (end + 1)) {
			temp[p++] = sourArray[p2++];
		}

		int i = 0;

		while (begin < (end + 1)) {
			sourArray[begin++] = temp[i++];	//赋值转移元素
		}

	}

	/**
	 * 递归归并排序算法
	 * @param sourArray	要排序的数组
	 * @param begin	归并的的起始地址
	 * @param end 归并的截止地址
	 */
	public static void mergeSort(int[] sourArray, int begin, int end) {
		if (begin == end) {
			return;
		} else {
			int mid = (begin + end) / 2;
			mergeSort(sourArray, begin, mid);
			mergeSort(sourArray, mid + 1, end);
			merge(sourArray, begin, mid + 1, end);
		}
	}

	public static void main(String[] args) {
		int[] demo = { 9, 1, 12, 4, 8, 21, 0};
		mergeSort(demo, 0, demo.length - 1);

		for (int i : demo) {
			System.out.print(i + " ");
		}

	}
}
