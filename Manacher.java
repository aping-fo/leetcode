package com.ap;

/**
最大回文串
Manacher 算法

当然，还有大家都能想到的 遍历法，其思想是遍历每一个元素，然后再检查其左右对称位置是否相等
注意奇偶，当然也可以init 插入一个符号，来统一处理，那么长度就是 max/2
*/
public class Manacher {

    static int[] p;
    static char[] str;

    public static void main(String[] args) {
        String s = "a";
        manacher(s.toCharArray());
    }

    /**
     * 重新构造一个串，每个字符插入一个#，收尾再加入一个不相同的字符，防止越界
     *
     * @param s
     * @return
     */
    public static int init(char[] s) {
        int sLen = s.length;
        p = new int[2 * sLen + 2];
        str = new char[2 * sLen + 3];

        str[0] = '$';
        str[1] = '#';

        int j = 2;
        for (int i = 0; i < sLen; i++) {
            str[j++] = s[i];
            str[j++] = '#';
        }

        str[j] = '!';

        return j;
    }

    public static void manacher(char[] s) {
        int len = init(s);
        int maxLen = -1;
        int id = 1;
        int mx = 0; //当前最大回文最右界下标
        int start;
        int end;

        for (int i = 1; i < len; i++) {
            if (i < mx) {
                p[i] = Math.min(p[2 * id - i], mx - i);
                System.out.println((p[2 * id - i]) + "-" + (mx - i));
            } else {
                p[i] = 1;
            }

            while (str[i - p[i]] == str[i + p[i]])
                p[i]++;

            if (mx < i + p[i]) {
                id = i;
                mx = i + p[i];
            }

            maxLen = Math.max(maxLen, p[i] - 1);

        }

        int m = 0;
        int idx = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] > m) {
                m = p[i];
                idx = i;
            }
        }

        start = idx - m + 1;
        end = idx + m;

        char[] target = new char[end - start];
        System.arraycopy(str, start, target, 0, end - start);
        String strTarget = new String(target).replaceAll("#", "");
        System.out.println(strTarget);
    }
}
