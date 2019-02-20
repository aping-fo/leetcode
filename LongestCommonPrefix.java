package com.ap;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonPrefix {


    public static void main(String[] args) {
        //System.out.println(findLongest1("abab", "babab"));
        String[] arr = {"dog", "racecar", "car"};
        System.out.println(longestCommon(arr));
    }


    /**
     * 最长前缀，即从第一个开始算
     * @param strs
     * @return
     */
    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length == 1){
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        if (strs.length>1) {
            int len = strs[0].length();
            for (int i = 0; i < len; i++) {
                char curr = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (strs[j].length()<=i ||strs[j].charAt(i) != curr) {
                        return sb.toString();
                    }
                    if (strs[j].charAt(i) == curr && j == strs.length - 1) {
                        sb.append(curr);
                    }
                }
            }
        }
        return sb.toString();
    }


    /**
     * 最长子串
     * @param strs
     * @return
     */
    public static String longestCommon(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < strs.length - 1; i++) {
            String s = findLongest1(strs[i], strs[i + 1]);
            list.add(s);
        }

        String[] s = new String[list.size()];
        list.toArray(s);
        return longestCommon(list.toArray(s));
    }

    static String findLongest1(String A, String B) {
        int n = A.length();
        int m = B.length();
        if (n == 0 || m == 0)
            return "";

        if (A.length() == 1) {
            if (B.contains(A)) {
                return A;
            }
            return "";
        } else if (B.length() == 1) {
            if (A.contains(B)) {
                return B;
            }
            return "";
        }

        String rs = "";

        String dp[][] = new String[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = "";
            }
        }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = String.valueOf(A.charAt(i));
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + String.valueOf(A.charAt(i));
                    }
                    rs = rs.length() > dp[i][j].length() ? rs : dp[i][j];

                    //rs = Math.max(rs, dp[i][j]);//每次更新记录最大值
                } else//不相等的情况
                    dp[i][j] = "";
            }
        return rs;//返回的结果为rs
    }

    static int findLongest(String A, String B) {
        int n = A.length();
        int m = B.length();
        if (n == 0 || m == 0)
            return 0;
        int rs = 0;

        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = 0;
            }
        }

        for (int i = 1; i < n; i++)
            for (int j = 1; j < m; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    rs = Math.max(rs, dp[i][j]);//每次更新记录最大值
                } else//不相等的情况
                    dp[i][j] = 0;
            }
        return rs;//返回的结果为rs
    }
}
