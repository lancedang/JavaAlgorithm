package dang.algorithm.merge;

public class MergeExam {
	int[] array = new int[20];
	
	/**
	 * 递归
	 * @param n
	 * @return
	 */
	public int getAn(int n) {
		if(n == 0) {
			array[0] = 1;
			return array[0];
		}
		return getAn(n - 1) + n + 1;
	}
	
	/**
	 * 循环
	 * @param n
	 * @return
	 */
	public int getAnLoop(int n) {
		if(n == 0) {
			array[0] = 1;
			return array[0];
		}
		int a = 1;
		for(int i=2; i<=n+1; i++) {
			a = a + i;
		}
		
		return a;
	}
}
