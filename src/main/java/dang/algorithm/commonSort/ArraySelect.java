package dang.algorithm.commonSort;

public class ArraySelect{
	private long[] array;
	private int number;
	
	public ArraySelect(int max) {
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
			swap(array[round], array[min]);
		}
		
		
		
		
	}
	
	public void selectSort3() {
		for(int round = 0; round < number - 1; round ++) {
			int min = round;
			for(int k = round + 1; k < number; k++) {
				if(array[k] < array[min]) {
					min = k;
				}
			}
			
			swap(array[round], array[min]);
			
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
					swap(array[k], array[k+1]);
				}
			}
		}
		
	}
	
	public void swap(long a, long b) {
		long tmp = 0;
		tmp = a;
		a = b;
		b = tmp;
	}
	
	public void swap2(int a, int b) {
		long tmp = 0;
		tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}
	
}