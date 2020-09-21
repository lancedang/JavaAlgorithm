package dang.algorithm.pinduoduo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SuffixExpression {

    private static final List<Character> operator = new ArrayList<Character>(4);

    static {
        operator.add('+');
        operator.add('-');
        operator.add('*');
        operator.add('/');
    }

    public static void main(String[] args) {
        char c = '5';
        int x = c;
        //输出5:5
        System.out.println(c + ":" + (x - '0'));
        //输出5
        System.out.println(Integer.parseInt(String.valueOf(c)));

        calSuffixExpression("235++2/3*");
    }

    /**
     * 计算后缀表达式，当时手写的，没有写很严谨，一定要处理各种边界/错误情况，避免被挂
     * 注意点：
     * 1.stack.pop元素作为操作数的前后顺序
     * 2.负数确定要不要处理，会不会出现（此例认定负数为error情况）
     * 3.考虑输入abc这种字符
     *
     * @param input
     */
    public static void calSuffixExpression(String input) {
        if (input == null || "".equals(input.trim())) {
            System.out.println("input is empty");
            return;
        }

        char[] array = input.toCharArray();

        //stack只存操作符，故设为int类型即可，不需要设为Character类型
        Stack<Integer> stack = new Stack<Integer>();

        for (char c : array) {
            if (operator.contains(c)) {
                //每当出现operator时，stack必须至少2个元素
                if (stack.size() < 2) {
                    System.out.println("expression error");
                    return;
                } else {
                    int var1 = stack.pop();
                    int var2 = stack.pop();
                    int var;
                    switch (c) {
                        case '+':
                            var = var1 + var2;
                            break;
                        case '-':
                            var = var2 - var1;
                            if (var < 0) {
                                System.out.println("expression error");
                                return;
                            }
                            break;
                        case '*':
                            var = var1 * var2;
                            break;
                        case '/':
                            if (var1 == 0) {
                                System.out.println("expression error");
                                return;
                            }
                            var = var2 / var1;
                            break;
                        default:
                            System.out.println("expression error");
                            return;
                    }

                    stack.push(var);
                }
            } else if (Character.isDigit(c)) {
                stack.push(Integer.parseInt(String.valueOf(c)));
            } else {
                System.out.println("expression error");
                return;
            }
        }

        if (stack.size() > 1) {
            System.out.println("expression error");
        } else {
            System.out.println(stack);
        }
    }
}
