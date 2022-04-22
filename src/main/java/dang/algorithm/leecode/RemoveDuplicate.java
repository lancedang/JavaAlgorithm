package dang.algorithm.leecode;

import java.util.Arrays;

public class RemoveDuplicate {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 1, 1, 2, 2, 2, 3, 5};
        int i = removeDuplicates(arr);
        System.out.println(i);
        Arrays.stream(arr).forEach(item -> System.out.print(item + ","));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int i = 0;
        int j = 1;
        while (j < nums.length) { //6)j值走到最后了就替换完了
            //1)若相邻元素相同，则后面的j递增，目的是：找到第一个大于递增的值
            if (nums[i] == nums[j]) {
                j++;
            } else if (nums[i] < nums[j]) {
                //2）找到了首个自增的值
                //3）找到首个递增的值索引j后，i,j之间的所有值(若存在)则全部是相同的
                //4) 用j的低增值，复制注意这里是复制到i+1处，相当于把i紧随的下个值改为查到的低增值
                i++;
                nums[i] = nums[j];
                //5) 这里++也行，不加走到上面的if
                j++;
            }
        }
        //7）i值表示当前的数据索引
        return i + 1;
    }
}
