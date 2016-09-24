package dang.algorithm.linklist;

public class DoubleLinkListQueue {
	private DoubleLinkList doubleLinkList;
	
	public DoubleLinkListQueue() {
		doubleLinkList = new DoubleLinkList();
	}
	
	public void insert(Link l) {
		doubleLinkList.insertFirst(l);
	}
	
	public Link remove() {
		return doubleLinkList.removeLast();
	}
	
	public boolean isEmpty() {
		return doubleLinkList.isEmpty();
	}
	
	public void show() {
		doubleLinkList.show();
	}
	
	public int size() {
		return doubleLinkList.size();
	}
	
}