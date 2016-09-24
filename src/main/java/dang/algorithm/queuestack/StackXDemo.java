package dang.algorithm.queuestack;

/**
*
*/
import java.io.*;
public class StackXDemo{
	public static void main(String[] args) throws IOException{
		/**
		String str = getStr();
		
		StackX stack = new StackX(100);
		for(int i=0; i<str.length(); i++) {
			stack.push(str.charAt(i));
		}
		
		String result = stack.reverse();
		System.out.println("" + result);
		**/
		
		String str = getStr();
		StackBracket sb = new StackBracket(100);
		boolean flag = sb.isMatching2(str);
		if(flag) {
			System.out.println("Matched.");
		}else {
			System.out.println("Sorry, not matched.");
		}
		
	}
	
	public static String getStr() throws IOException{
		
		InputStreamReader inputReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputReader);
		return bufferedReader.readLine();
	}
}