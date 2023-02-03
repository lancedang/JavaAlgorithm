package dang.algorithm.leecode;

public class NumberKLargestItem {
    public static void main(String[] args) {
        int[] array = {18, 30, 17, 22, 1, 4, 2, 10};
        int kLargestItem = getNumberKLargestItem(array, 2);
        System.out.println(kLargestItem);

        int smallestItem = getNumberKSmallestItem(array, 2);
        System.out.println(smallestItem);
    }


    public static int getNumberKSmallestItem(int[] array, int k) {
        int size = array.length;

        //一趟分区之后确定flag元素最终的位置，flag默认是left位置的元素
        //这个位置就固定了
        int flagIndex = partition(array, 0, size - 1);
        while (true) {
            //第k小元素是下标k-1处的元素
            if ((k-1) == flagIndex) {
                return array[flagIndex];
            } else if ((k-1) < flagIndex) {
                //若k-1小于flagIndex,再左边找
                flagIndex = partition(array, 0, flagIndex - 1);
            } else {
                flagIndex = partition(array, flagIndex + 1, size - 1);
            }
        }


    }

    public static int getNumberKLargestItem(int[] array, int k) {
        int size = array.length;

        //一趟分区之后确定flag元素最终的位置，flag默认是left位置的元素
        //这个位置就固定了
        int flagIndex = partition(array, 0, size - 1);
        while (true) {
            //第k大元素=第size-k小元素
            //跳出条件
            if ((size - k) == flagIndex) {
                //返回的下标执行的元素
                return array[flagIndex];
            } else if ((size - k) < flagIndex) {
                flagIndex = partition(array, 0, flagIndex - 1);
            } else {
                flagIndex = partition(array, flagIndex + 1, size - 1);
            }
        }


    }

    //一次分区可以找到flag元素的下标位置，也就是第k小值元素的位置，k=return+1
    public static int partition(int[] array, int left, int right) {
        //引用复制
        int start = left;
        int end = right;

        int flag = array[left];

        while (start < end) {
            while (array[start] < flag) {
                start++;
            }
            while (array[end] > flag) {
                end--;
            }

            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }

        //这个非常关键：start位置是flag元素下标
        return start;
    }
}
