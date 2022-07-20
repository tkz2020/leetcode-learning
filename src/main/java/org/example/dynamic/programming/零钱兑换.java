package org.example.dynamic.programming;

import java.util.Arrays;

public class 零钱兑换 {

    /**
     * 完全背包
     * https://leetcode.cn/problems/coin-change/
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        // dp 表示组成金额 i 所需最少硬币的数量
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        //外层循环是背包的容量
        for (int i = 1; i <= amount; i++){
            //里层循环是具体的物品
            for (int j = 0; j < coins.length; j++){
                if (coins[j] <= i){
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {

    }
}
