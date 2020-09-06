package dang.algorithm.advanceSort;

import java.util.LinkedList;

public class PartitionUtil2 {

    public static int partition(int[] array, int left, int right, int pivot) throws Exception {

        int length = array.length;

        //right不超过数组长度
        if (right > length - 1) {
            System.out.println("right index outofbounds");
            throw new Exception("right index outofbounds");
        }

        //要将左右数组各自遍历完，达到左侧<pivot<右侧的目的
        while (true) {

            while (left < right && array[left] < pivot) {
                left++;
            }

            while (left < right && array[right] > pivot) {
                right--;
            }

            if (left >= right) {
                //说明pivot两边已经划分完
                break;
            } else {
                //System.out.println("hh");
                //交换两边元素
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
            }
        }
        return left;
    }

    /**
     * 指明left，right，可以只对array的指定范围内进行快速排序
     *
     * @param array
     * @param left
     * @param right
     */
    public static void quickSort(int[] array, int left, int right) throws Exception {

        if (left >= right) {
            return;
        }
        //这里要注意：
        // 1. left,right作为值传递，且为基本数据类型，重复使用不会出问题，partition方法体改变了left，right值也没关系
        // 2. 默认以index为left的元素作为pivot
        int index = partition(array, left, right, array[left]);
        //递归对数组left,index区间做排序-左部分
        quickSort(array, left, index);
        //递归对数组index+1,right区间做排序-右部分
        quickSort(array, index + 1, right);

    }



}
