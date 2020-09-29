package dang.algorithm.xiaomi;

import java.util.Stack;

public class Stack2CreateQueue {

    private static Stack<Integer> stack1 = new Stack<Integer>();
    private static Stack<Integer> stack2 = new Stack<Integer>();

    public static void main(String[] args) {
        insert(1);
        insert(2);
        get();
        insert(3);
        get();
        insert(4);
        insert(5);
        insert(6);
        get();
    }

    /**
     * 插入元素
     *
     * @param input
     */
    public static void insert(int input) {
        stack1.push(input);
    }

    /**
     * 每次get获得最开始insert的数据
     *
     * @return
     */
    public static void get() {
        //只有stack2为空的时候才循环pop stack1中数据
        //否则，直接取stack2数据，直到statck2为空再遍历stack1 插入到statck2,
        // 否则如statck2不为空，每次get都循环遍历statck1 pop数据到stack2,stack2 原有数据读取会被滞后
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                //当前面stack2 push过数据的时候，如何将后面stack1新加入的数据放到stack2的栈底
                stack2.push(stack1.pop());
            }
        }

        if (!stack2.isEmpty()) {
            System.out.println(stack2.pop());
        } else {
            System.out.println("queue is empty");
        }
    }

}
