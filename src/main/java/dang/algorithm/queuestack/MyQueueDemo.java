package dang.algorithm.queuestack;

import java.io.*;
public class MyQueueDemo{
	public static void main(String[] args) {
		MyQueue queue = new MyQueue(5);
		
		queue.insert(1);
		queue.insert(2);
		queue.insert(3);
		queue.insert(4);
	
		
		int size = queue.getSize();
		long first = queue.peek();

		System.out.println("queue size is " + size);
		System.out.println("the first one is " + first);
		
		queue.remove();
		queue.remove();
		queue.remove();
		
		queue.insert(5);
		queue.insert(6);
		queue.insert(7);
		
		
		first = queue.peek();
		size = queue.getSize();
		System.out.println("the first one is " + first);
		System.out.println("queue size is " + size);
	}
}