package org.example.dynamic.programming;

public class 最长公共子数组 {

    /**
     * NC183 最长公共子数组
     * @param A
     * @param B
     * @return
     */
    public int longestCommonSubarry (int[] A, int[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0){
            return 0;
        }

        int len1 = A.length;
        int len2 = B.length;
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 0; i < len1; i++){
            dp[i][0] = 0;
        }

        for (int j = 0; j < len2; j++){
            dp[0][j] = 0;
        }

        int max = 0;
        for (int i = 1; i <= len1; i++){
            for (int j = 1; j <= len2; j++){
                if (A[i-1] == B[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {

    }
}
