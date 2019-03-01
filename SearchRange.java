package com.ap;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

 你的算法时间复杂度必须是 O(log n) 级别。

 如果数组中不存在目标值，返回 [-1, -1]。

 示例 1:

 输入: nums = [5,7,7,8,8,10], target = 8
 输出: [3,4]
 示例 2:

 输入: nums = [5,7,7,8,8,10], target = 6
 输出: [-1,-1]
 */
public class SearchRange {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.out.println(searchRange(nums, 6));
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length < 2) {
            return new int[]{-1, -1};
        }
        return searchTargetRange(nums, 0, nums.length, target);
    }

    //二分查找，然后2边搜索
    public static int[] searchTargetRange(int[] nums, int low, int high, int target) {
        if (low > high) {
            return new int[]{-1, -1};
        }
        int mid = (low + high) / 2;
        if (nums[mid] == target) {
            int[] ret = new int[2];
            for (int i = mid; i >= 0; i--) {
                if (nums[i] != target) {
                    break;
                }
                ret[0] = i;
            }

            for (int i = mid; i < nums.length; i++) {
                if (nums[i] != target) {
                   break;
                }
                ret[1] = i;
            }

            return ret;
        }

        if (target > nums[mid]) {
            return searchTargetRange(nums, mid + 1, high, target);
        } else {
            return searchTargetRange(nums, low, mid - 1, target);
        }
    }
}
