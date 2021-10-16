package dang.algorithm.leecode;

public class InverseNumber {
    public static void main(String[] args) {

        System.out.println(reverse(-2147483648));
    }

    public static int reverse(int x) {
        int highLeft = x;
        int result = 0;
        if (highLeft == 0) {
            return 0;
        }
        while (highLeft != 0) {
            //1)获取余数，-123 % 10 = -3，目的：获取最后一位数不断*10
            int lastNumber = highLeft % 10;

            //2)max与min分别为 [−2^31, 2^31 − 1]， 即：[-2147483648, 2147483647]
            //>7表示超过max, <-8超过min最小负数
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && lastNumber > 7)) {
                return 0;
            }

            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && lastNumber < -8)) {
                return 0;
            }

            //3)inverse值等于原来最后位*10+余数
            result = result * 10 + lastNumber;
            //4)一次余数取得后，向前递推
            highLeft = highLeft / 10;
        }
        return result;
    }
}
