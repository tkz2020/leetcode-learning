package org.example.dynamic.programming;

public class 最长重复子数组 {

    /**
     * https://leetcode.cn/problems/maximum-length-of-repeated-subarray/
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2){
        if (nums1 == null || nums2 == null){
            return 0;
        }

        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 0; i <= len1; i++){
            dp[i][0] = 0;
        }

        for (int j = 0; j <= len2; j++){
            dp[0][j] = 0;
        }

        int maxLength = 0;
        for (int i = 1; i < len1; i++){
            for (int j = 1; j < len2; j++){
                if (nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,2,1};
        int[] nums2 = {3,2,1,4,7};
        最长重复子数组 ss = new 最长重复子数组();
        ss.findLength(nums1, nums2);
    }
}
