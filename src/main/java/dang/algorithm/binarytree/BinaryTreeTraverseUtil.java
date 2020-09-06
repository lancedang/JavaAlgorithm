package dang.algorithm.binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树遍历，前中后序（递归，非递归），层次遍历
 */
public class BinaryTreeTraverseUtil {

    /**
     * 中序遍历二叉树
     * 左-中-右
     *
     * @param node
     */
    public static void centerTransverse(MyNode node) {
        if (node != null) {
            centerTransverse(node.getLeftMyNode());
            node.show();
            centerTransverse(node.getRightMyNode());
        }

    }

    /**
     * 非递归中序遍历二叉树
     */
    public static void centerTransverseNoRec(MyNode root) {

        Stack<MyNode> stack = new Stack<MyNode>();

        MyNode current = root;

        while (current != null || !stack.empty()) {

            //若root不为空则循环把其所有left入栈
            while (current != null) {
                stack.push(current);
                current = current.getLeftMyNode();
            }
            //当root所有left入栈或者root不存在 left后，读取节点
            if (!stack.empty()) {
                //读取最左侧节点
                MyNode pop = stack.pop();
                pop.show();

                //将最左节点的right子树入栈
                current = pop.getRightMyNode();

            }

        }

    }


    public static void  center1(MyNode root) {
        if (root == null) {
            return;
        }

        Stack<MyNode> stack = new Stack<MyNode>();
        MyNode current = root;

        while (current != null || !stack.empty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeftMyNode();
            }

            //current 为null，取栈顶元素
            MyNode myNode = stack.pop();
            myNode.show();
            current = myNode.getRightMyNode();
        }

    }

    /**
     * 先根遍历，中-左-右
     *
     * @param node
     */
    public static void preTransverse(MyNode node) {
        if (node != null) {
            node.show();
            preTransverse(node.getLeftMyNode());
            preTransverse(node.getRightMyNode());
        }

    }

    public static void preTransverseNoRec(MyNode root) {

        Deque<MyNode> de = new LinkedList<MyNode>();
        MyNode node = root;
        de.push(node);
        while (node != null && de.size() > 0) {
            node = de.pop();
            node.show();
            if (node.getLeftMyNode() != null && node.getRightMyNode() != null) {
                de.push(node.getRightMyNode());
                de.push(node.getLeftMyNode());
            } else if (node.getLeftMyNode() != null && node.getRightMyNode() == null) {
                de.push(node.getLeftMyNode());
            } else if (node.getLeftMyNode() == null && node.getRightMyNode() != null) {
                de.push(node.getRightMyNode());
            } else {
				/*Node pop = de.pop();
				System.out.print(pop.data+"  ");*/
            }

        }
    }

    public  static void preNonRec01(MyNode root) {
        //先把根入栈，再出栈，再把右子树入栈，再把左子树入栈
        Stack<MyNode> stack = new Stack<MyNode>();

    }

    public static void preTransverseNoRec2(MyNode root) {

        Stack<MyNode> stack = new Stack<MyNode>();
        //root先入栈
        stack.push(root);
        MyNode node = null;

        while (!stack.empty()) {

            //root再出栈
            node = stack.pop();

            node.show();

            //根据栈的性质，先把右子树入栈
            MyNode rightMyNode = node.getRightMyNode();
            if (rightMyNode != null) {
                stack.push(rightMyNode);
            }

            //然后把左子树入栈，后入栈的先访问
            MyNode leftMyNode = node.getLeftMyNode();
            if (leftMyNode != null) {
                stack.push(leftMyNode);
            }

        }

    }

    /**
     * 后根遍历，左-右-中
     *
     * @param node
     */
    public static void postTransverse(MyNode node) {
        if (node != null) {
            postTransverse(node.getLeftMyNode());
            postTransverse(node.getRightMyNode());
            node.show();
        }

    }

    /**
     * 层次遍历
     * 思想：运用queue，先把根节点放进去，然后取出根节点，同时将左右节点（非空情况）放进queue
     *
     * @param node
     */
    public static void levelTransverse(MyNode node) {

        Queue<MyNode> linkedList = new LinkedList();

        //先把根节点放进去
        linkedList.add(node);

        while (linkedList.size() != 0) {
            //MyNode root = linkedList.peek();
            //取出队列头元素,遍历是一个取数据的动作
            MyNode root = linkedList.poll();
            if (root != null) {
                root.show();

                //linkedList.poll();
                MyNode leftMyNode = root.getLeftMyNode();
                if (leftMyNode != null) {
                    linkedList.add(leftMyNode);
                }

                MyNode rightMyNode = root.getRightMyNode();
                if (rightMyNode != null) {
                    linkedList.add(rightMyNode);
                }

            }

        }

    }

    /**
     * 思想：一直往队列里存入，中间不取出，最后一次性取出整个队列
     *
     * @param root
     */
    public static void levelTransverse2(MyNode root) {

        if (root == null) {
            return;
        }

        Queue<MyNode> queue = new LinkedList<MyNode>();

        queue.add(root);

        MyNode leftMyNode = root.getLeftMyNode();
        MyNode rightMyNode = root.getRightMyNode();

        while (leftMyNode != null || rightMyNode != null) {
            queue.add(leftMyNode);
            queue.add(rightMyNode);
        }

    }


    /**
     * 递归获取二叉树高度
     * 思想：递归，分别获取左右子树的高度，整棵树的高度等于左右子树高度较大者 + 1
     * 递归边界：树为空时高度返回0
     *
     * @param root
     * @return
     */
    public static int getTreeHeight(MyNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getTreeHeight(root.getLeftMyNode());
        int rightHeight = getTreeHeight(root.getRightMyNode());

        //要记住这个 +1 的动作，否则结果为0，1 表示高度加上root这一层
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    /**
     * 获取二叉树节点个数
     * 思想：递归，分别获取左右子树节点个数，整棵树的节点个数等于左右子树节点个数之和 + 1
     * 递归边界：树为空时，节点个数返回 0
     */
    public static int getTreeNodeNumber(MyNode root) {
        if (root == null) {
            return 0;
        }

        int leftNumber = getTreeNodeNumber(root.getLeftMyNode());
        int rightNumber = getTreeNodeNumber(root.getRightMyNode());

        //要注意 +1 这个动作，1 表示加上 root这层节点，否则结果为0
        return leftNumber + rightNumber + 1;
    }

    /**
     * 从树中找到目的节点
     * 思想：递归，首先比较root是不是相等，若不是则分别从左右子树中查找目的节点
     *
     * @param x
     * @return
     */
    public static MyNode findKey(int x, MyNode root) {
        if (root == null) {
            return null;
        }

        if (root.getMyBean().getId() == x) {
            return root;
        }

        //注意：分别从左右子树中查找，同时需要判断左右子树是否返回为 null,若有一个不为null，说明找到了，否则
        //不存在于左右子树中
        MyNode node1 = findKey(x, root.getLeftMyNode());
        MyNode node2 = findKey(x, root.getRightMyNode());

        if (node1 != null) {
            return node1;
        }

        if (node2 != null) {
            return node2;
        }
        return null;

    }

    public static void levelSort(MyNode root) {
        if (root == null) {
            return;
        }
        Queue<MyNode> queue = new LinkedList<MyNode>();

        //先把root放到queue中，取root同时将其左右子节点放到queue中
        MyNode current = root;
        queue.add(current);

        while (queue.size() != 0) {
            MyNode myNode = queue.poll();
            myNode.show();

            MyNode leftMyNode = myNode.getLeftMyNode();
            MyNode rightMyNode = myNode.getRightMyNode();

            if (leftMyNode != null) {
                queue.add(leftMyNode);
            }

            if (rightMyNode != null) {
                queue.add(rightMyNode);
            }

        }


    }

    public static void pre01(MyNode root) {
        if (root != null) {
            MyNode current = root;
            //先把根放到栈中，然后根出栈，再把右子树放到栈中，最后再把左子树放到栈中（如此以来，可以左子树后放先访问）

            Stack<MyNode> stack = new Stack<MyNode>();

            stack.push(current);

            while (!stack.empty()) {
                MyNode myNode = stack.pop();

                MyNode rightMyNode = myNode.getRightMyNode();
                if (rightMyNode != null) {
                    stack.push(rightMyNode);
                }

                MyNode leftMyNode = myNode.getLeftMyNode();
                if (leftMyNode != null) {
                    stack.push(leftMyNode);
                }
            }

        }
    }

    /**
     * 判断二叉树是否为二叉搜索树
     * 思路：
     * 1）递归，先判断当前root，左，右子树三者是否满足 左<root<右
     * 2）然后，分别判断左,右子树是否满足上述1），在此基础上，判断左边子树最大值是否<root，右边最小值是否>root
     *
     * @param myNode
     * @return
     */
    public  static  boolean isBinaryFindTree(MySimpleNode myNode) {
        if (myNode != null) {
            MySimpleNode leftMyNode = myNode.getLeftMyNode();
            MySimpleNode rightMyNode = myNode.getRightMyNode();

            //1）左子树最大值要小于root值
            boolean leftTreeMaxNodeSmallerThanRoot = leftMyNode.getRightMyNode() == null || leftMyNode.getRightMyNode().getValue() < myNode.getValue();
            //2）右子树最小值要大于root值
            boolean rightTreeMinNodeBiggerThanRoot = rightMyNode.getLeftMyNode() == null || rightMyNode.getLeftMyNode().getValue() > myNode.getValue();

            //直接左节点<root<直接右节点 && 1） && 2）判断
            if ((leftMyNode == null || (leftMyNode.getValue() <= myNode.getValue() &&
                    leftTreeMaxNodeSmallerThanRoot)) && (rightMyNode == null || (rightMyNode.getValue() >= myNode.getValue() && rightTreeMinNodeBiggerThanRoot)) ) {
                return isBinaryFindTree(leftMyNode) && isBinaryFindTree(rightMyNode);
            }else {
                return false;
            }

        } else {
            return true;
        }
    }

    public static void main(String[] args) {


        MySimpleNode root = new MySimpleNode(100);
        MySimpleNode left1 = new MySimpleNode(50);
        MySimpleNode right2 = new MySimpleNode(150);

        root.setLeftMyNode(left1);
        root.setRightMyNode(right2);

        MySimpleNode left1_left2 = new MySimpleNode(20);
        MySimpleNode left1_right2 = new MySimpleNode(270);

        left1.setLeftMyNode(left1_left2);
        left1.setRightMyNode(left1_right2);

        MySimpleNode right1_left2 = new MySimpleNode(120);
        MySimpleNode right1_right2 = new MySimpleNode(200);

        right2.setLeftMyNode(right1_left2);
        right2.setRightMyNode(right1_right2);


        System.out.println(isBinaryFindTree(root));

    }


}
