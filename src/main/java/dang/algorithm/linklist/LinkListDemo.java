package dang.algorithm.linklist;

public class LinkListDemo {
	public static void main(String[] args) {
		
		LinkList list1 = new LinkList();
		
		
		Link l1 = new Link(1, 11);
		Link l2 = new Link(2, 22);
		Link l3 = new Link(3, 33);
		
		System.out.println("Insert l1: ");
		list1.insert(l1);
		
		System.out.println("Insert l2: ");
		list1.insert(l2);
		
		System.out.println("Insert l3: ");
		list1.insert(l3);
		
		System.out.println("the list size is " + list1.size());
		list1.show();
		
		/**
		System.out.println("Remove the first one.");
		Link ll = list1.remove2();
		System.out.println("The deleted elements is ");
		ll.displayLink();
		
		System.out.println("After delete, the list is ");
		list1.show();
		System.out.println("the list size is " + list1.size());
		**/
		Link result = list1.find(3);
		Link result2 = list1.find(6);
		
		Link l4 = new Link(4, 44);
		
		//list1.remove2(1);
		list1.insertAfter(2, l4);
		
		System.out.println("The after insert result: " );
		list1.show();
		//result2.displayLink();
		
	}
}