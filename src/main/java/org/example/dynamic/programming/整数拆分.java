package org.example.dynamic.programming;

public class 整数拆分 {

    /**
     * https://leetcode.cn/problems/integer-break/
     * @param n
     * @return
     */
    public int integerBreak(int n) {

        int[] dp = new int[n+1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++){
            int curMax = 0;
            for (int j = 1; j < i; j++){
                curMax = Math.max(curMax, Math.max(j*(i-j), j*dp[i-j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }


    public static void main(String[] args) {
        int n = 10;
        整数拆分 ss = new 整数拆分();
        System.out.println(ss.integerBreak(n));

    }
}
