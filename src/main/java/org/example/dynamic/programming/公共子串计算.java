package org.example.dynamic.programming;

public class 公共子串计算 {

    /**
     * https://www.nowcoder.com/practice/98dc82c094e043ccb7e0570e5342dd1b?tpId=37&tqId=21298&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=3&judgeStatus=undefined&tags=&title=
     * @param a
     * @param b
     * @return
     */
    public int longCommonLength(String a, String b){
        if (a == null || a.length() == 0 || b == null || b.length() == 0){
            return 0;
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

        int max = 0;
        for (int i = 1; i <= len1; i++){
            for (int j = 1; j <= len2; j++){
                if (a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String a = "asdfas";
        String b = "werasdfaswer";
        公共子串计算 ss = new 公共子串计算();
        ss.longCommonLength(a, b);
    }
}
