package dang.algorithm.heap;

public class MyPriorityQueue {
	
	private MyHeap myHeap;

	public MyPriorityQueue() {
		myHeap = new MyHeap(100);
	}

	public MyPriorityQueue(int max) {
		myHeap = new MyHeap(max);
	}

	public void insert(MyBean bean) {
		myHeap.insert(bean);
	}

	public MyBean remove() {
		return myHeap.delete2();
	}
	
	public void show() {
		myHeap.show();
	}
	
}
