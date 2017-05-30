package dang.algorithm.binarytree;

import java.util.ArrayList;
import java.util.List;

public class MyBinaryTree {
	private MyNode rootNode;

	public MyBinaryTree() {
		super();
		// TODO Auto-generated constructor stub
		rootNode = null;
	}

	/**
	 * current向下不断遍历，直到找到空节点，然后将新节点插入(需保留父节点)
	 * 
	 * @param myNode
	 */
	public void insert(MyNode myNode) {
		if (rootNode == null) {
			rootNode = myNode;
		} else {
			// 因为要插入，所以保存父节点引用
			// 思路就是，当遍历到当前节点为空时，父节点指向新节点
			MyNode current = rootNode;
			MyNode pre = null;

			// while true ，return 第一次使用
			while (true) {
				pre = current;
				if (current.getMyBean().getId() > myNode.getMyBean().getId()) {
					current = current.getLeftMyNode();
					if (current == null) {
						pre.setLeftMyNode(myNode);
						return;
					}
				} else {
					current = current.getRightMyNode();
					if (current == null) {
						pre.setRightMyNode(myNode);
						return;
					}
				}
			}
		}
	}

	/**
	 * current向下一直遍历，直到找到或节点为空，因为初始化树的时候是二叉搜索树， 在寻找的时候，类似于二分查找的感觉
	 * 
	 * @param key
	 * @return
	 */
	public MyNode find(int key) {

		if (rootNode == null) {
			System.out.println("Tree is empty. ");
			return null;
		} else {
			MyNode current = rootNode;

			while (current.getMyBean().getId() != key) {
				if (current.getMyBean().getId() > key) {
					current = current.getLeftMyNode();
				} else {
					current = current.getRightMyNode();
				}
				if (current == null) {
					return null;
				}
			}
			return current;

			/*
			 * 方法二 while (true) { if (current.getMyBean().getId() == key) {
			 * return current; } else if (current.getMyBean().getId() < key) {
			 * current = current.getRightMyNode(); } else { current =
			 * current.getLeftMyNode(); } if (current == null) { return null; }
			 * }
			 * 
			 */
			/*
			 * 方法一 while (current != null) { // MyNode pre = current; if
			 * (current.getMyBean().getId() == key) { return current; } else if
			 * (current.getMyBean().getId() > key) { current =
			 * current.getLeftMyNode(); } else { current =
			 * current.getRightMyNode(); } } System.out.println("Not exists.");
			 * return null;
			 */
		}
	}

	public MyNode delete(int key) {
		return null;
	}

	/**
	 * 插入时默认升序插入，通过中序遍历得到 树的递增序列
	 * 
	 * @param node,
	 *            对以node为根的树进行递归遍历
	 */
	public void traverse(MyNode node) {
		if (node == null) {
			return;
		}

		MyNode left = node.getLeftMyNode();
		MyNode right = node.getRightMyNode();

		if (left != null) {
			traverse(left);
		}
		node.show();
		if (right != null) {
			traverse(right);
		}
	}

	/**
	 * 递归是消除while循环的，故一般没有while循环字句
	 * 
	 * @param node
	 */
	public void preTraverse(MyNode node) {
		if (node == null) {
			return;
		}
		node.show();
		if (node.getLeftMyNode() != null) {
			preTraverse(node.getLeftMyNode());
		}
		if (node.getRightMyNode() != null) {
			preTraverse(node.getRightMyNode());
		}
	}

	public void postTraverse(MyNode node) {
		if (node == null) {
			return;
		}
		if (node.getLeftMyNode() != null) {
			traverse(node.getLeftMyNode());
		}
		if (node.getRightMyNode() != null) {
			traverse(node.getRightMyNode());
		}
		node.show();
	}

	public MyNode getMinimum() {
		if (rootNode == null) {
			return null;
		}
		MyNode current = rootNode;
		MyNode pre = null;
		while (current != null) {
			pre = current;
			current = current.getLeftMyNode();
		}
		return pre;
	}

	public MyNode getMaximum() {
		if (rootNode == null) {
			return null;
		}
		MyNode current = rootNode;
		MyNode pre = null;
		while (current != null) {
			pre = current;
			current = current.getRightMyNode();
		}
		return pre;
	}

	/**
	 * 层次遍历二叉树
	 * 
	 * @param root
	 *            根节点
	 */
	public void levelVisit(MyNode root) {
		List<MyNode> auxi = new ArrayList<MyNode>();
		auxi.add(root);
		int current = 0; // 表示list中每一层 遍历的起始位置
		int last = 1;// 表示list中每一层遍历的结束位置，初始时list中只有一个值(第一层)

		while (current < auxi.size()) {// 内部循环每次结束，current停在每层结束位置，无新元素添加为判断条件
			last = auxi.size();
			while (current < last) {// 遍历每一层，while结束实际已遍历完该层元素，同时也将下层元素添加到list
				auxi.get(current).show();
				MyNode left = auxi.get(current).getLeftMyNode();
				MyNode right = auxi.get(current).getRightMyNode();

				if (left != null)
					auxi.add(left);// 把其下的左右节点(即下层节点)放入list中
				if (right != null)
					auxi.add(right);

				current++; // 遍历该层下一个

			}
		}

	}

}
