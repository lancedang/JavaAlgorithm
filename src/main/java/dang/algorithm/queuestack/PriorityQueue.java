package dang.algorithm.queuestack;

import java.io.*;

/**
* Rule that the least number with the most hihgest priority.
* The queue is filled with number just like int, double for simplification, and meanwhile the number stands for priority
* The list is sorted by priority or the number
* 
*/
public class PriorityQueue{
	private long[] array;
	private int maxSize;
	private int number;
	
	public PriorityQueue(int maxSize){
		this.maxSize = maxSize;
		array = new long[maxSize];
		number = 0;
	}
	
	/**
	* rear is always at the bottom
	*
	*/
	public void insert(long x) {
		//���ȼ����������������飬�涨����Ԫ��ֵ�������ȼ���Ԫ��ֵԽС���ȼ�Խ��array[0] //�����ȼ���͵�Ԫ�أ���array[0]Ԫ�ص�ֵ������
		int i;
		
		if(number == 0) {
			array[0] = x;
		}else {
			for(i = number - 1; i >= 0; i --) {
				if (array[i] < x) {
					array[i + 1] = array[i];
				}else {
					break;
				}
			}
			array[i + 1] = x;
		}
		
		number ++;
		
	}
	
	/**
	* the deleted element is the biggest priority one and its located at the number-1 position
	*
	*/
	public long remove() {
		return array[-- number];
	}
	
	public long peek() {
		return array[number - 1];
	}
	
	public int getSize() {
		return number;
	}
	
	public boolean isFull() {
		//return (rear == max - 1);
		return (number == maxSize);
	}
	
	public boolean isEmpty() {
		//return (front == rear + 1);
		return number == 0;
	}
	
	/**
	* This display is used as test method
	*/
	public void display() {
		for(int i=0; i<number; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
}