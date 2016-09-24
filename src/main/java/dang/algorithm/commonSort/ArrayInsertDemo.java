package dang.algorithm.commonSort;

public class ArrayInsertDemo{
	public static void main(String[] args) {
		ArrayInsert longArray = new ArrayInsert(10);
		
		longArray.tailInsert(24);
		longArray.tailInsert(12);
		longArray.tailInsert(11);
		longArray.tailInsert(60);
		longArray.tailInsert(50);
		longArray.tailInsert(29);
		
		longArray.display();
		
		longArray.insertSort();
		
		//longArray.selectSort3();
		
		longArray.display();
		
		//longArray.bubbleSort2();
		
		//longArray.deleteMax(max);
		//longArray.display();
		
	}
}