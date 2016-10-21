package dang.algorithm.advanceSort;

import java.util.ArrayList;

public class PartDemo {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		String[] strArray = new String[] { "red", "yellow", "Black", "Green" };
		String t = null;
		System.out.println("排序前");
		for (String s : strArray)
			System.out.print(s + "\t");
		int i, j, k;
		for (i = 0; i < strArray.length - 1; i++) {
			k = i;
			for (j = i + 1; j < strArray.length; j++) {
				Character c1 = Character.valueOf(strArray[j].charAt(0));
				Character c2 = Character.valueOf(strArray[k].charAt(0));
				if (c1.compareTo(c2) < 0)
					k = j;
			}
			if (i != k) {
				t = strArray[i];
				strArray[i] = strArray[k];
				strArray[k] = t;
			}
		}
		System.out.println("\n排序后:");
		for (String s : strArray)
			System.out.print(s + "\t");
	}

	public static double fee(double x) {
		if (x <= 3) {
			return 5;
		} else if (x > 3 && x <= 30.5) {
			return 5 + (x - 3) * 2;
		} else {
			return 50;
		}
	}
}
