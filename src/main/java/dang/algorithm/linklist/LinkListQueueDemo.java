package dang.algorithm.linklist;

public class LinkListQueueDemo {
	public static void main(String[] args) {
		
		LinkListQueue listQueue = new LinkListQueue();
		
		
		Link l1 = new Link(1, 11);
		Link l2 = new Link(2, 22);
		Link l3 = new Link(3, 33);
		
		System.out.println("Insert l1: ");
		listQueue.insert(l1);
		
		System.out.println("Insert l2: ");
		listQueue.insert(l2);
		
		System.out.println("Insert l3: ");
		listQueue.insert(l3);
		
		System.out.println("the list size is " + listQueue.size());
		listQueue.show();
		
		Link remove1 = listQueue.remove();
		Link remove2 = listQueue.remove();
		
		System.out.println("the removed elements is ");
		remove1.displayLink();
		remove2.displayLink();
		
		System.out.println("the list after removed is ");
		listQueue.show();
		
	}
}