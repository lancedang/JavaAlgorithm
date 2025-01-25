package dang.algorithm.advanceSort;

public class PartitionUtil4 {
    public static void main(String[] args) {
        int[] array = {18, 30, 17, 22, 1, 4, 2, 2, 10};
        sort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void sort(int[] nums, int begin, int end) {
        //这个不能决定跳出递归
        if (nums == null || nums.length == 0) {
            return;
        }

        //这个才能跳出递归
        if (begin >= end) {
            return;
        }

        int mid = partition(nums, begin, end);

        sort(nums, begin, mid - 1);
        sort(nums, mid + 1, end);

    }

    public static int partition(int[] nums, int left, int right) {

        int start = left;
        int end = right;

        //用于存储坑位置，把坑想象成一个空空的洞洞/盒子/碗/盆，无所谓啥也行
        //也可以理解成，把left那个地方原来值挖出来，保存到hole中，原来那位置就相当于一个坑了
        int flag = nums[left];
        //用于记录，当前坑的位置/索引
        int holeIndex = left;

        while (start < end) {
            //1.从右侧开始向左遍历，找到第一个小于坑处原来那个数，
            while (nums[end] >= flag && start < end) {
                end--;
            }

            //2.将该元素放到前面的坑的地方
            //3.该元素end处，形成新的坑（新挖一个坑在这）
            nums[holeIndex] = nums[end];

            holeIndex = end;

            //开始从左向右遍历，找到第一个大于最初flag元素,将其放到前面新挖的坑
            while (nums[start] <= flag && start < end) {
                start++;
            }

            //将左边找到的大于flag元素放到右边的新坑那
            nums[holeIndex] = nums[start];
            holeIndex = start;

        }

        //最终设置flag 标杆到最终的那个坑那
        //注：这里尽量使用holeIndex来定位、存储flag
        //也可以用用最后的start(holeIndex来源于start)
        nums[holeIndex] = flag;

        //并且返回该位置
        return holeIndex;

    }
}
