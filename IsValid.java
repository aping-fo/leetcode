package com.ap;

import java.util.HashMap;
import java.util.Map;

/**
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true

*/
public class IsValid {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    static Map<Character, Character> map1 = new HashMap<>();
    static Map<Character, Character> map2 = new HashMap<>();

    static {
        map1.put('(', ')');
        map1.put('[', ']');
        map1.put('{', '}');

        map2.put(')', '(');
        map2.put(']', '[');
        map2.put('}', '{');
    }

    public static boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        if (s.trim().equals("")) {
            return true;
        }

        char firstChar = '-';
        Map<Character, Integer> map3 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('-' == firstChar) {
                firstChar = s.charAt(i);
                if (!map1.containsKey(firstChar)) {
                    return false;
                }
            }

            if (map1.containsKey(c)) {
                int count = map3.getOrDefault(c, 0);
                map3.put(c, count + 1);
            } else if (map2.containsKey(c)) {
                char c3 = map2.get(c);
                int count = map3.getOrDefault(c3, 0);
                if (count <= 0) {
                    return false;
                }
                if (count - 1 == 0) {
                    map3.remove(c3);
                } else {
                    map3.put(c3, count - 1);
                }

                if (c3 == firstChar && count - 1 == 0 && map3.size() != 0) {
                    return false;
                } else if (c3 == firstChar && count - 1 == 0 && map3.size() == 0) {
                    firstChar = '-';
                }
            }
        }

        return map3.size() == 0;
    }
}
