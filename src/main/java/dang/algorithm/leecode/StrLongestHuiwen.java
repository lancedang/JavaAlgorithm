package dang.algorithm.leecode;

public class StrLongestHuiwen {

    public static void main(String[] args) {
        String s = "cbbd";
        String s1 = longestPalindrome(s);
        System.out.println(s1); //bb

        s = "babad";
        s1 = longestPalindrome(s);
        System.out.println(s1); //bab

        s = "a";
        s1 = longestPalindrome(s);
        System.out.println(s1); //a
    }

    public static String longestPalindrome(String s) {
        int length = s.length();

        //暂存字符串的所有char为中心的回文中最长的那个
        // 因为要遍历字符串的每个char,每个char为中心的有一个最长的回文
        int realMax = 1;

        //这个也同理记录最开始的那个
        int realStart = 0;

        //思路：从前往后遍历整个字符串，以当前每个字符比如currentIndex:current为核心向两边辐射
        //辐射步骤
        //1.先根据currentIndex分别向左右移动，目的找到和current元素相同所有不间隔紧挨着的相邻元素，直到左右碰到不一致的停止
            //abcccbee,currentIndex=2,current=c,这一步找到ccc 3个相同的串，以ccc整体为单位进行下一步
        //2.再1基础上，开始左、右同时移动的操作，目的找到左=右但不等于current的元素，ccc左边等不等右边元素
        for (int i = 0; i < length; i++) {

            char curr = s.charAt(i);

            //start用于记录，从current进行中心辐射的时候，最长回文的左侧起点
            //因为题目要返回的是回文字符串，substring(start, end)
            //注意这里我们默认设置了start为当前i,而非0这些，举个极端，完全不相同的字符串元素，start也就是当前位置
            int start = i;

            //从当前元素辐射的这个回文的长度
            //最小为1，因为最短也就是这一个char
            //注意这个是以当前字符为中心的最大max
            int max = 1;

            //current左边游标
            int j = i - 1;

            //current右边游标
            int k = i + 1;

            //1.先把左右紧挨着和curr相同的元素统一起来
            while (j >= 0) {
                if (s.charAt(j) == curr) {
                    //左边有相同，好max+1
                    max++;
                    //start记录下左边界
                    start = j;
                    //继续向左右
                    j--;
                } else {
                    //跳出来
                    break;
                }
            }

            //向右找相同元素
            while (k < length) {
                if (s.charAt(k) == curr) {
                    //max再+1
                    max++;
                    k++;
                } else {
                    break;
                }
            }


            //2.在1基础上，j,k分别同步向左右移动
            while (j >= 0 && k < length) {
                //找到a,b,c,b,a： c左边b = c右侧b
                if (s.charAt(j) == s.charAt(k)) {

                    //max得+2了
                    max = max + 2;
                    //start重新赋值
                    start = j;

                    j--;
                    k++;
                } else {
                    break;
                }
            }

            //如果这次遍历max大于之前的最大回文就更新
            if (max > realMax) {
                realMax = max;
                //同时得记录这次的start
                realStart = start;
            }
        }

        //并且要知道：通过substring()来获取结果
        return s.substring(realStart, realStart + realMax);
    }
}
