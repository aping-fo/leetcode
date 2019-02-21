package com.ap;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        /**
         * [1,1,-1,-1,3]
         3
         */
        int[] nums = {1, 1, -1, -1, 3};
        System.out.println(threeSumClosest(nums, 3));
    }


    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;
        int minSum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int s = i + 1, l = nums.length - 1;
            while (s < l) {
                int threeSum = nums[l] + nums[s] + nums[i];
                if (Math.abs(threeSum - target) < min) {
                    min = Math.abs(threeSum - target);
                    minSum = threeSum;
                }
                if (threeSum > target) {
                    l--;
                } else if (threeSum < target) {
                    s++;
                } else {
                    return target;
                }
            }
        }
        return minSum;
    }
}
