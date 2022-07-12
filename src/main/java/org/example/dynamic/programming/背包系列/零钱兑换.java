package org.example.dynamic.programming.背包系列;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 零钱兑换 {

    /**
     * 完全背包问题
     * https://leetcode.cn/problems/coin-change/
     * 1、纸币的面额可以看成是不同的物品
     * 2、amount可以看成是背包的重量
     * 3、每个物品的使用次数不限制
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        for (int i = 0; i < coins.length; i++){
            //完全背包问题，正序遍历背包的容量
            for (int j = coins[i]; j <= amount; j++){
                if (dp[j - coins[i]] != Integer.MIN_VALUE){
                    dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
                }
            }
        }

        if (dp[amount] == Integer.MIN_VALUE){
            return -1;
        }
        return dp[amount];
    }

    public static void main(String[] args) {

    }
}
