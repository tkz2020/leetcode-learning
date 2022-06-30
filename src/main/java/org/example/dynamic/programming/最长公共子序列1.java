package org.example.dynamic.programming;

public class 最长公共子序列1 {

    /**
     * 剑指 Offer II 095. 最长公共子序列
     * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
     * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
     * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
     * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
     *
     * 示例 1：
     * 输入：text1 = "abcde", text2 = "ace"
     * 输出：3
     * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
     *
     * 示例 2：
     * 输入：text1 = "abc", text2 = "abc"
     * 输出：3
     * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
     *
     * 示例 3：
     * 输入：text1 = "abc", text2 = "def"
     * 输出：0
     * 解释：两个字符串没有公共子序列，返回 0 。
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0){
            return 0;
        }

        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int len1 = s1.length;
        int len2 = s2.length;
        int[][] dp = new int[len2+1][len1+1];
        for (int i = 0; i < len1; i++){
            dp[0][i] = 0;
        }

        for (int j = 0; j < len2; j++){
            dp[j][0] = 0;
        }

        for (int i = 1; i <= len2; i++){
            for (int j = 1; j <= len1; j++){
                if (s2[i-1] == s1[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[len2][len1];
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        最长公共子序列1 ss = new 最长公共子序列1();
        System.out.println(ss.longestCommonSubsequence(text1, text2));
    }
}
