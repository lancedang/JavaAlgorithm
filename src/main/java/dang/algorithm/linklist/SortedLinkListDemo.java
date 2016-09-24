package dang.algorithm.linklist;

/**
* LinkList is just like a container which contains 
*
*/
public class SortedLinkListDemo {
	public static void main(String[] args) {
		SortedLinkList sortedLinkList = new SortedLinkList();
		
		Link l1 = new Link(1, 1);
		Link l2 = new Link(11, 11);
		Link l3 = new Link(3, 33);
		Link l4 = new Link(2, 22);
		Link l5 = new Link(6, 66);
		
		sortedLinkList.insert(l1);
		sortedLinkList.insert(l2);
		sortedLinkList.insert(l3);
		sortedLinkList.insert(l4);
		sortedLinkList.insert(l5);
		
		sortedLinkList.show();
	}
}