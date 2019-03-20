package com.ap;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int la = a.length() -1;
        int lb = b.length() -1;

        int d = 0;
        while (la >= 0 || lb >= 0){
            int ca = 0;
            int cb = 0;

            if (la >= 0) {
                ca = a.charAt(la) - '0';
            }
            if (lb >= 0) {
                cb = b.charAt(lb) - '0';
            }

            int s = d + ca + cb;
            d = s / 2;
            sb.append(s % 2);

            la --;
            lb --;
        }
        if (d > 0) {
            sb.append(d);
        }

        return sb.reverse().toString();
    }
}
