package dang.algorithm.xiaomi;

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
        //System.out.println(s);

        preVisist(root);
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

    //使用前序遍历序列化二叉树
    public static String serializeTree(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root == null) {
            //空节点（#）
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.value + ",");
        sb.append(serializeTree(root.left));
        sb.append(serializeTree(root.right));
        return sb.toString();
    }

    //反序列化：根据某种遍历方式得到的序列化字符串结果，重构二叉树
    static int index = -1;

    public static TreeNode deserialize(String str) {
        index++;
        int len = str.length();
        if (index >= len) return null;
        //以逗号分隔，返回一个字符串数组
        String[] str1 = str.split(",");
        TreeNode node = null;
        //遍历str1数组，重构二叉树：当前遍历元素非 # 则作为一个结点插入树中，作为上一个结点的左儿子；
        //当前遍历元素为 # 则表示此子树已结束，遍历下一个元素作为上一个结点的右孩子
        //即遍历到数字作为上一个结点的左孩子，遇到#变向作为上一个结点的右孩子
        if (!str1[index].equals("#")) {
            node = new TreeNode(Integer.valueOf(str1[index]));
            node.left = deserialize(str);
            node.right = deserialize(str);
        }
        return node;
    }

    public static void preVisist(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        System.out.print(treeNode.value+",");
        TreeNode left = treeNode.left;
        TreeNode right = treeNode.right;
        preVisist(left);
        preVisist(right);
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
