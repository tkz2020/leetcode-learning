package org.example.dynamic.programming;

import java.util.HashSet;
import java.util.Set;

public class 连续子数组的最大和二 {

    public int[] FindGreatestSumOfSubArray (int[] array) {
        if (array == null || array.length == 0){
            return new int[]{};
        }

        int len = array.length;
        int[] dp = new int[len];
        int max = array[0];
        dp[0] = array[0];
        for (int i = 1; i < len; i++){
            dp[i] = Math.max(array[i], array[i] + dp[i-1]);
            max = Math.max(max, dp[i]);
        }
        return null;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,-2,3,10,-4,7,2,-5};
        连续子数组的最大和二 ss = new 连续子数组的最大和二();
        ss.FindGreatestSumOfSubArray(nums);
    }
}
