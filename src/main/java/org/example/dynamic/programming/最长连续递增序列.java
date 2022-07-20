package org.example.dynamic.programming;

import java.util.Arrays;

public class 最长连续递增序列 {

    /**
     * 674. 最长连续递增序列
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        if (nums.length == 1){
            return nums.length;
        }

        int maxLength = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i + 1] > nums[i]){
                count++;
            } else {
                count = 1;
            }
            maxLength = Math.max(maxLength, count);
        }
        return maxLength;
    }


    public int findLengthOfLCIS1(int[] nums) {
        int maxLength = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++){
            if (i > 0 && nums[i] <= nums[i-1]){
                start = i;
            }
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }


    /**
     * 双指针实现
     * @param nums
     * @return
     */
    public int findLengthOfLCIS2(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }

        if (nums.length == 1){
            return nums.length;
        }

        int left = 0, right = 1;
        int length = nums.length;
        int maxLength = 1;
        while (right < length){
            if (nums[right] > nums[left]){
                for (int i = right; i < length; i++){
                    if (nums[i] > nums[i-1]){
                        maxLength = Math.max(maxLength, right - left + 1);
                        right++;
                    }
                }
            } else {
                left = right;
                right++;
            }
        }
        return maxLength;
    }


    /**
     * 用dp数组来统计每一位的连续长度
     * @param nums
     * @return
     */
    public int findLengthOfLCIS3(int[] nums){
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        int maxLength = 1;
        for (int i = 1; i < len; i++){
            if (nums[i] > nums[i-1]){
                dp[i] = dp[i-1] + 1;
            }
            maxLength = Math.max(dp[i], maxLength);
        }
        return maxLength;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1};
        最长连续递增序列 ss = new 最长连续递增序列();
        ss.findLengthOfLCIS3(nums);

    }
}
