package dang.algorithm.tencent;

public class CalSum2String {
    public static void main(String[] args) {
        cal2NumberStringValue("", "579");
    }

    /**
     * 计算2个数字字符串之和，每个字符串长度可能超过10000
     * 1.数字char字符和int 数值相互转化
     * 2.进位保留
     * 3.进位取除法，余数留给当前数组设置
     * 4.最后考虑所得结果可能大于max(array1,length, array2.length), 原基础+1
     * 5.用array[max]存放最终结果，从前往后遍历，写入result[]，最终用add 拼接 result
     * <p>
     * char->int 数值：
     * char x = '5';
     * int xx = Integer.parseInt(String.valueOf(x));
     * <p>
     * 数字->char：
     * int y = 8;
     * int yy = Character.forDigit(y, 10);
     *
     * @param input1
     * @param input2
     */
    public static void cal2NumberStringValue(String input1, String input2) {
        boolean in1 = (input1 == null || "".equals(input1.trim()));
        boolean in2 = (input2 == null || "".equals(input2.trim()));

        if (in1 && in2) {
            System.out.println("two inputs are empty");
            return;
        }

        if (in1 || in2) {
            System.out.println(in1 ? input2 : input1);
            return;
        }

        char[] array1 = input1.toCharArray();
        char[] array2 = input2.toCharArray();

        int length1 = array1.length;
        int length2 = array2.length;

        int arrayIndex1 = length1;
        int arrayIndex2 = length2;

        char[] result = new char[Math.max(length1, length2)];

        boolean longer = (length1 > length2);

        int min = Math.min(length1, length2);
        int currIndex = min;
        int max = Math.max(length1, length2);
        int maxIndex = max;

        int add = 0;

        while (currIndex > 0) {

            int x = array1[arrayIndex1 - 1] - '0';
            int y = array2[arrayIndex2 - 1] - '0';

            int temp = x + y + add;

            if (temp >= 10) {
                add = temp / 10;
                int curTemp = temp % 10;
                result[maxIndex - 1] = Character.forDigit(curTemp, 10);
            } else {
                result[maxIndex - 1] = Character.forDigit(temp, 10);
                //进位清除
                add = 0;
            }

            maxIndex--;
            currIndex--;
            arrayIndex1--;
            arrayIndex2--;
        }

        int distance = max - min;

        while (distance > 0) {
            int temp1 = 0;
            if (longer) {
                temp1 = array1[distance - 1] - '0';
            } else {
                temp1 = array2[distance - 1] - '0';
            }
            int temp2 = temp1 + add;
            if (temp2 >= 10) {
                add = temp2 / 10;
                int curTemp = temp2 % 10;
                result[distance - 1] = Character.forDigit(curTemp, 10);
            } else {
                result[distance - 1] = Character.forDigit(temp2, 10);
                //这个进位要清0，否则遗留上次的进位
                add = 0;
            }
            distance--;
        }

        if (add > 0) {
            System.out.println("" + add + String.valueOf(result));
        } else {
            System.out.println(result);
        }

    }

}
