package dang.algorithm.queuestack;

import java.io.*;
public class PriorityQueueDemo{
	public static void main(String[] args) {
		PriorityQueue queue = new PriorityQueue(10);
		
		queue.insert(1);
		queue.insert(2);
		queue.insert(3);
		queue.insert(4);

		System.out.println("queue size is " + queue.getSize());
		queue.display();
		
		long result = queue.remove();
		System.out.println("the deleted item is " + result);

		queue.display();
		
	}
}