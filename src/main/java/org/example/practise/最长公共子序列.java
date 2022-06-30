package org.example.practise;

public class 最长公共子序列 {

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null){
            return 0;
        }

        int length1 = text1.length();
        int length2 = text2.length();
        int[][] dp = new int[length2 + 1][length1 + 1];

        for (int j = 0; j < length1; j++){
            dp[0][j] = 0;
        }

        for (int i = 0; i < length2; i++){
            dp[i][0] = 0;
        }

        for (int i = 1; i <= length2; i++){
            for (int j = 1; j <= length1; j++){
                if (text2.charAt(i-1) == text1.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[length2][length1];
    }


    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        最长公共子序列 s = new 最长公共子序列();
        s.longestCommonSubsequence(text1, text2);
    }
}
