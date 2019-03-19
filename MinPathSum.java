package com.ap;
/*
给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class MinPathSum {
    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        System.out.println(minPathSum(nums));
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (n == 0) {
            return 0;
        }

        int[][] newGrid = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                newGrid[i][j] = grid[i - 1][j - 1];
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int min;
                if (i - 1 == 0 || j - 1 == 0) {
                    min = Math.max(newGrid[i - 1][j], newGrid[i][j - 1]);
                } else {
                    min = Math.min(newGrid[i - 1][j], newGrid[i][j - 1]);
                }
                newGrid[i][j] += min;
            }
        }
        return newGrid[m][n];
    }
}
