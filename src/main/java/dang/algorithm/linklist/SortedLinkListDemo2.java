package dang.algorithm.linklist;

/**
* LinkList is just like a container which contains 
*
*/
public class SortedLinkListDemo2 {
	public static void main(String[] args) {
		SortedLinkList sortedLinkList = new SortedLinkList();
		
		//int[] source = {30, 2, 5, 11, 10};
		Link[] source = {new Link(1, 1), new Link(11, 11), new Link(3, 33), new Link(2, 22), new Link(6, 66)};
		Link[] dest = new Link[5];
		
		Link l1 = new Link(1, 1);
		Link l2 = new Link(11, 11);
		Link l3 = new Link(3, 33);
		Link l4 = new Link(2, 22);
		Link l5 = new Link(6, 66);
		
		for(Link l : source ) {
			sortedLinkList.insert(l);
		}
		
		for(int i=0; i < 5; i++) {
			dest[i] = sortedLinkList.removeFirst2();
			dest[i].displayLink();
		}
		
	}
}