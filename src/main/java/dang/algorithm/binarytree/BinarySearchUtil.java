package dang.algorithm.binarytree;
import java.util.Arrays;



/**
*
* Remember that binarySearch is used in sorted array situation
*/

public class BinarySearchUtil {
	/**
	* generic is used to stand for int, float, double 
	* 
	* @param the sorted Array to be searched
	* @param start index to be searched
	* @param end index to be searched
	* @param the key to be find
	*/
	public static <T extends Comparable> int binarySearch(T[] sortedArray, int start, int end, T key) {
		
		//System.out.println("start, end, key respectively: " + start + ", " + end + ", " + key);
		
		int head = start;
		int tail = end;
		
		while (head <= tail) {
			int mid = (head + tail) >>> 1;
			if (sortedArray[mid].compareTo(key) == 0) {
				System.out.println("The wanted key's index is " + mid);
				return mid;
			}else if (sortedArray[mid].compareTo(key) < 0) {
				head = mid + 1;
			}else {
				tail = mid - 1;
			}
		}
		
		/**
		while(head <= tail) {
			int mid = (head + tail) >>> 1;
			if(sortedArray[mid].compareTo(key) > 0) {
				head = mid + 1;
			}else if(sortedArray[mid].compareTo(key) < 0) {
				tail = mid - 1;
			} else {
				return mid;
			}
		}
		**/
		
		System.out.println("The wanted key doesn't exist. ");
		return -1;
	}
	
	public static <T extends Comparable<T>> int binarySearch2(T[] sortedArray, T key) {
		int left = 0;
		int right = sortedArray.length - 1;
		
		while (left <= right) {
			int mid = (left + right) >>> 1;
			if (sortedArray[mid].compareTo(key) == 0) {
				System.out.println("The wanted key's index is " + mid);
				return mid;
			}else if (sortedArray[mid].compareTo(key) > 0) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		System.out.println("The wanted key doesn't exist. ");
		return -1;
	}
	
	public static <T extends Comparable<T>> int binarySearch3(T[] sortedArray, int from , int to, T key) {
	/* 	
		int left = from;
		int right = to;
		int mid = (from + to) >>> 1;
		
		if(left > right) {
			System.out.println("The wanted key doesn't exist. ");
			return -1;
		} else if (sortedArray[mid].compareTo(key) == 0) {
			System.out.println("The wanted key's index is " + mid);
			return mid;
		} else if (sortedArray[mid].compareTo(key) > 0 ) {
			//T[] temp = Arrays.copyOfRange(sortedArray, left, mid - 1);
			return binarySearch3(sortedArray, left, mid - 1, key);
		}else {
			//T[] temp = Arrays.copyOfRange(sortedArray, mid + 1, right);
			//don't forget to add return before recursive
			return binarySearch3(sortedArray, mid + 1, right, key);
		}
		 */	
		 
		 
		 int mid = (from + to) >>> 1;
		 
		 if(sortedArray[mid].compareTo(key) == 0) {
			 System.out.println("The wanted key's index is " + mid);
			return mid;
		 } else if (from > to) {
			 System.out.println("The wanted key doesn't exist. ");
			 return -1;
		 }else if (sortedArray[mid].compareTo(key) > 0) {
			 return binarySearch3(sortedArray, from, mid - 1, key);
		 }else {
			 return binarySearch3(sortedArray, mid + 1, to, key);
		 }
	}
	
}