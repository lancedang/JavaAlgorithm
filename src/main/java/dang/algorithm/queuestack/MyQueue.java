package dang.algorithm.queuestack;

import java.io.*;
public class MyQueue{
	private long[] array;
	private int front;
	private int rear;
	private int max;
	private int number;
	
	public MyQueue(int max){
		this.max = max;
		array = new long[max];
		front = 0;
		rear = -1;
		number = 0;
	}
	
	public void insert(long x) {
		//insert starts at rear pointer
		if(isFull()) {
			System.out.println("The queue is full.");
		}else {
			if(rear < max - 1) {  //rear is not at bottom
				array[++ rear] = x;
			}else {				  //when rear is at bottrm then turn around to front
				rear = -1;
			}
			number ++;
		}
	}
	
	public long remove() {

		number --;
		long temp = array[front ++];
		if(front == max) {
			front = 0;
		}
		return temp;
		
	}
	
	public long peek() {
		return array[front];
	}
	
	public int getSize() {
		return number;
	}
	
	public boolean isFull() {
		//return (rear == max - 1);
		return (number == max);
	}
	
	public boolean isEmpty() {
		//return (front == rear + 1);
		return number == 0;
	}
	
}