package dang.algorithm.advanceSort;

import java.util.LinkedList;

public class Demo {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(list);

        int begin = 0;
        int end = list.size()-1;

        int first = list.get(begin);
        int last = list.get(end);


        while(begin <= end) {
            first = list.get(begin);
            last = list.get(end);

            list.remove(begin);
            list.add(begin, last);

            list.remove(end);
            list.add(end,first);

            begin++;
            end--;

        }

        System.out.println(list);
    }
}
