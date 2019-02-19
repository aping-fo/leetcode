package com.ap;

/**
 * 动态规划
 * <p>
 * <p>
 * <p>
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] arr = {1, 58, 58, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(arr));
    }

    public static int maxArea(int[] height) {
        int l = 0;
        int h = height.length - 1;

        int max = 0;

        while (l < h) {
            max = Math.max(max, Math.min(height[l], height[h]) * (h - l));
            if (height[l] < height[h])
                l++;
            else
                h--;
        }
        return max;
    }
}
