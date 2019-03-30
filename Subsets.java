package com.ap;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Subsets {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(subsets(nums));
    }

    //方案一
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rsp = new ArrayList<>();
        if (nums == null) {
            return rsp;
        }
        rsp.add(new ArrayList<>());
        for(int i: nums){
            int len=rsp.size();
            for(int j=0;j<len;j++){
                List<Integer> temp= new ArrayList<>(rsp.get(j));
                temp.add(i);
                rsp.add(temp);
            }
        }
        return rsp;
    }

    //方案2
    public static List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if (nums.length == 0) {
            return result;
        }
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= nums.length; i++) {
            dfs(result, list, nums, 0, nums.length-1, i);
        }
        return result;
    }

    public static void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int x, int n, int k) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int j = x; j <= n; j++) {
            list.add(nums[j]);

            dfs(result, list, nums, j + 1, n, k);
            list.remove(list.size() - 1);
        }
    }
}
