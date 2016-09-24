package dang.algorithm.linklist;

public class LinkListStack {
	private LinkList linkList;
	
	public LinkListStack() {
		linkList = new LinkList();
	}
	
	public Link pop() {
		return linkList.removeFirst2();
	}
	
	public void push(Link l) {
		linkList.insert(l);
	}
	
	public Link peek() {
		return linkList.peek();
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