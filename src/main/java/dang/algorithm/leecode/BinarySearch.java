package dang.algorithm.leecode;

//在排序数组中查找元素的第一个和最后一个位置,要求logn时间复杂度
public class BinarySearch {
    public static void main(String[] args) {
        int[] intArray = {1, 3, 3, 3, 5, 6, 8, 10, 11, 11, 11, 15, 17, 24};
        System.out.println(binarySearch1(intArray, 3));
        System.out.println(binarySearchSupportRepeatElement(intArray, 11, true));
        System.out.println(binarySearchSupportRepeatElement(intArray, 11, false));

        int[] intArray2 = {1};

        System.out.println(binarySearchSupportRepeatElement(intArray2, 1, true));
    }

    //不存在返回-1，存在返回target index
    //针对不重复元素递增序列查询，若出现重复元素，返回的可能是target位置不定
    public static int binarySearch1(int[] array, int target) {

        int length = array.length;

        int start = 0;
        int end = length - 1;

        //等号针对一个元素情况
        while (start <= end) {

            //不区分奇偶性
            int mid = (end - start) / 2;

            int middle = array[mid];

            if (middle == target) {
                //因为元素不重复，直接返回即可
                //若array元素有重复，则返回的可能是首个，也可能是末尾，index不定
                return mid;
            }

            if (middle < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }


    /**
     * 针对可能存在重复元素的递增序列，且返回target的首个位置
     *
     * @param array
     * @param target
     * @param isFirst，isFirst就找重复的第一个，否则找最后一个的位置
     * @return
     */
    public static int binarySearchSupportRepeatElement(int[] array, int target, boolean isFirst) {

        int length = array.length;

        //初始的
        int start = 0;
        int end = length - 1;

        //while不断循环的变量和while结束的条件
        //若{1}，target=1这种必须有=,即start<=end
        //问题1：带不带等于号，带，情况如上
        while (start <= end) {

            //问题2：不区分奇偶性，且计算的下标的中位数，比如，1，2,3 ,4,5,6，start=3(元素4); end=5(元素6）
            //不能写成(end-start)/2,这么算算出来的是长度的一半，不是index
            int mid = (end + start) / 2;

            int middle = array[mid];

            //跳出while循环的终点
            if (middle == target) {
                //不能直接返回有可能该位置前后存在相同元素
                //return mid;
                //针对重复元素思想：中心扩散，向左扩散找首个，向右扩散找最后一个，以首个位置为demo
                int temp = mid;

                if (isFirst) { //找第一个
                    //问题3：判断条件的先后顺序，先判断index是否符合，再判断值是否相等，否则arrayOutOfIndex
                    while (temp >= start && array[temp] == target) {
                        temp--;
                    }
                    //注意这个地方得+1，因为上面的循环是指：如果等于target则，temp一直--，相当于走到了<target的位置
                    //故，返回temp的下一个
                    return temp + 1;
                } else { //找最后一个
                    while (temp <= end && array[temp] == target) {
                        temp++;
                    }
                    //注意：这个地方也得-1
                    return temp - 1;
                }

            }

            if (middle < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        return -1;
    }


    //直接返回首个、末尾位置的数组
    public static int[] binarySearchSupportRepeatElement2(int[] array, int target) {

        int length = array.length;

        int[] result = new int[2];

        //初始的
        int start = 0;
        int end = length - 1;

        //while不断循环的变量和while结束的条件
        //若{1}，target=1这种必须有=,即start<=end
        //问题1：带不带等于号，带，情况如上
        while (start <= end) {

            //问题2：不区分奇偶性，且计算的下标的中位数，比如，1，2,3 ,4,5,6，start=3(元素4); end=5(元素6）
            //不能写成(end-start)/2,这么算算出来的是长度的一半，不是index
            int mid = (end + start) / 2;

            int middle = array[mid];

            //跳出while循环的终点
            if (middle == target) {
                //不能直接返回有可能该位置前后存在相同元素
                //return mid;
                //针对重复元素思想：中心扩散，向左扩散找首个，向右扩散找最后一个，以首个位置为demo
                int temp = mid;
                int temp2 = mid;

                //找第一个
                //问题3：判断条件的先后顺序，先判断index是否符合，再判断值是否相等，否则arrayOutOfIndex
                while (temp >= start && array[temp] == target) {
                    temp--;
                }
                //注意这个地方得+1，因为上面的循环是指：如果等于target则，temp一直--，相当于走到了<target的位置
                //故，返回temp的下一个
                result[0] = temp + 1;
                //找最后一个
                while (temp2 <= end && array[temp2] == target) {
                    temp2++;
                }
                //注意：这个地方也得-1
                result[1] = temp2 - 1;

                //原来这里返回的是首个、末尾target的index，现在把这2个都找出来
                //按照数组方式返回
                return result;
            }

            if (middle < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        return new int[] {-1, -1};
    }
}
