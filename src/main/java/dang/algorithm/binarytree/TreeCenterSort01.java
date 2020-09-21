package dang.algorithm.binarytree;

import dang.algorithm.linklist.LinkList;

import java.util.Stack;

public class TreeCenterSort01 {
    public static void centralSort(MySimpleNode root) {
        MySimpleNode current = root;
        Stack<MySimpleNode> stack = new Stack<MySimpleNode>();

        while (current != null || !stack.empty()) {
            //一直将左子树塞进栈里，左子树塞到最下面了，pop出最左节点A，然后同时把A节点的right节点插入栈中
            //一定要记住A可能有右节点
            while (current != null) {
                stack.push(current);
                current = current.getLeftMyNode();
            }

            MySimpleNode leftEnd = stack.pop();
            System.out.println(leftEnd.getValue());
            MySimpleNode leftEndRightMyNode = leftEnd.getRightMyNode();

            current = leftEndRightMyNode;
        }

    }

    public void preSort(MyNode root) {
        LinkList linkList = new LinkList();
    }

    public static void main(String[] args) {
        MySimpleNode root = new MySimpleNode(50);
        MySimpleNode left1 = new MySimpleNode(20);
        MySimpleNode right1 = new MySimpleNode(100);

        root.setLeftMyNode(left1);
        root.setRightMyNode(right1);

        MySimpleNode left1Left2 = new MySimpleNode(10);
        MySimpleNode left1Right2 = new MySimpleNode(30);

        left1.setLeftMyNode(left1Left2);
        left1.setRightMyNode(left1Right2);

        MySimpleNode left1Left2Right3 = new MySimpleNode(5);
        MySimpleNode left1Right2Right3 = new MySimpleNode(7);

        left1Left2.setRightMyNode(left1Left2Right3);
        left1Right2.setRightMyNode(left1Right2Right3);

        centralSort(root);

    }

}
