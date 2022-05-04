package org.example.dynamic.programming;

public class 连续子数组的最大和 {


    /**
     * 剑指 Offer 42. 连续子数组的最大和
     * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     * 要求时间复杂度为O(n)。
     *
     * 示例1:
     * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     *
     *
     * 状态定义：dp[i] 表示以num[i]结尾的连续子数组的最大和；
     * 状态转移方程：
     * 1、如果dp[i-1] > 0，dp[i] = dp[i-1] + nums[i]
     * 2、如果dp[i-1] <= 0，dp[i] = nums[i]
     * 初始化：dp[0] = nums[0]
     * 输出：max(dp)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if(nums == null || len == 0){
            return 0;
        }

        int[] dp = new int[len];
        dp[0] = nums[0];
        int res = nums[0];
        for(int i = 1; i < len; i++){
            dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    public static void main(String[] args) {

    }
}
