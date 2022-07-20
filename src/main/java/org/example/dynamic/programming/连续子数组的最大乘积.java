package org.example.dynamic.programming;

public class 连续子数组的最大乘积 {


    public int maxProduct (int[] nums) {
        // write code here
        if (nums == null || nums.length == 0){
            return -1;
        }

        int len = nums.length;
        int min = 1, max = 1, ans = Integer.MIN_VALUE;
        for(int i = 0; i < len; i++) {
            if(nums[i] < 0) {
                int temp = min;
                min = max;
                max = temp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            ans = Math.max(ans, max);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-2,5};
        连续子数组的最大乘积 ss = new 连续子数组的最大乘积();
        ss.maxProduct(nums);
    }
}
