package dang.algorithm.binarytree;

public class TreeDemo {
	private static int x = 100;
	public static void main(String[] args) {

	}
	public static void main2(String[] args) {
		MyBinaryTree tree = new MyBinaryTree();
		
		MyNode n1 = new MyNode(new MyBean(5, "bean5"));
		MyNode n2 = new MyNode(new MyBean(2, "bean2"));
		MyNode n3 = new MyNode(new MyBean(7, "bean7"));
		MyNode n4 = new MyNode(new MyBean(9, "bean9"));
		MyNode n5 = new MyNode(new MyBean(1, "bean1"));
		MyNode n6 = new MyNode(new MyBean(0, "bean0"));

		tree.insert(n1);
		tree.insert(n2);
		tree.insert(n3);
		tree.insert(n4);
		tree.insert(n5);
		tree.insert(n6);
		
		tree.find(1);
		
		MyNode fd = tree.getMinimum();
		MyNode fd2 = tree.getMaximum();
		fd2.show();
		//tree.delete(9);
		
		//tree.traverse(n1);
	
	}
}
