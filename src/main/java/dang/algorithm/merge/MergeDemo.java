package dang.algorithm.merge;

public class MergeDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
		
		/*
		MergeExam exam = new MergeExam();
		int an = exam.getAn(4);
		int an2 = exam.getAnLoop(4);
		System.out.println(an2);
		*/

        int[] arr = {1, 3, 5, 19, 22, 28, 31, 31, 45};
        int index = BinaryFindUtil.recursiveBinaryFind(arr, 0, arr.length - 1, 31);
        int index2 = BinaryFindUtil.loopBinaryFind(arr, 0, arr.length - 1, 31);

        System.out.println(index);
        System.out.println(index2);
    }

}
