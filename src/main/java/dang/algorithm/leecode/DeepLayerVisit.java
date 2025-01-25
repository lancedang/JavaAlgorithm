package dang.algorithm.leecode;

import java.util.Stack;

//深度、广度遍历二叉树
public class DeepLayerVisit {

    public static void main(String[] args) {
        Node root = new Node(5);

        Node l1 = new Node(3);

        root.left = l1;

        Node l11 = new Node(1);

        l1.left = l11;

        Node l12 = new Node(4);
        l1.right = l12;


        Node r1 = new Node(6);
        root.right = r1;

        //firstRootVisit(root);

        middleRootVisit(root);

        System.out.println("xxxxxxxxxxxxx");

        middleRootVisitNoRecusive(root);

    }

    //先根遍历：根、左、右 ,递归方式
    public static void firstRootVisit(Node root) {
        if (root == null) {
            return;
        }

        System.out.println(root.value);

        Node left = root.left;
        Node right = root.right;

        firstRootVisit(left);

        firstRootVisit(right);

    }


    //先根遍历：根、左、右 ,递归方式
    public static void firstRootVisitNoRecusive(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();

        //1.得先放进去，再循环
        stack.push(root);

        while (!stack.isEmpty()) {

            Node center = stack.pop();
            System.out.println(center.value);

            //先放右到stack->后访问
            if (center.right != null) {
                stack.push(center.right);
            }

            if (center.left != null) {
                stack.push(center.left);
            }

        }

        System.out.println();
    }

    public static void middleRootVisit(Node root) {

        if (root == null) {
            return;
        }

        Node left = root.left;
        Node right = root.right;

        if (left != null) {
            middleRootVisit(left);
        }

        System.out.println(root.value);

        if (right != null) {
            middleRootVisit(right);
        }

    }

    public static void middleRootVisitNoRecusive(Node root) {

        Node curr = root;

        if (curr == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();


        while (curr != null) {
            Node left = curr.left;
            Node right = curr.right;

            while (left != null) {
                stack.push(left);
                left = left.left;
            }

            if (!stack.isEmpty()) {
                //最左下角的pop出来
                Node pop = stack.pop();

                if (pop != null) {
                    //访问左下角的
                    System.out.println(pop.value);
                }

                Node peek = stack.pop();

                if (peek != null) {
                    System.out.println(peek.value);
                    Node right1 = peek.right;
                    curr = right1;
                }
            }


        }


    }

    public static void layerVisit(Node root) {

    }


    private static class Node {

        public int value; //节点值
        public Node left;  //左节点
        public Node right; //右节点

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

}
