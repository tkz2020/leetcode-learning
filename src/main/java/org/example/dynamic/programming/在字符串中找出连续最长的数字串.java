package org.example.dynamic.programming;

import java.util.Scanner;

public class 在字符串中找出连续最长的数字串 {

    public void longestNumberSequence(String str){
        if (str == null || str.length() == 0){
            System.out.println();
        }

        int len = str.length();
        int[] dp = new int[len+1];

        int maxLength = 0;
        for (int i = 1; i <= len; i++){
            if (str.charAt(i-1) >= '0' && str.charAt(i-1) <= '9'){
                dp[i] = dp[i-1] + 1;
                maxLength = Math.max(maxLength, dp[i]);
            }
        }

        for (int i = 0; i <= len; i++){
            if (dp[i] == maxLength){
                System.out.println(str.substring(i-maxLength, i));
            }
        }
        System.out.println("," + maxLength);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String a = in.next();
            String b = in.next();
            System.out.println(a + "," + b);
        }
    }
}
