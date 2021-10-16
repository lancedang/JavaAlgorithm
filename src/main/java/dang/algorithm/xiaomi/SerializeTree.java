package dang.algorithm.xiaomi;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;

public class SerializeTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        root.left = left1;
        root.right = right1;

        TreeNode left1Left2 = new TreeNode(4);
        TreeNode left1Right2 = new TreeNode(5);

        left1.left = left1Left2;
        left1.right = left1Right2;

        String s = s1(root);
        System.out.println(s);

        String result = levelSerializeTree(root);
        System.out.println(result);

        TreeNode levelDeserializeTree = levelDeserialize(result);
        String test = levelSerializeTree(levelDeserializeTree);
        System.out.println(test);
        System.out.println(test);
    }

    public static String s1(TreeNode root) {
        StringBuffer stringBuffer = new StringBuffer();
        if (root == null) {
            stringBuffer.append("#,");
            return stringBuffer.toString();
        }

        int value = root.value;
        stringBuffer.append(value).append(",");
        stringBuffer.append(s1(root.left));
        stringBuffer.append(s1(root.right));
        return stringBuffer.toString();
    }

    /**
     * 反序列化二叉树
     *
     * @param s
     * @return
     */
    public static TreeNode s2(String s) {
        if (s == null || "".equals(s.trim())) {
            return null;
        }
        String[] array = s.split(",");
        //递归遍历
        return null;
    }

    //使用层次遍历序列化二叉树
    public static String levelSerializeTree(TreeNode root) {
        TreeNode current = root;
        StringBuffer stringBuffer = new StringBuffer();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if (current != null) {
            queue.add(current);
        }

        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            //只有当前节点不为空，才将其左右节点插入到queue中,这样会使queue元素越来越少直到为空
            if (tempNode != null) {
                stringBuffer.append(tempNode.value).append(",");
                queue.add(tempNode.left);
                queue.add(tempNode.right);
            } else {
                stringBuffer.append("#").append(",");
            }
        }
        return stringBuffer.toString().substring(0, stringBuffer.length() - 1);
    }

    public static TreeNode levelDeserialize(String input) {
        if (input == null || "".equals(input.trim())) {
            return null;
        }

        String[] valueArray = input.split(",");

        //因为遍历过程（序列化过程）保存了空节点信息，故nodeArray的父-左-右关系呈现index,2*index+1,2*index+2
        //所有节点已经保存到数组，只需串联之间的关系即可
        //串联过程，从前往后遍历所有节点，对非'#'节点(非空节点)寻找其作用节点即可，直到array遍历结束
        int length = valueArray.length;
        TreeNode[] array = new TreeNode[length];

        for (int i = 0; i < length; i++) {
            if (!valueArray[i].equals("#")) {
                array[i] = new TreeNode(Integer.parseInt(valueArray[i]));
            }
        }

        for (int i = 0; i < length; i++) {
            if (array[i] != null) {
                array[i].left = array[2*i + 1];
                array[i].right = array[2 * i + 2];
            }
        }

        return array[0];

    }

    //反序列化：根据某种遍历方式得到的序列化字符串结果，重构二叉树
    static int index = -1;


    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }


}
