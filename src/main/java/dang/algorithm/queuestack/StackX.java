package dang.algorithm.queuestack;

/**
*
*/
public class StackX{
	private char[] container;
	private int maxSize;
	private int top;	//stack top pointer, also can be seen as elements number
	
	public StackX(int maxSize) {
		this.maxSize = maxSize;
		container = new char[maxSize];
		top = -1;
	}
	
	/**
	* Get the top element from stack just like remove/delete the top one
	* 
	* @return the top element
	*/
	public char pop() {
		return container[top --];
	}
	
	public void push(char c) {
		
		if (!isFull()) {
			container[++ top] = c;
		}else {
			System.out.println("The stack is full.");
		}
	}
	
	public char peek() {
		return container[top];
	}
	
	
	public String reverse() {
		String str = "";
		while(!isEmpty()) {
			char c = pop();
			str += c;
		}
		
		return str;
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean isFull() {
		return (top == maxSize - 1);
	}
	
}