package com.ap;

import java.util.Arrays;

/**
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

 注意:
 不能使用代码库中的排序函数来解决这道题。

 示例:

 输入: [2,0,2,1,1,0]
 输出: [0,0,1,1,2,2]
 进阶：

 一个直观的解决方案是使用计数排序的两趟扫描算法。
 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class SortColors {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 1,2,0,0,1};
        sortColors(nums);
        Arrays.stream(nums).forEach(System.out::print);
    }

    /**
     * 0，1，2 排序。一次遍历，如果是0，则移动到表头，如果是2，则移动到表尾，不用考虑1。0和2处理完
     * @param nums
     */
    public static void sortColors(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        int l = nums.length;
        int s = 0;
        int e = l - 1;

        for (int i = 0; i < l; i++) {
            if (nums[i] == 0) {
                if (s == i) {
                    s++;
                    continue;
                }
                int k = nums[s];
                nums[s] = nums[i];
                nums[i] = k;
                s += 1;
                i -= 1;
            } else if (nums[i] == 2) {
                int k = nums[e];
                nums[e] = nums[i];
                nums[i] = k;
                e -= 1;
                l -= 1;
                i -= 1;
            }
        }
    }
}
