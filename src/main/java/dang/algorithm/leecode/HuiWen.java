package dang.algorithm.leecode;

public class HuiWen {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1221));
    }

    public static boolean isPalindrome(int x) {
        int result = 0;
        int leftPrefix = x;

        //若x为负，肯定为FALSE
        while (leftPrefix > 0) {
            int remainder = leftPrefix % 10;

            //1）针对1221偶数情况 这种情况，用==判断已经从后向前反转了一半数据
            if (result == leftPrefix) {
                return true;
            }

            //2) 针对121奇数情况，若result > leftPrefix，说明反转超过了一半位数
            //判断条件改为result / 10跟leftPre相等就行
            if (result > leftPrefix && leftPrefix == result / 10) {
                System.out.println("...");
                return true;
            }

            result = result * 10 + remainder;
            leftPrefix = leftPrefix / 10;
        }

        //其余情况返回FALSE，其实也没其余情况
        return false;

    }
}
