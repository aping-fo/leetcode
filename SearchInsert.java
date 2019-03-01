package com.ap;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

 你可以假设数组中无重复元素。

 示例 1:

 输入: [1,3,5,6], 5
 输出: 2
 示例 2:

 输入: [1,3,5,6], 2
 输出: 1
 示例 3:

 输入: [1,3,5,6], 7
 输出: 4
 示例 4:

 输入: [1,3,5,6], 0
 输出: 0
 */
public class SearchInsert {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 7));
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums.length < 1) {
            return 0;
        }
        return searchInsert(nums, 0, nums.length, target);
    }

    public static int searchInsert(int[] nums, int low, int high, int target) {
        int mid = (low + high) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        if (mid == 0 && target < nums[mid]) {
            return 0;
        }
        if (mid == nums.length - 1 && target > nums[mid]) {
            return nums.length;
        }
        if (mid != 0 && target > nums[mid - 1] && target < nums[mid]) {
            return mid;
        }
        if (target > nums[mid]) {
            return searchInsert(nums, mid + 1, high, target);
        } else {
            return searchInsert(nums, low, mid - 1, target);
        }
    }
}
