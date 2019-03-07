package com.ap;

import java.util.ArrayList;
import java.util.List;

/**
给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/
public class Permute {
    public static void main(String args[]) throws Exception {
        int[] str = {1,2};
        System.out.println(permutation(str));
    }

    public static List<List<Integer>> permutation(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permutation(result, nums, 0, nums.length - 1);//输出str[0..2]的所有排列方式
        return result;
    }

    public static void permutation(List<List<Integer>> result, int[] nums, int first, int end) {
        //输出str[first..end]的所有排列方式
        if (first == end) {    //输出一个排列方式
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= end; j++) {
                list.add(nums[j]);
            }

            result.add(list);
        }

        for (int i = first; i <= end; i++) {
            swap(nums, i, first);
            permutation(result, nums, first + 1, end);  //固定好当前一位，继续排列后面的
            swap(nums, i, first); //回溯的概念
        }
    }

    private static void swap(int[] str, int i, int first) {
        int tmp;
        tmp = str[first];
        str[first] = str[i];
        str[i] = tmp;
    }
}
