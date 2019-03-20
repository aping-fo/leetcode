package com.ap;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

 你可以假设除了整数 0 之外，这个整数不会以零开头。

 示例 1:

 输入: [1,2,3]
 输出: [1,2,4]
 解释: 输入数组表示数字 123。
 示例 2:

 输入: [4,3,2,1]
 输出: [4,3,2,2]
 解释: 输入数组表示数字 4321。
 */
public class PlusOne {


    public int[] plusOne1(int[] digits) {
        int delt = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int num = digits[i] + delt;
            delt = num / 10;
            digits[i] = num % 10;
            if (delt == 0) {
                break;
            }
        }
        if (delt != 0) {
            int[] target = new int[digits.length + 1];
            System.arraycopy(digits, 0, target, 1, digits.length);
            target[0] = delt;
            return target;
        } else {
            return digits;
        }
    }

    public int[] plusOne(int[] digits) {
        List<Integer> arr = new ArrayList<>();
        int delt = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int num = digits[i] + delt;
            delt = num / 10;
            arr.add(0, num % 10);
        }
        if (delt != 0) {
            arr.add(0, delt);
        }
        int[] a = new int[arr.size()];
        int k = 0;
        for (int i : arr) {
            a[k++] = i;
        }
        return a;
    }
}
