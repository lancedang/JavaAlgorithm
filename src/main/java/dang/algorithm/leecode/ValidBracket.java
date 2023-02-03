package dang.algorithm.leecode;

import javax.xml.stream.events.Characters;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidBracket {
    public static void main(String[] args) {
        String s = "()[]{}";
        String s2 = "(({})))";
        String s3 = "(({}))";
        System.out.println(isValid2("{[[}"));
        System.out.println(isValid2(s));
        System.out.println(isValid2(s2));
        System.out.println(isValid2(s3));
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
            } else {
                stack.push(curr);
            }
        }
        //6）判断标准，最终stack isEmpty
        return stack.isEmpty();
    }


    //23.2.3日颁布
    public static boolean isValid2(String s) {
        if (s == null) {
            return false;
        }
        if (s.equals("")) {
            return true;
        }

        Stack<Character> stack = new Stack();
        Map<Character, Character> map = new HashMap();

        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');

        int size = s.length();

        for (int i = 0; i < size; i++) {
            //System.out.println(new Integer(1).equals(1));


            Character c = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                //这个c可能在map的key中，也可能不存在
                Character head = stack.peek();

                Character oldC = map.get(head);

                //stack中若存储进去反括号了，oldC为null
                if (oldC == null) {
                    return false;
                } else {
                    if (oldC == c) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }

            }

        }
        return stack.isEmpty();

    }

    public boolean isValid3(String s) {
        //注意栈的使用
        Stack<Character> stack = new Stack();
        int size = s.length();

        //map的使用
        Map<Character, Character> map = new HashMap();

        //只存正括号(即左侧括号)
        //正确valid的字符串，使用栈的话，反括号不可能存在栈中
        //若栈中存在了反括号，意味着字符串inValid
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for(int i=0; i<size; i++) {
            char c = s.charAt(i);

            //如果stack为空
            if(stack.isEmpty()) {
                //stack为空，若当前c为正括号，进入stack,
                //若c为反括号，意味着这个字符串位inValid了
                Character curr = map.get(c);
                if(curr == null) {
                    return false;
                }
                stack.push(c);
            }else {
                //stack不为空
                //取出当前元素
                char head = stack.peek();

                //原则上，若stack中有元素，则一定是正括号
                Character value = map.get(head);

                //正确valid的字符串，使用栈的话，反括号不可能存在栈中
                //若栈中存在了反括号，意味着字符串inValid
                //null表示栈中存的是反括号
                if(value == null) {
                    return false;
                }

                //若栈顶的正括号对应的反括号和c相同，则弹出，否则入栈
                if(value == c) {
                    stack.pop();
                }else {
                    stack.push(c);
                }

            }


        }
        //判断条件
        return stack.isEmpty();
    }

}
