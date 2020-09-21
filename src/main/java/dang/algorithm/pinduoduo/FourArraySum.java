package dang.algorithm.pinduoduo;

import java.util.HashMap;
import java.util.Map;

public class FourArraySum {
    public static void main(String[] args) {

        int[] a = {1, 3, 4, 5};
        int[] b = {5, 6, 7, 8};
        int[] c = {11, 12, 13, 14};
        int[] d = {20, 21, 22, 23};

        findAllElement(a, b, c, d, 38);

    }

    /**
     * 找到4个数组中元素之和等于给定值的序列
     * 1.通过HashMap 计算两两数组所有和，并以sum作为key, sum的元素对个数作为value
     * 2.然后遍历两个map的keySet,找到key之和=total的元素对，做count=count + value1*value2
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @param total
     */
    public static void findAllElement(int[] a, int[] b, int[] c, int[] d, int total) {
        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();

        initMap(a, b, map1);
        initMap(c, d, map2);

        int count = 0;

        for (int x : map1.keySet()) {
            for (int y : map2.keySet()) {
                if (x + y == total) {
                    count = count + map1.get(x) * map2.get(y);
                }
            }
        }

        System.out.println("总共：" + count);

    }

    /**
     * 1.通过HashMap 计算两两数组所有和，并以sum作为key, sum的元素对个数作为value
     * 2.然后遍历两个map的keySet,找到key之和=total的元素对，做count=count + value1*value2
     *
     * @param a
     * @param b
     * @param map1
     */
    public static void initMap(int[] a, int[] b, Map<Integer, Integer> map1) {
        for (int x : a) {
            for (int y : b) {
                //两数之和作为key存储
                int key = x + y;
                if (map1.containsKey(key)) {
                    //在原来之上+1，表示多了一组相加=**的元素
                    map1.put(key, map1.get(key) + 1);
                } else {
                    //初始化
                    map1.put(key, 1);
                }
            }
        }
    }
}
