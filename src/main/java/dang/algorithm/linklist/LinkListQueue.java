package dang.algorithm.linklist;

public class LinkListQueue {
	private LinkList linkList;
	
	public LinkListQueue() {
		linkList = new LinkList();
	}
	
	//Remove from queue front, the front is the earliest coming in the queue
	public Link remove() {
		return linkList.removeLast();
	}
	
	public void insert(Link l) {
		linkList.insert(l);
	}
	
	public boolean isEmpty() {
		return linkList.isEmpty();
	}
	
	public void show() {
		this.linkList.show();
	}
	
	public int size() {
		return this.linkList.size();
	}
}