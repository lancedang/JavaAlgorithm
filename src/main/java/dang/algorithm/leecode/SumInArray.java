package dang.algorithm.leecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumInArray {
    public static void main(String[] args) {
        int[] a = new int[]{3, 3};
        int[] r = m2(a, 6);
        System.out.println(r[0]+","+r[1]);

        int x = -123;
        System.out.println(x % 10);
        System.out.println(x / 10);

    }

    public static int[] m2(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            //1)保存 value:index的map,通过hashMap的containsKey替代遍历数组
            if(map.containsKey(target-nums[i])){
                return new int[]{i, map.get(target-nums[i])};
            }
            //2)数组有重复元素的情况，也支持
            map.put(nums[i], i);
        }

        return  new int[2];
    }
}
