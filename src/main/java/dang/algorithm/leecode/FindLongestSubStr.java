package dang.algorithm.leecode;

import java.util.HashSet;
import java.util.Set;

public class FindLongestSubStr {
    public static void main(String[] args) {
       int x = lengthOfLongestSubstring("abcabcbb");
        System.out.println(x);
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        Set<Character> set = new HashSet();

        int start = 0;
        int end = 0;
        int max = 0;

        int size = s.length();

        while(end<size) {
            char curr = s.charAt(end);
            if(set.contains(curr)) {
                //去除set中和currt相同及其左侧位置的所有元素
                //这个地方按理说是个遍历（也得是个循环）
                //下面这行代码是关键,从前往后删除直到curr这个元素
                char front = s.charAt(start);
                set.remove(front);
                start++;
                //end不后移
            }else{
                set.add(curr);
                //end后移
                end++;
            }

            max = Math.max(max, set.size());

        }

        System.out.println(start);
        System.out.println(end);
        return max;
    }
}
