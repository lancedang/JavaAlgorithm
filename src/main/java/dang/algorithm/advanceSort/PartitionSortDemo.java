package dang.algorithm.advanceSort;

public class PartitionSortDemo {
    public static void main(String[] args) throws Exception {
        int[] array = {18, 30, 17, 22, 1, 4, 2 ,2 , 10};

        PartitionUtil2.quickSort(array, 0, array.length - 1);

        for (int x : array) {
            System.out.println(x);
        }

    }
}
