package dang.algorithm.binarytree;

import java.util.Stack;

public class TreePreSort01 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(4);
        TreeNode root4 = new TreeNode(5);

        root.left = root1;
        root.right = root2;

        root1.left = root3;
        root1.right = root4;

        preSort(root);
    }


    public static void preSort(TreeNode root) {
        TreeNode current = root;
        if (current == null) {
            return;
        }
        System.out.println(current.value);
        preSort(root.left);
        preSort(root.right);
    }

    public static void preSortNoRecursive(TreeNode root) {
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();


    }

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
}
