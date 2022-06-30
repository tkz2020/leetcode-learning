package org.example.dynamic.programming;

public class 最长公共子串 {

    /**
     * NC127 最长公共子串
     * @param str1
     * @param str2
     * @return
     */
    public String LCS (String str1, String str2) {
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0){
            return "";
        }

        String result = "";
        int left = 0;
        int right = 0;
        int len = str2.length();
        while (right <= len){
            String subStr = str2.substring(left, right);
            if (str1.contains(subStr)){
                result = subStr;
            } else {
                left++;
            }
            right++;
        }
        return result;
    }


    public String LCS1 (String str1, String str2){
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0){
            return "";
        }

        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1+1][len2+1];

        //把第一列赋值为0
        for (int i = 0; i < len1; i++){
            dp[i][0] = 0;
        }

        //把第一行赋值为0
        for (int j = 0; j < len2; j++){
            dp[0][j] = 0;
        }

        int maxLen = 0;
        int maxEnd = 0;
        int max = 0;
        for (int i = 1; i <= len1; i++){
            for (int j = 1; j <= len2; j++){
                if (str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                }

                if (dp[i][j] > maxLen){
                    maxLen = dp[i][j];
                    maxEnd = i;
                }
            }
        }

        return str1.substring(maxEnd - maxLen, maxEnd);
    }


    public static void main(String[] args) {
        String s1 = "1AB2345CD";
        String s2 = "12345EF";
        最长公共子串 ss = new 最长公共子串();
        ss.LCS(s1, s2);
    }
}
