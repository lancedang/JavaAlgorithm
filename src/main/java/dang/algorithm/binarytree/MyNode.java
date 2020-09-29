package dang.algorithm.binarytree;

public class MyNode{
	
	private MyBean bean;
	private MyNode leftMyNode;
	private MyNode rightMyNode;

	public MyNode() {

	}

	public MyNode(MyBean bean) {
		this.bean = bean;
		leftMyNode = rightMyNode = null;
	}
	
	public void setMyBean(MyBean bean) {
		this.bean = bean;
	}
	
	public void setLeftMyNode(MyNode leftMyNode) {
		this.leftMyNode = leftMyNode;
	}
	
	public void setRightMyNode(MyNode rightMyNode) {
		this.rightMyNode = rightMyNode;
	}
	
	public MyBean getMyBean() {
		return bean;
	}
	
	public MyNode getLeftMyNode() {
		return leftMyNode;
	}
	
	public MyNode getRightMyNode() {
		return rightMyNode;
	}
	
	public void show() {
		bean.display();
	}
	
}
