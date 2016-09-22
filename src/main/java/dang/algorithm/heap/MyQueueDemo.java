package dang.algorithm.heap;

public class MyQueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyPriorityQueue queue = new MyPriorityQueue();
		MyBean b1 = new MyBean(9, "b9");
		MyBean b2 = new MyBean(1, "b1");
		MyBean b3 = new MyBean(7, "b7");
		MyBean b4 = new MyBean(10, "b10");
		MyBean b5 = new MyBean(4, "b4");
		MyBean b6 = new MyBean(115, "b115");
		
		queue.insert(b1);
		queue.show();
		queue.insert(b2);
		queue.show();
		queue.insert(b3);
		queue.show();
		queue.insert(b4);
		queue.show();
		queue.insert(b5);
		queue.show();
		queue.insert(b6);
		queue.show();
		/*
		MyBean rev = queue.remove();
		rev.display();
		queue.show();
		*/
	}

}
