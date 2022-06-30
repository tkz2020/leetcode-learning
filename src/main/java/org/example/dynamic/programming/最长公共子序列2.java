package org.example.dynamic.programming;

public class 最长公共子序列2 {

    /**
     * NC92 最长公共子序列(二)
     * @param s1
     * @param s2
     * @return
     */
    public String LCS (String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0){
            return "";
        }

        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = dp(s1, s2);
        //最长公共子序列字符的长度
        char[] result = new char[dp[len1][len2]];
        int index = result.length - 1;
        while (index >= 0){
            if (len1 > 0 && dp[len1][len2] == dp[len1-1][len2]){
                len1--;
            } else if (len2 > 0 && dp[len1][len2] == dp[len1][len2-1]){
                len2--;
            } else {
                result[index--] = s1.charAt(len1-1);
                len1--;
                len2--;
            }
        }

        if (result == null || result.length == 0){
            return "-1";
        }
        return new String(result);
    }

    /**
     * 求最长公共子序列的长度
     * @param s1
     * @param s2
     * @return
     */
    public int[][] dp(String s1, String s2){

        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1+1][len2+1];

        for (int i = 0; i <= len1; i++){
            for (int j = 0; j <= len2; j++){
                if (i == 0 || j == 0){
                    dp[i][j] = 0;
                } else if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp;
    }


    public static void main(String[] args) {
        String m = "111";
        String n = "222";
        最长公共子序列2 ss = new 最长公共子序列2();
        ss.LCS(m, n);
    }
}
