package dang.algorithm.linklist;


public class DoubleDirectLinkListDemo {
	public static void main(String[] args) {
		DoubleDirectLinkList doubleDirectLinkList = new DoubleDirectLinkList();
		
		/**
		doubleDirectLinkList.insertFirst(new DoubleDirectLink(1, 11));
		doubleDirectLinkList.insertFirst(new DoubleDirectLink(2, 22));
		doubleDirectLinkList.insertFirst(new DoubleDirectLink(3, 33));
		**/
		
		doubleDirectLinkList.insertLast(new DoubleDirectLink(1, 1));
		doubleDirectLinkList.insertLast(new DoubleDirectLink(11, 111));
		doubleDirectLinkList.insertLast(new DoubleDirectLink(3, 33));
		doubleDirectLinkList.insertLast(new DoubleDirectLink(4, 44));
		doubleDirectLinkList.insertLast(new DoubleDirectLink(0, 0));
		
		//doubleDirectLinkList.insertAfter(new DoubleDirectLink(3, 33), new DoubleDirectLink(5, 55));

		System.out.println("the removed elements is ");
		DoubleDirectLink result = doubleDirectLinkList.deleteKey(4);
		result.displayLink();
		
		System.out.println("after removed, elements is ");
		doubleDirectLinkList.showForward();
		System.out.println();
		doubleDirectLinkList.showBackward();
		/**
		Link r1 = doubleLinkList.removeLast();
		Link r2 = doubleLinkList.removeFirst();
		
		
		Link r1 = doubleLinkList.removeLast();
		Link r2 = doubleLinkList.removeLast();
		
		System.out.println("the removed elements is ");

		r1.displayLink();
		r2.displayLink();
		
		System.out.println("the list after removed is ");
		doubleLinkList.show();
		**/
		
	}
}