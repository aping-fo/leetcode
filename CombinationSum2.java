package com.ap;

import java.util.*;

/**
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]
 */
public class CombinationSum2 {

    public static void main(String[] args) {
        // int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5}; //8
        int[] candidates = new int[]{2, 5, 2, 1, 2}; //5
        //int[] candidates = new int[]{3, 1, 3, 5, 1, 1};//8
        System.out.println(combinationSum(candidates, 5));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> listAll = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        //排序
        Arrays.sort(candidates);

        dfs(candidates, listAll, list, target, 0);
        //find(listAll,list,candidates,target,0);
        return listAll;
    }

    public static void find(List<List<Integer>> listAll,List<Integer> tmp,int[] candidates, int target,int num){
        //递归的终点
        if(target==0){
            listAll.add(tmp);
            return;
        }
        if(target<candidates[0]) return;
        while(num<candidates.length&&candidates[num]<=target){
            //深拷贝
            List<Integer> list=new ArrayList<>(tmp);
            list.add(candidates[num]);
            //将num+1传递，避免使用重复数字
            find(listAll,list,candidates,target-candidates[num],num+1);
            int q=num;
            while(q+1<candidates.length&&candidates[num]==candidates[q+1]){
                q++;
            }
            //若是有重复的数字出现，为了避免结果重复，只需要对第一个数字进行find即可，因为第一个的find的结果，会把之后的结果全部覆盖
            if(q>num){
                num=q+1;
                if(q==candidates.length-1){
                    break;
                }
            }else{
                num++;
            }
        }
    }


    public static void dfs(int[] candidates, List<List<Integer>> listAll, List<Integer> tmp, int target, int idx) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            listAll.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                tmp.add(candidates[i]);
                dfs(candidates, listAll, tmp, target - candidates[i], i + 1);
                tmp.remove(tmp.size() - 1);
                while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
                    i++;
                }
            }
        }
    }
}
