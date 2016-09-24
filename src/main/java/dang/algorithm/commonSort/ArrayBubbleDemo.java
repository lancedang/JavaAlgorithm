package dang.algorithm.commonSort;

public class ArrayBubbleDemo{
	public static void main(String[] args) {
		ArrayBubble longArray = new ArrayBubble(10);
		
		longArray.tailInsert(24);
		longArray.tailInsert(12);
		longArray.tailInsert(11);
		longArray.tailInsert(60);
		longArray.tailInsert(60);
		longArray.tailInsert(29);
		
		longArray.display();
		
		longArray.bubbleSort2();
		longArray.display();
		longArray.bubbleSort();
		
		
		//longArray.deleteMax(max);
		longArray.display();
		
	}
}