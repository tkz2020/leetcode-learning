package org.example.dynamic.programming;

public class 最长回文子序列 {

    /**
     * 516. 最长回文子序列
     * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
     * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
     *
     * 示例 1：
     * 输入：s = "bbbab"
     * 输出：4
     * 解释：一个可能的最长回文子序列为 "bbbb" 。
     *
     * 示例 2：
     * 输入：s = "cbbd"
     * 输出：2
     * 解释：一个可能的最长回文子序列为 "bb" 。
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        if (s.length() == 0){
            return 0;
        }

        if (s.length() == 1){
            return 1;
        }

        int len = s.length();
        //初始化
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++){
            dp[i][i] = 1;
        }

        for (int i = len - 2; i >= 0; i--){
            for (int j = i + 1; j < len; j++){
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        return dp[0][len-1];
    }


    public static void main(String[] args) {
        String s = "aaa";
        最长回文子序列 ss = new 最长回文子序列();
        System.out.println(ss.longestPalindromeSubseq(s));
    }
}
