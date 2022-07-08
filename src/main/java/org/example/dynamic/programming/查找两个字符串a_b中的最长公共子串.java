package org.example.dynamic.programming;

public class 查找两个字符串a_b中的最长公共子串 {

    /**
     * https://www.nowcoder.com/practice/181a1a71c7574266ad07f9739f791506?tpId=37&tqId=21288&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=3&judgeStatus=undefined&tags=&title=
     * @param a
     * @param b
     * @return
     */
    public String longCommonString(String a, String b){
        if (a == null || a.length() == 0 || b == null || b.length() == 0){
            return "";
        }

        int len1 = a.length();
        int len2 = b.length();
        int[][] dp = new int[len1+1][len2+1];

        for (int i = 0; i < len1; i++){
            dp[len1][0] = 0;
        }

        for (int j = 0; j < len2; j++){
            dp[0][len2] = 0;
        }


        int maxLen = 0;
        int index = 0;
        for (int i = 1; i <= len1; i++){
            for (int j = 1; j <= len2; j++){
                if (a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if (dp[i][j] > maxLen){
                        maxLen = dp[i][j];
                        index = i;
                    }
                }
            }
        }
        return a.substring(index-maxLen, index);
    }


    public static void main(String[] args) {
        String a = "abcdefghijklmnop";
        String b = "abcsafjklmnopqrstuvw";
        查找两个字符串a_b中的最长公共子串 ss = new 查找两个字符串a_b中的最长公共子串();
        System.out.println(ss.longCommonString(a, b));
    }
}
