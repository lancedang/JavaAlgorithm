package com.dangdang.JavaAlgorithm;

public class Demo {
	public static void main(String[] args) {
		int i = 3;
		// i++;
		// System.out.println(++i);
		// System.out.println(i++);
		System.out.println("i++/2 = " + i++ / 2);
		System.out.println("i = " + i);

		System.out.println("2/(2*3) = " + 2 / (2 * 3));
		System.out.println("2/2*3 = " + 2 / 2 * 3);

		//show(i++);

		System.out.println("i = " + i);

		String str = "000";
		char[] arr = { '0', '0', '0' };

		change(str, arr);
		System.out.println(str + " and " + String.valueOf(arr));

	}

	public static void change(String str, char[] arr) {
		str = "hello";
		arr[0] = '1';
	}

	int i = 2;

	public void show(int i) {
		this.i++;
		i++;
	}

}
