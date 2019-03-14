package com.ap;

/**
 *
 给定一个非负整数数组，你最初位于数组的第一个位置。

 数组中的每个元素代表你在该位置可以跳跃的最大长度。

 判断你是否能够到达最后一个位置。

 示例 1:

 输入: [2,3,1,1,4]
 输出: true
 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 示例 2:

 输入: [3,2,1,0,4]
 输出: false
 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 *
 */
public class CanJump {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        int maxIdx = nums[0];

        for (int i = 0; i < nums.length; i++) {
            //寻找能够跳到最大索引位置
            maxIdx = Math.max(maxIdx, nums[i] + i);
            if (maxIdx >= nums.length - 1) {
                return true;
            }

            //如果最大和当前相等，并且==0，则永远过不了
            if (maxIdx == i && nums[i] == 0) {
                return false;
            }
        }
        return false;
    }
}
