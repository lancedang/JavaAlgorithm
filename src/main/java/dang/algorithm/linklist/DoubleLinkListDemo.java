package dang.algorithm.linklist;


public class DoubleLinkListDemo {
	public static void main(String[] args) {
		DoubleLinkList doubleLinkList = new DoubleLinkList();

		doubleLinkList.insertFirst(new Link(1, 11));
		doubleLinkList.insertFirst(new Link(2, 22));
		doubleLinkList.insertFirst(new Link(3, 33));

		doubleLinkList.show();
		/**
		Link r1 = doubleLinkList.removeLast();
		Link r2 = doubleLinkList.removeFirst();
		**/
		
		Link r1 = doubleLinkList.removeLast();
		Link r2 = doubleLinkList.removeLast();
		
		System.out.println("the removed elements is ");

		r1.displayLink();
		r2.displayLink();
		
		System.out.println("the list after removed is ");
		doubleLinkList.show();
		
		
	}
}