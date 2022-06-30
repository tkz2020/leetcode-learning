package org.example.practise;

import java.util.Arrays;

public class 最少的硬币数目 {

    /**
     * 剑指 Offer II 103. 最少的硬币数目
     * 完全背包问题
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++){
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
