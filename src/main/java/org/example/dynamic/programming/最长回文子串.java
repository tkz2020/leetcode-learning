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

        int len = s.length();
        int maxLen = 0;
        int begin = 0;

        char[] array = s.toCharArray();
        for (int i = 0; i < len - 1; i++){
            int oddLen = expandAroundCenter(array, i, i);
            int evenLen = expandAroundCenter(array, i, i+1);

            int curMaxLen = Math.max(oddLen, evenLen);
            if (curMaxLen > maxLen){
                maxLen = curMaxLen;
                begin = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    private int expandAroundCenter(char[] array, int left, int right){
        int len = array.length;
        int i = left, j = right;
        while (i >=0 && j < len){
            if (array[i] == array[j]){
                //左边界向左，有边界向右逐步扩散
                i--;
                j++;
            } else {
                break;
            }
        }
        return j - i + 1;
    }


    /**
     * 动态规划实现最长回文子串
     * @param s
     * @return
     */
    public String longestPalindrome1(String s){
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++){
            dp[i][i] = true;
        }

        int longestPalindromeLen = 1;
        int beginIndex = 0;
        char[] chars = s.toCharArray();
        for (int right = 1; right < len; right++){
            for (int left = 0; left < right; left++){
                if (chars[left] != chars[right]){
                    dp[left][right] = false;
                } else {
                    // 字符串长度为2，前后两个字符相等，肯定为回文串
                    if (right - left < 3){
                        dp[left][right] = true;
                    } else {
                        dp[left][right] = dp[left+1][right-1];
                    }
                }

                if (dp[left][right] && right - left + 1 > longestPalindromeLen){
                    longestPalindromeLen = right - left + 1;
                    beginIndex = left;
                }
            }
        }

        return s.substring(beginIndex, beginIndex + longestPalindromeLen);
    }
    public static void main(String[] args) {

    }
}
