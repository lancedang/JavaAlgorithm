package dang.algorithm.advanceSort;

/**
 * PartitionUtil包括快速排序
 *
 * @author Dangdang
 */
public class PartitionUtil {

    public static void main(String[] args) {
        int[] array = {18, 30, 17, 22, 1, 4, 2 ,2 , 10};

        quickSort(array, 0, array.length - 1);

        for (int x : array) {
            System.out.println(x);
        }
    }

    /**
     * 将任意数组分成以pivot为枢纽左右两部分，左部分小于pivot，右部分大于pivot
     *
     * @param array 将要划分的数组
     * @param left  划分数组左侧起始下标
     * @param right 划分数组右侧结束下标
     * @param pivot 划分标杆
     * @return 返回以pivot为枢纽划分后的数组
     */
    public static void partition(int[] array, int left, int right, int pivot) {
        int start = left;
        int end = right;

        if (array == null || array.length == 0) {
            System.out.println("Array is null or empty. ");
            return;
        }

        int size = array.length;

        if (end > size - 1) {
            System.out.println("Out of index Exception.");
            return;
        }

        while (true) { // "直到/一直"的实现一般靠while关键字实现

            while (start < end && array[start] < pivot) { // 左指针一直向右移动，直到找到第一个大于pivot的值
                start++;
            }

            while (end > start && array[end] > pivot) { // 右指针一直向左移动，直到找到第一个小于pivot的值
                end--;
            }

            if (start < end) {
                swap(array, start, end);
            } else {
                break;
            }
        }

    }

    /**
     * 以pivot为中枢将数组分裂，返回边界中枢的下标
     *
     * @param array
     * @param left
     * @param right
     * @param pivot
     * @return
     */
    public static int partition2(int[] array, int left, int right, int pivot) {
        int start = left;
        int end = right;

        while (true) { // "直到/一直"的实现一般靠while关键字实现

            while (start < end && array[start] < pivot) { // 左指针一直向右移动，直到找到第一个大于pivot的值
                start++;
            }

            while (end > start && array[end] > pivot) { // 右指针一直向左移动，直到找到第一个小于pivot的值
                end--;
            }

            if (start < end) { // 跳出外循环，划分结束，swap之后，while内循环才会重新开始
                swap(array, start, end);
            } else {
                break;
            }
        }

        return start;
    }

    /**
     * 快排算法，对整型数组排序
     *
     * @param array
     * @param left  排序数组的起始下标
     * @param right 排序数组的结束下标
     */
    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        } else {
            int index = partition2(array, left, right, array[left]);
            quickSort(array, left, index - 1);
            quickSort(array, index + 1, right);
        }
    }

    /**
     * 交换数组下标为 a,b 的两个元素
     *
     * @param array
     * @param a
     * @param b
     */
    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }



}
