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

        //int[] y = new int[] {3,2,4};
        int[] y = new int[] {3,3};
        int[] dd = m3(y, 6);
        System.out.println(dd[0]+","+dd[1]);

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

    public static int[] m3(int[] nums, int target) {
        int size=nums.length;
        //for循环写法呢
        if(size < 2) {
            //特殊情况处理
            return new int[]{};
        }

        Map<Integer, Integer> map = new HashMap<>();

        //先进行一次循环，存入value-index的entry
        //对于重复元素，map中保存的是后面最新的index,前面的index被覆盖
        //本题没有任何关系
        for(int x=0;x<size;x++) {
            map.put(nums[x], x);
        }

        //从前往后遍历
        for(int i=0;i<size;i++) {
            //另外一个元素是多少operate2
            int other = target-nums[i];
            //如果存在另外一个operate2的entry
            if(map.containsKey(other)) {
                //获取其对应的数组下标
                Integer second = map.get(other);

                //map因为是第一次遍历插入的，3,2，4=6这种情况会取出0,0
                //3,2,4=6, 遍历第一个元素时，i=0; operate2是6-3=3;map中还是get(3)其实是同一个元素
                //即i和second不能是同一个数组下标
                if (i == second) {
                    continue;
                }
                //即i和second不能是同一个数组下标
                return new int[] {i, second};
            }
        }
        return new int[] {};

    }
}
