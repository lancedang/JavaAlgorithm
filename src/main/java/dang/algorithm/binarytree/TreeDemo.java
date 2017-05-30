package dang.algorithm.binarytree;

public class TreeDemo {
	private static int x = 100;

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
		// tree.delete(9);

		// tree.traverse(n1);

	}

	public static void main(String[] args) {

		MyNode t1 = new MyNode(new MyBean(1, "1"));
		MyNode t2 = new MyNode(new MyBean(2, "2"));
		MyNode t3 = new MyNode(new MyBean(3, "3"));
		MyNode t4 = new MyNode(new MyBean(4, "4"));
		MyNode t5 = new MyNode(new MyBean(5, "5"));
		MyNode t6 = new MyNode(new MyBean(6, "6"));

		t1.setLeftMyNode(t2);
		t1.setRightMyNode(t3);

		t2.setLeftMyNode(t4);
		t2.setRightMyNode(t5);

		t3.setLeftMyNode(t6);

		new MyBinaryTree().levelVisit(t1);

	}
}
