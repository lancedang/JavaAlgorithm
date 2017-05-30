package dang.algorithm.advanceSort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 用堆实现优先级队列，默认树顶是最大值
 * 
 * @author Dangdang
 *
 */
public class MyHeap {
	private int max; // 数组的最大容量
	private int num;
	private int[] array;

	public MyHeap(int max) {
		this.max = max;
		num = 0;
		array = new int[max];
	}
	
	/**
	 * 往数组中插入新元素，并调整成最大堆，所有要插入的元素结束后，该数组既是最大堆
	 * @param key 待插入的新元素
	 */
	public void buildMaxHeap(int key) {
		if(num == 0) {
			array[0] = key;
			num ++;
		}else {
			//插入到数组末尾，然后向上过渡
			array[num ++] = key;
			trickleUp(num - 1);
		}
	}
	
	/**
	 * 从最大推中取走最大值（树根），去走后 同时调整堆，使剩余元素还是最大堆
	 * @return
	 */
	public int remove() {
		int result = array[0];	//取走最大根
		array[0] = array[num - 1];	//调整剩余元素，将树最后一个元素 调到 树顶
		num --;
		trickleDown2(0);	//新树顶向下调整
		return result;
	}
	
	/**
	 * 向上过渡，构成最大堆
	 * @param index 新插入元素的下标
	 */
	public void trickleUp(int index) {
		int pre = index;
		int current = index;
		while(pre >= 0) {
			pre = (current - 1) / 2;
			if(array[current] > array[pre]) {
				swap(current, pre);
				current = pre;
				
			}else {
				break;
			}
			
		}
		
	}
	
	/**
	 * 将下标为index的元素向下过渡
	 * @param index	将要被下方的元素下标
	 */
	public void trickleDown(int index) {
		int current = index;
		int left ;
		int right ;
		int large;
		
		while(2*current < num - 1) {
			left = 2 * current + 1;
			right = 2 * current + 2;
			if(2*current + 1 < (num - 1) && array[right] > array[left]) {
				large = right;
			}else{
				large = left;
			}
			
			if(array[current] < array[large]) {
				swap(current, large);
			}else{
				break;
			}
			current = large;
		}
		
	}
	
	public void trickleDown2(int index) {
		int temp = array[index];	//保留树顶，每次用其进行比较
		int curr = index;
		while(2 * curr < num - 1) {
			int left = 2 * curr + 1;
			int right = left + 1;
			int large;
			
			if(right < num - 1 && array[right] > array[left]) {
				large = right;
			}else{
				large = left;
			}
			
			if(temp < array[large]) {	//用temp树顶比较，temp在整个过程中不变，
				array[curr] = array[large];	//直接用子元素中较大值层层向上覆盖，避免层层交换
			}else {
				break;	//
			}
			
			curr = large;	//下标跳到刚才最大元素处，继续与最大值的子节点比较
			
		}
		
		array[curr] = temp;	//层层向上覆盖结束后， 将树顶一次性移到最终位置
		
	}
	
	public void swap(int a, int b) {
		int tep = array[a];
		array[a] = array[b];
		array[b] = tep;
	}
	public static void main(String[] args) {
		int[] a = {10, 12, 0, 2, 8, 11, 5, 9};
		MyHeap heap = new MyHeap(20);
		
		for(int key: a) {
			heap.buildMaxHeap(key);
		}
		System.out.println("num " + heap.num);
		int num = heap.num;
		for(int i=0; i<num; i++) {
			System.out.print(heap.remove() + " ");
		}
		
		Arrays arrays;
		Integer integer;
		String string;
		Comparable<String> comparable;
		Comparator<String> comparator;
		
	}
}
