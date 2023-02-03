package dang.algorithm.advanceSort;

import java.util.Arrays;

public class PartitionUtil3 {
    public static void main(String[] args) {
        int[] array = {18, 30, 17, 22, 1, 4, 2 ,2 , 10};

        sort(array, 0, array.length - 1);

        Arrays.stream(array).forEach(System.out::println);

        System.out.println(".......................");

        int[] array2 = {-1, 0, 1, 2, -1, -4};
        sort(array2, 0, array2.length - 1);
        Arrays.stream(array2).forEach(System.out::println);

    }

    //更新-针对重复元素处理，原来不支持重复元素
    //一个快排算法：多次分区，一趟分区：多次swap,
    //一趟分区：从左开始-将所有大于flag的放到flag右边，从右开始-将所有小于flag的放到flag左边
    //一次swap:左右2个元素的一次交换，得多次swap之后才能将左边全部小于flag，右边全部大于flag
    public static int partition(int[] array, int left, int right) {
        //引用复制
        int start = left;
        int end = right;

        //left不变作为判断标准
        int flag = array[left];

        //没有这一个while的话，只是一次swap
        //while相当于以flag为基准，达到flag左侧全小，右侧全大的目的
        while (start < end) {

            //注意：pivot选的最左侧，则必须先从右边向左找，与下面的while不能调换先后顺序
            //这个地方影响下面的pivot归位
            //从右开始，找第一个小于flag的
            while (start < end && array[end] >= flag) {
                end--;
            }

            //从左开始，找第一个大于flag的
            while (start < end && array[start] <= flag) {
                start++;
            }

            //2边都找到，交换之
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }

        //3.这步骤至关重要，针对的是重复元素处理
        //目的：将左右汇聚地方，将array[left](pivot)处放置array[start]
        //将基准数放到中间的位置（基准数归位）
        array[left] = array[start];
        //将真正的pivot放到中间才行，
        array[start] = flag;

        return start;

    }

    public static void sort(int[] array, int left, int right) {
        int length = array.length;

        //递归跳出条件，每个
        if (left >= right) {
            return;
        }

        //1.先将初始数组分为2半，再递归分别处理左、右部分
        int start = partition(array, left, right);

        //2.左边递归
        //这里写成start-1比较好，更好的解释数组分成了2半，start位置的元素位置已经确定好了
        sort(array, left, start - 1);

        //3.右边递归
        sort(array, start + 1, right);
    }
}
