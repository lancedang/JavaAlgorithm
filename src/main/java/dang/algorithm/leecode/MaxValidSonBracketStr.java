package dang.algorithm.leecode;

import java.util.Stack;

//最长有效字符串
public class MaxValidSonBracketStr {
    public static void main(String[] args) {
        String s = "(())";
        System.out.println(maxValid(s));

        String s2 = ")()())";
        System.out.println(maxValid(s2));
    }

    public static int maxValid(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return 0;
        }
        int length = s.length();
        Stack<Integer> stack = new Stack();

        int max = 0;
        int start = 0;

        for (int i = 0; i < length; i++) {
            Character curr = s.charAt(i);

            if (curr == '(') {
                stack.push(i); //针对"(("这种
            } else { //碰到 ')' 时
                if (stack.isEmpty()) { //
                    //针对这种"))这种"情况，这种说明前面的"))"不是有效str
                    start = i + 1;
                    continue;
                } else { //说明stack中有"("
                    stack.pop();//pop之后也可能stack为空呀,这个pop先取出和当前")"对应的char

                    if (stack.isEmpty()) { //这个是针对"()()"这种了
                        max = Math.max(max, i - start + 1);
                    } else { //针对"(())",
                        //关键是这里的stack.peek()相当于只取了这个值，没有存栈中删除，下一次循环还会用到
                        //至于为啥?我还没理解
                        max = Math.max(max, i - stack.peek());
                    }


                }
            }

        }

        return max;

    }
}
