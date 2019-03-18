package com.ap;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
    }
     //动态规划思想第 ij格的走法等于 i-1j的走法 + ij-1走法。反过来搜索
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];//m+1,n+1  不用考虑数组越界  dp[i][j]为从[1,1]到[i,j]有多少种路径
        dp[1][1] = 1;
        for(int i = 1;i < m + 1;i++){
            for(int j = 1;j < n + 1;j++){
                dp[i][j] += dp[i - 1][j] + dp[i][j - 1]; //这里多了一个“+”是因为dp[i][j]初始为0，且为了解决dp[1][1] = 1的初始问题
            }
        }
        return dp[m][n];
    }

    public static int uniquePaths1(int m, int n) {
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = 0;
            }
        }

        dfs(nums, n, m, 0, 0);
        return count;
    }

    static int count = 0;

//深搜
    public static void dfs(int[][] nums, int n, int m, int k, int l) {
        if (nums[k][l] == 0) {
            nums[k][l] = 1;
            if (k == n - 1 && l == m - 1) {
                count++;
            }

            if (l < m - 1) { //往右搜
                dfs(nums, n, m, k, l + 1);
            }

            if (k < n - 1) { //向下搜
                dfs(nums, n, m, k + 1, l);
            }

            nums[k][l] = 0;
        }
    }
}
