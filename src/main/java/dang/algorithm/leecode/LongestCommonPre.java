package dang.algorithm.leecode;

public class LongestCommonPre {
    public static void main(String[] args) {
        String[] array = new String[]{"hiyouxxx", "hiyou"};
        System.out.println(longestCommonPrefix(array));
        System.out.println("hi".substring(0, 0));
    }

    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        //1)拿首个字符串作为参照，从上到下纵向与其他剩余字符串做比较，从前向后依次判断所有字符串0位，1位。。字符是否相同
        String str1 = strs[0];
        int j = 0;
        for (j = 0; j < str1.length(); j++) {
            //ok首个判断标记，内部循环break时会将其置位
            boolean ok = true;
            //1）从前往后依次获取第一个字符串的每位字符
            char curr = str1.charAt(j);
            //遍历数组中其他剩余的字符串,性能M*N,M为字符串平均长度，N为数组长度
            for (int i = 1; i < strs.length; i++) {

                //2)长度判断，首个字符串长度5，第二个字符串长度2这种情况
                //最长公共子串长度<=数组中最短的字符串，如果相等退出即可
                if (j == strs[i].length()) {
                    //标记跳出双层for循环
                    ok = false;
                    break;
                }
                //获取i字符串j位上的字符做比较
                char other = strs[i].charAt(j);
                if (curr != other) {
                    //标记跳出双层for循环
                    ok = false;
                    break;
                }
            }

            if (!ok) {
                break;
            }
        }
        //j记录了最大匹配的前缀
        return str1.substring(0, j);

    }
}
