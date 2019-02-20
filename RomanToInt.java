/**
罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。

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
给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。

示例 1:

输入: "III"
输出: 3
示例 2:

输入: "IV"
输出: 4
示例 3:

输入: "IX"
输出: 9
示例 4:

输入: "LVIII"
输出: 58
解释: L = 50, V= 5, III = 3.
示例 5:

输入: "MCMXCIV"
输出: 1994
解释: M = 1000, CM = 900, XC = 90, IV = 4.
*/

class RomanToInt {
   private static final Map<String, Integer> map1 = new HashMap<>();

    static {
        map1.put("I", 1);
        map1.put("II", 2);
        map1.put("III", 3);
        map1.put("IV", 4);
        map1.put("V", 5);
        map1.put("VI", 6);
        map1.put("VII", 7);
        map1.put("VIII", 8);
        map1.put("IX", 9);
        map1.put("X", 10);
        map1.put("XX", 20);
        map1.put("XXX", 30);
        map1.put("XL", 40);
        map1.put("L", 50);
        map1.put("LX", 60);
        map1.put("LXX", 70);
        map1.put("LXXX", 80);
        map1.put("XC", 90);
        map1.put("C", 100);
        map1.put("CC", 200);
        map1.put("CCC", 300);
        map1.put("CD", 400);
        map1.put("D", 500);
        map1.put("DC", 600);
        map1.put("DCC", 700);
        map1.put("DCCC", 800);
        map1.put("CM", 900);
        map1.put("M", 1000);
        map1.put("MM", 2000);
        map1.put("MMM", 3000);
    }


    public static int romanToInt(String s) {
        Integer m = map1.get(s);
        if (m != null) {
            return m;
        }
        
        int sum = 0;
        char[] c = new char[2];
        int l = s.length();
        for (int i = 0; i < l; i++) {
            c[0]=' ';
            c[1]=' ';
            
            c[0] = s.charAt(i);
            if (i + 1 < l) {
                c[1] = s.charAt(i + 1);
            }
            Integer n = map1.get(String.valueOf(c));
            if(n != null) {
                i ++;
            }else {
                n = map1.get(String.valueOf(s.charAt(i)));
            }
            sum += n;
        }

        return sum;
    }
}
