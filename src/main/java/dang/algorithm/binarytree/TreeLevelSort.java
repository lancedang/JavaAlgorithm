package dang.algorithm.binarytree;

import dang.algorithm.linklist.Link;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//@Slf4j
public class TreeLevelSort {

    public static void levelSort(MySimpleNode root) {

        LinkedList<MySimpleNode> queue = new LinkedList<MySimpleNode>();

        MySimpleNode current = root;
        //先将根节点放到队列中
        queue.add(current);

        while (!queue.isEmpty()) {
            MySimpleNode tempRoot = queue.poll();
            //遍历父节点
            System.out.print(tempRoot.getValue() + ",");
            MySimpleNode leftMyNode = tempRoot.getLeftMyNode();
            MySimpleNode rightMyNode = tempRoot.getRightMyNode();

            //插入左节点到队列
            if (leftMyNode != null) {
                queue.add(leftMyNode);
            }
            //插入右节点到队列
            if (rightMyNode != null) {
                queue.add(rightMyNode);
            }
        }


    }


    public static void levelSort2(MySimpleNode root) {

        LinkedList<MySimpleNode> queue = new LinkedList<MySimpleNode>();

        MySimpleNode current = root;
        //先将根节点放到队列中
        queue.add(current);

        while (!queue.isEmpty()) {

            int size = queue.size();
            //加上while size>0 跟上面层次遍历是一样的,可以通过这种方式构造自下而上的层次遍历
            while (size > 0) {
                MySimpleNode tempRoot = queue.poll();
                //遍历父节点
                System.out.print(tempRoot.getValue() + ",");


                MySimpleNode leftMyNode = tempRoot.getLeftMyNode();
                MySimpleNode rightMyNode = tempRoot.getRightMyNode();

                //插入左节点到队列
                if (leftMyNode != null) {
                    queue.add(leftMyNode);
                }
                //插入右节点到队列
                if (rightMyNode != null) {
                    queue.add(rightMyNode);
                }
                size--;
            }

        }
    }

    public static void levelSortFromBottom2Up(MySimpleNode root) {
        if (root == null) {
            return;
        }
        MySimpleNode current = root;
        Queue<MySimpleNode> queue = new LinkedList();
        LinkedList<LinkedList<MySimpleNode>> result = new LinkedList<LinkedList<MySimpleNode>>();
        LinkedList<MySimpleNode> rootList = new LinkedList<MySimpleNode>();
        rootList.add(current);
        result.add(rootList);
        queue.add(current);

        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();

            //每层构造一个临时list存放当前层的数据
            LinkedList<MySimpleNode> currentLevelList = new LinkedList<MySimpleNode>();

            for (int i = 0; i < currentLevelSize; i++) {
                //层次遍历,访问第一层
                MySimpleNode tempRoot = queue.poll();

                MySimpleNode leftMyNode = tempRoot.getLeftMyNode();
                MySimpleNode rightMyNode = tempRoot.getRightMyNode();

                if (leftMyNode != null) {
                    queue.add(leftMyNode);
                    currentLevelList.add(leftMyNode);
                }
                if (rightMyNode != null) {
                    queue.add(rightMyNode);
                    currentLevelList.add(rightMyNode);
                }
            }

            if (!currentLevelList.isEmpty()) {
                result.add(0, currentLevelList);

            }

        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

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

        //levelSort2(root);
        System.out.println("-----------------");
        levelSortFromBottom2Up(root);
    }

}
