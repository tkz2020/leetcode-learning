package org.example.dynamic.programming;

public class 最长回文子串 {

    /**
     * 5. 最长回文子串
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     *
     * 示例 1：
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     *
     * 示例 2：
     * 输入：s = "cbbd"
     * 输出："bb"
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() == 0){
            return "";
        }

        if (s.length() == 1){
            return s;
        }

        return "";
    }


    public static void main(String[] args) {

    }
}
