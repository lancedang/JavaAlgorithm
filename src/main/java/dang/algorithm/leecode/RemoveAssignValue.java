package dang.algorithm.leecode;

import java.util.Arrays;

public class RemoveAssignValue {

    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int[] array2 = new int[]{3,2, 2, 3};

        int index = removeElement(array, 2);

        int i = removeElement(array2, 3);

        Arrays.stream(array).limit(index).forEach(System.out::print);
        System.out.println();
        Arrays.stream(array2).limit(i).forEach(System.out::print);
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0; //i用于描述最终满足条件的元素将要插入到何处的下标索引
        int j = 0; //j用于从前往后遍历数组的指针

        while (j < nums.length) {
            //因为是用j遍历，所以对nums[j]进行判断
            //遍历j发现不等于给定值，说明找到了目标值(最终要保留到数组中的值)，将其复制到i处
            //此处注意，找到了目标值后，需将目标值赋值到i处
            if (nums[j] != val) {
                nums[i] = nums[j];
                j++; //继续向后遍历
                i++; //存储index i也向后移动一下
            } else if (nums[j] == val) { //找到了可以去掉的元素，继续遍历寻找与给定值不同的元素
                j++;
            }
        }

        return i;

    }

}
