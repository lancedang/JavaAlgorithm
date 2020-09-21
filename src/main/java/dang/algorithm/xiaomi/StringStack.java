package dang.algorithm.xiaomi;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 小米面试
 */
public class StringStack {
    public static void main(String[] args) {
        String input = "486<<22<";
        print(input);

        Node root = new Node(1);
        Node left1 = new Node(2);
        Node right1 = new Node(3);

        root.left = left1;
        root.right = right1;

        Node left1Left2 = new Node(4);
        Node right1Right2 = new Node(8);

        left1.left = left1Left2;

        //right1.right = right1Right2;

        printBinaryTreeFromRight(root);
    }

    /**
     * 处理字符串：23<<22<=2;2<<13<=1
     * 主要考虑几点点：
     * 1.使用栈实现
     * 2.考虑前面数字数小于“小于号个数的情况”
     * 3.stack.pop()需要空判断，否则会跑EmptyStackException
     *
     * @param input
     */
    public static void print(String input) {
        if (input == null || "".equals(input.trim())) {
            System.out.println("string is empty");
            return;
        }
        int length = input.length();
        char[] array = input.toCharArray();

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < length; i++) {
            char c = array[i];
            if (c == '<') {
                //这里要判断栈为不为空，如果为空则不pop数据
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                //否则一直push
                stack.push(c);
            }
        }
        System.out.println(stack);
    }


    /**
     * 打印从右侧看到的二叉树，比如
     * 1-left:2,1-right:3,看到的是1，3
     * 通过list.add(item) 实现从上至下
     * 通过list.add(0,item)实现从上至下
     *
     * @param root
     */
    public static void printBinaryTreeFromRight(Node root) {
        if (root == null) {
            System.out.println("tree is empty");
            return;
        }

        //使用从上到下,从右到左层次遍历二叉树的思想，先保存每层的数据到list<list>,然后在输出list第一个数
        LinkedList<Node> queue = new LinkedList<Node>();

        List<LinkedList<Node>> result = new LinkedList<LinkedList<Node>>();

        Node current = root;
        queue.push(current);

        while (!queue.isEmpty()) {

            LinkedList<Node> tempList = new LinkedList<Node>();

            int count = queue.size();
            while (count > 0) {
                Node tempRoot = queue.poll();
                tempList.add(tempRoot);
                //queue存放下一层
                Node left = tempRoot.left;
                Node right = tempRoot.right;
                if (right != null) {
                    queue.add(right);
                }
                if (left != null) {
                    queue.add(left);
                }
                count--;
            }

            //层次遍历：从上至下插入
            //result.add(tempList);

            //层次遍历：从下至上
            result.add(0, tempList);

        }

        for (List<Node> list : result) {   //no instance
            System.out.println(list.get(0).value);
        }
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        public Node(int x, Node left, Node right) {
            this.value = x;
            this.left = left;
            this.right = right;
        }
    }

}
