package org.example.dynamic.programming;

import java.util.Arrays;

public class 最长递增子序列的个数 {

    /**
     * 673. 最长递增子序列的个数
     * https://leetcode.cn/problems/number-of-longest-increasing-subsequence/
     * @param nums
     * @return
     */
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        int len = nums.length;
        int[] dp = new int[len];
        int[] cnt = new int[len];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);
        int maxLen = 0, ans = 0;
        for (int i = 0; i < len; i++){
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]){
                    if (dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[j] + 1 == dp[i]){
                        cnt[i] += cnt[j];
                    }
                }
            }

            if (dp[i] > maxLen){
                maxLen = dp[i];
                ans = cnt[i];
            } else if (dp[i] == maxLen){
                ans += cnt[i];
            }
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
