package dang.algorithm.linklist;

public class DoubleLinkListQueueDemo {
	
	public static void main(String[] args) {
		DoubleLinkListQueue doubleLinkListQueue  = new DoubleLinkListQueue();
		
		doubleLinkListQueue.insert(new Link(1, 11));
		doubleLinkListQueue.insert(new Link(2, 22));
		doubleLinkListQueue.insert(new Link(3, 33));

		doubleLinkListQueue.show();
		
		Link r1 = doubleLinkListQueue.remove();
		Link r2 = doubleLinkListQueue.remove();
		
		System.out.println("the removed elements is ");

		r1.displayLink();
		r2.displayLink();
		
		System.out.println("the list after removed is ");
		doubleLinkListQueue.show();
		
		
	}
	
}