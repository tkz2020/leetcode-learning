package org.example.dynamic.programming;

public class 三步问题 {

    public int waysToStep(int n) {
        if (n <= 1){
            return 1;
        }

        if (n == 2){
            return n;
        }

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++){
            dp[i] = (dp[i-1] + (dp[i-2] + dp[i-3]) % 1000000007) % 1000000007;
        }
        return dp[n];
    }


}
