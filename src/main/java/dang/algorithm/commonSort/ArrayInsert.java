package dang.algorithm.commonSort;

public class ArrayInsert{
	private long[] array;
	private int max;
	private int number;
	
	public ArrayInsert(int max) {
		this.max = max;
		array = new long[max];
		number = 0;
	}
	
	public void tailInsert(long key) {
		array[number] = key;
		number ++;
	}

	public void display() {
		System.out.println("Array elements:");
		for (int i=0; i<number; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}
	
	public int find(long key) {
		int i;
		for(i=0; i<number; i++){
			if (array[i] == key) {
				System.out.println("The wanted key's index is " + i);
				return i;
			}
		}
		System.out.println("The wanted key doesn't exist. ");
		return number;
	}
	
	public boolean delete(long key) {

		int i = find(key);
		
		if(i == number) {
			//System.out.println("The wanted key doesn't exist. ");
			return false;
		}
		
		for (int k=i; k<number; k++) {
			array[k] = array[k+1];
		}
		System.out.println("The wanted key deleted. ");
		number --;
		return true;
	}
	
	public long getMax() {
		
		if(number == 0) {
			System.out.println("The Array is empty. ");
			return -1;
		}
		
		long max = array[0];
		for(int i=1; i<number; i++){
			if (array[i]>max) {
				max = array[i];
			}
		}
		//System.out.println("The wanted key doesn't exist. ");
		return max;
	}
	
	public boolean isFull() {
		return number == max;
	}
	
	public boolean deleteMax(long max) {
		/**
		1. find the max
		2. find the index
		3. delete the max
		**/
		//long max = getMax();
		int i = find(max);
		
		if(i == number) {
			System.out.println("The wanted key doesn't exist. ");
			return false;
		}
		
		for (int k=i; k<number; k++) {
			array[k] = array[k+1];
		}
		System.out.println("The wanted key deleted. ");
		number --;
		return true;
	}
	
	public void selectSort() {
		/**
		1. select the minmum
		2. swap the minmum with the first one
		**/
		int round;
		int min;
		for(round=0; round<number-1; round++) {
			min = round;
			System.out.println("round = " + round);
			for(int k=round+1; k<number; k++) {
				if(array[k] < array[min]) {
					min = k;
				}
			}
			swap(round, min);
		}
		
		
		
		
	}
	
	public void bubbleSort() {
		/**
		1. given a array
		2. compare two elements next to each other
		3. move the bigger rightward
		
		1. execute size-1 rounds, i is the round index beginning with 1
		2. compare size-i times in i th round 
		**/
		
		for(int round=1; round<number; round++) {
			long tmp = 0;
			for(int k=0; k<(number-round); k++) {
				if(array[k]>array[k+1]) {
					tmp = array[k];
					array[k] = array[k+1];
					array[k+1] = tmp;
				}
			}
		}
		
	}
	
	public void bubbleSort2() {
		/**
		1. given a array
		2. compare two elements next to each other
		3. move the bigger rightward
		
		1. execute size-1 rounds, i is the round index beginning with 1
		2. compare size-i times in i th round 
		**/
		//executing rounds=number-1
		int round;
		for(round=number-1; round>0; round--) {
			for(int k=0; k<round; k++) { 
				if(array[k] > array[k+1]) {
					swap(k, k+1);
				}
			}
		}
		
	}
	
	public void insertSort() {
		for (int i=1; i<number; i++) {
			long temp = array[i];
			/**
			1. the elements in the front is sequencial
			2. findt the right position of temp
			3. move the corresponding elements
			**/
			int j = i;
			while(j>0 && array[j-1] >= temp) {
				array[j] = array[j-1];
				j --;
			}
			array[j] = temp;
		}	 
	}
	
	public void swap(int a, int b) {
		long tmp = 0;
		tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}
	
}