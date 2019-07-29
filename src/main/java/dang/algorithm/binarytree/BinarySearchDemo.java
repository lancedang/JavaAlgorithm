package dang.algorithm.binarytree;

/**
 * 二分查找demo
 */
public class BinarySearchDemo {
    public static void main(String[] args) {

        Integer[] intArray = {1, 3, 5, 6, 8, 10, 11, 15, 17, 24};
        Float[] floatArray = {0.1f, 1.2f, 2.9f, 3.0f, 5.2f};

        System.out.println("The first method: ");
        BinarySearchUtil.binarySearch(intArray, 0, intArray.length - 1, new Integer(111));

        System.out.println("The second method: ");
        BinarySearchUtil.binarySearch2(intArray, 111);

        System.out.println("The third method: ");
        BinarySearchUtil.binarySearch3(intArray, 0, intArray.length - 1, 111);
        //BinarySearchUtil.binarySearch(floatArray, 0, floatArray.length, new Float(5.2f));

    }
}