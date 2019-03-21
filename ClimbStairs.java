package com.ap;

import java.util.stream.Stream;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

 注意：给定 n 是一个正整数。

 示例 1：

 输入： 2
 输出： 2
 解释： 有两种方法可以爬到楼顶。
 1.  1 阶 + 1 阶
 2.  2 阶
 示例 2：

 输入： 3
 输出： 3
 解释： 有三种方法可以爬到楼顶。
 1.  1 阶 + 1 阶 + 1 阶
 2.  1 阶 + 2 阶
 3.  2 阶 + 1 阶
 */
public class ClimbStairs {

    public static void main(String[] args) {
        //System.out.println(climbStairs(50));

        Object object = new Object();
        Stream.iterate(object, item -> item).limit(10);
    }
    //递推
    public int climbStairs(int n) {
        //使用带缓存的递归
        int[] cache = new int[n+1];
        cache[1] = 1;
        cache[2] = 2;

        for(int i=3;i<=n;i++){
            cache[i] = cache[i-1] +cache[i-2];
        }
        return cache[n];
    }

//递归
    public int climbStairs1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
