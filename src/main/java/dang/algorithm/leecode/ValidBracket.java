package dang.algorithm.leecode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidBracket {
    public static void main(String[] args) {
        System.out.println(isValid("{[[}"));
    }
    public static boolean isValid(String s) {

        //1）前几步：null ,空判断
        if (s == null) {
            return false;
        }
        if ("".equals(s)) {
            return true;
        }
        int len = s.length();

        //2)是否偶数判断
        if (len % 2 != 0) {
            return false;
        }
        //3)stack存储，构造方式必须是char的包装类 Character
        Stack<Character> stack = new Stack<Character>();

        //Map保存Character对应关系
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');


        //4)非常关键：先将首字符存到栈中，剩下的不断push,pop，最终结论的判别标准是stack是否为空
        stack.push(s.charAt(0));
        for (int i = 1; i < len; i++) {
            char curr = s.charAt(i);
            //5)区分peek和pop的区别，peek不会remove，pop会remove
            //用map获取对应的value
            if (map.get(stack.peek()) == curr) {
                stack.pop();
            }else {
                stack.push(curr);
            }
        }
        //6）判断标准，最终stack isEmpty
        return stack.isEmpty();
    }
}
