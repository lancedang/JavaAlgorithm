package dang.algorithm.leecode;

public class FindStrInStr {
    public static void main(String[] args) {
        System.out.println(strStr("aaba", "ab"));
    }

    public static int strStr(String source, String dest) {

        if (dest == null || "".equals(dest)) {
            return 0;
        }

        //先取dest 首字符作为判断开始
        char c = dest.charAt(0);
        int j = 0;

        //用于记录首个匹配位置
        int first = 0;

        //用于在source中找到dest首字符后的 便利dest
        int m = 0;

        int i = 0;

        while (i < source.length()) {
            //每次从source找到dest开头的char
            if (source.charAt(i) != c) {
                i++;
                continue;
            } else {
                //找到后，从i开始判断
                first = i;

                m = i;

                //从source中依次遍历dest所有字符
                while (j < dest.length() && m < source.length()) {
                    //如果相同，则继续依次向下比较
                    if (source.charAt(m) == dest.charAt(j)) {
                        m++;
                        j++;
                    } else { //否则，则复位dest并跳过循环
                        j = 0;
                        break;
                    }
                }

            }

            //如何判断已经找到dest了呢：j已经走到最后了
            if (j == dest.length()) {
                return first;
            }
            i++;
        }

        return -1;

    }
}
