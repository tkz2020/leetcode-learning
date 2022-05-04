package org.example.dynamic.programming;

public class 零钱兑换二 {

    /**
     * 518. 零钱兑换 II
     * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
     * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
     * 假设每一种面额的硬币有无限个。
     * 题目数据保证结果符合 32 位带符号整数。
     *
     * 示例 1：
     * 输入：amount = 5, coins = [1, 2, 5]
     * 输出：4
     * 解释：有四种方式可以凑成总金额：
     * 5=5
     * 5=2+2+1
     * 5=2+1+1+1
     * 5=1+1+1+1+1
     *
     * 示例 2：
     * 输入：amount = 3, coins = [2]
     * 输出：0
     * 解释：只用面额 2 的硬币不能凑成总金额 3 。
     *
     * 示例 3：
     * 输入：amount = 10, coins = [10]
     * 输出：1
     *
     * **********完全背包**********
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int len = coins.length;
        //dp[i][j]的定义：若只使用前i个物品，当背包的容量为j时，有dp[i][j]中方法可以装满背包。
        //若只使用coins中的前i个银币的面值，想凑出金额j，有dp[i][j]种凑法。
        int[][] dp = new int[len + 1][amount + 1];

        for (int i = 0; i <= len; i++){
            dp[i][0] = 1;
        }

        for (int i = 0; i <= len; i++){
            for (int j = 0; j <= amount; j++){
                if (j - coins[i-1] >= 0){
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[len][amount];
    }


    public static void main(String[] args) {

    }
}
