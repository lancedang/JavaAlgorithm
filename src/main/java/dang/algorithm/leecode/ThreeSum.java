package dang.algorithm.leecode;

import dang.algorithm.advanceSort.PartitionUtil3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] array = {-1, 0, 1, 2, -1, -4};

        array = new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        array = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};

        PartitionUtil3.sort(array, 0, array.length - 1);
        Arrays.stream(array).forEach(System.out::println);
        //List<List<Integer>> sum = find3Sum2(array, 0);
        List<List<Integer>> sum = sum2(array, 0);
        System.out.println(sum);
    }

    //没有相邻元素去重，速度LeetCode超时，且有重复元素
    public static List<List<Integer>> find3Sum(int[] array, int target) {
        List<List<Integer>> result = new ArrayList<>();

        int size = array.length;

        for (int i = 0; i < size; i++) {

            int curr = array[i];
            int anotherSum = target - curr;

            int j = i + 1;
            int k = size - 1;

            while (j < k) {
                if (array[j] + array[k] == anotherSum) {
                    //old方式，去重，速度慢
                    //
                    // result.add(Arrays.asList(array[i], array[j], array[k]));
                    addItem2List(result, Arrays.asList(array[i], array[j], array[k]));
                    j++;
                    k--;
                } else if (array[j] + array[k] < anotherSum) {
                    j++;
                } else {
                    k--;
                }
            }

        }
        return result;
    }


    //针对有序数组进行3元祖之和
    public static List<List<Integer>> find3Sum2(int[] nums, int target) {

        int size = nums.length;
        List<List<Integer>> result = new ArrayList();

        //有序之后，从前往后遍历
        for (int i = 0; i < size; i++) {
            int j = i + 1;
            int k = size - 1;

            int curr = nums[i];
            int another = target - curr;

            //1.重复去重step1
            //在针对每个i遍历的时候，若i和i-1的元素相同，则跳到下一个循环
            //-1,-1,3,4这种i从第一个元素，走到第2个元素-1的时候，第2个-11其实不需要遍历了
            //这种直接跳过就行
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (j < k) {
                if (nums[j] + nums[k] == another) {

                    //addItem2List(result, Arrays.asList(nums[i], nums[j],nums[k]));
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    //先将左游标+1，
                    j++;
                    k--;

                    //2.重复去重step2
                    //若左游标+1后和之前相同也得跳过
                    //针对，-1,2,2,3,4,5 i=0,j=1,j=2的时候
                    while (nums[j] == nums[j - 1] && j < k) {
                        j++;
                    }
                    //3.重复去重step3
                    //若右游标-1后和之前相同也得跳过
                    //针对，-1,2, 3, 4, 5, 6, 6针对k从最后一个6走到倒数第2个6的时候
                    //倒数第2个6要跳过
                    while (nums[k] == nums[k + 1] && j < k) {
                        k--;
                    }

                } else if (nums[j] + nums[k] < another) {
                    j++;
                } else {
                    k--;
                }
            }

        }

        return result;

    }

    //也不需要了，传统比较重复list方式
    public static void addItem2List(List<List<Integer>> total, List<Integer> item) {
        for (List<Integer> old : total) {
            if (listEquals(old, item)) {
                return;
            }
        }
        total.add(item);
    }

    //这个不需要了，通过相邻元素去重来代替
    public static boolean listEquals(List<Integer> a, List<Integer> b) {
        return a.containsAll(b) && b.containsAll(a);
    }


    //快排工具
    public static void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int index = partition(nums, left, right);
        sort(nums, left, index - 1);
        sort(nums, index + 1, right);
    }

    public static int partition(int[] nums, int left, int right) {
        int start = left;
        int end = right;

        int pivot = nums[left];

        while (start < end) {

            while (start < end && nums[end] >= pivot) {
                end--;
            }

            while (start < end && nums[start] <= pivot) {
                start++;
            }

            //交换
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;

        }

        //pivot归位
        nums[left] = nums[start];
        nums[start] = pivot;

        return start;
    }

    public static List<List<Integer>> sum2(int[] array, int target) {

        if (array == null || array.length < 3) {
            return null;
        }

        int size = array.length;

        List<List<Integer>> list = new ArrayList();

        int i = 0;
        int j = i + 1;
        int k = size - 1;

        while (i < size - 2) {

            k = size - 1;

            while (j < k) {
                int tempSum = array[i] + array[j] + array[k];

                if (tempSum == target) {
                    List<Integer> tempList = new ArrayList();
                    tempList.add(array[i]);
                    tempList.add(array[j]);
                    tempList.add(array[k]);

                    list.add(tempList);

                    j++;
                    k--;

                    while (j < k && array[j] == array[j - 1]) {
                        j++;
                    }

                    while (j < k && array[k] == array[k + 1]) {
                        k--;
                    }

                } else if (tempSum < target) {
                    j++;

                } else {
                    k--;

                }
            }

            i++;
            ;
            j = i + 1;

            if (i > 0 && array[i] == array[i - 1]) {
                i++;
                ;
                j = i + 1;
            }

        }

        return list;

    }


}
