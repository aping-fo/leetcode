package com.ap;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class SearchTarget {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums, 0));
    }

    public static int search(int[] nums, int target) {
        return searchTarget(nums, 0, nums.length - 1, target);
    }

    /**
     * 将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。此时有序部分用二分法查找。
     * 无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
     *
     * @param nums
     * @param low
     * @param height
     * @param target
     * @return
     */
    public static int searchTarget(int[] nums, int low, int height, int target) {
        if (low > height) {
            return -1;
        }

        int mid = (low + height) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        //二分查找，只是判断条件做修改
        if (nums[mid] < nums[height]) { //因为是升序数组旋转，所以从mid -- height 一定是有序
            if (nums[mid] < target && target < nums[height]) { //判断target是否在有序数组里
                return searchTarget(nums, mid + 1, height, target);
            } else {
                return searchTarget(nums, low, mid - 1, target);
            }
        } else {//因为是升序数组旋转，所以从low -- mid 一定是有序
            if (nums[low] < target && target < nums[mid]) {
                return searchTarget(nums, low, mid - 1, target);
            } else {
                return searchTarget(nums, mid + 1, height, target);
            }
        }
    }
}
