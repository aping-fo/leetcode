package com.ap;

import java.util.HashMap;
import java.util.Map;

public class ZConvert {
    public static void main(String[] args) {
        String s = "A";
        convert(s, 3);
    }
//LCIRETOESIIGEDHN LDREOEIIECIHNTSG

    public static String convert(String s, int row) {
        if (row == 1 || s.length() == 1) {
            return s;
        }
        //int size = s.length() % 2 == 0 ? s.length() / 2 : s.length() / 2 + 1;
        //char[][] arr = new char[row][size];

        int l = 0;

        int r = 0;
        int c = 0;

        Map<Integer, StringBuilder> map = new HashMap<>();

        row = Math.min(row, s.length());

        while (l < s.length()) {
            if (c % (row - 1) != 0) {
                StringBuilder sb = map.get(r);
                if (sb == null) {
                    sb = new StringBuilder();
                    map.put(r, sb);
                }
                //arr[r][c] = s.charAt(l++);
                sb.append(s.charAt(l++));

            } else {
                for (int i = 0; i < row; i++) {
                    if (l >= s.length()) break;
                    StringBuilder sb = map.get(r);
                    if (sb == null) {
                        sb = new StringBuilder();
                        map.put(r, sb);
                    }
                    //arr[r][c] = s.charAt(l++);
                    sb.append(s.charAt(l++));
                    r++;
                }
                r--;
            }
            r -= 1;
            c += 1;
        }

        StringBuilder sb = new StringBuilder();

        /*for (char[] ch : arr) {
            for (char c1 : ch) {
                if (c1 != '\u0000') {
                    sb.append(c1);
                }
            }
        }

        System.out.println(sb.toString());*/

        for (int i = 0; i < row; i++) {
            StringBuilder sb2 = map.get(i);
            if (sb2 != null) {
                sb.append(sb2);
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
