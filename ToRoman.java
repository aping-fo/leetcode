package com.ap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。

 字符          数值
 I             1
 V             5
 X             10
 L             50
 C             100
 D             500
 M             1000
 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

 I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。

 示例 1:

 输入: 3
 输出: "III"
 示例 2:

 输入: 4
 输出: "IV"
 示例 3:

 输入: 9
 输出: "IX"
 示例 4:

 输入: 58
 输出: "LVIII"
 解释: L = 50, V = 5, III = 3.
 示例 5:

 输入: 1994
 输出: "MCMXCIV"
 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class ToRoman {
    private static final Map<Integer, String> map = new HashMap<>();

    static {
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(2345));
        System.out.println(intToRoman1(2345));
    }


    /**
     * 方法一
     * @param num
     * @return
     */
    public static String intToRoman1(int num) {
        int values[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String reps[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 13; i++) {
            while (num >= values[i]) {
                num -= values[i];
                res.append(reps[i]);
            }
        }
        return res.toString();
    }

    public static String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        List<Integer> list = new ArrayList<>(4);
        while (num != 0) {
            int mod = num % 10;
            list.add(mod);
            num /= 10;
        }

        List<String> strings = new ArrayList<>();
        int o = 1;
        int f = 5;
        int b = 1;
        for (int i = 0; i < list.size(); i++) {
            String s = "";
            int m = list.get(i);
            int t = m * b;
            if (map.containsKey(t)) {
                s = s + map.get(t);
            } else {
                if (t >= o && t <= f) {
                    for (int k = 1; k <= m; k++) {
                        s += map.get(o);
                    }
                } else if (t >= f) {
                    s += map.get(f);
                    m = m % 5;
                    for (int k = 1; k <= m; k++) {
                        s += map.get(o);
                    }
                }
            }
            b *= 10;
            f *= 10;
            o *= 10;
            strings.add(0, s);
        }

        for (String s : strings) {
            sb.append(s);
        }
        return sb.toString();
    }
}
