package org.example.sliding.window;

public class 长度最小的子数组 {

    /**
     * 求长度最小的子数组
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int currentSum = 0;
        int minLength = 0;
        while (right < nums.length){
            currentSum = currentSum + nums[right];
            while (currentSum >= target){
                if (right - left + 1 < minLength || minLength == 0){
                    minLength = right - left + 1;
                }
                currentSum = currentSum - nums[left];
                left++;
            }
            right++;
        }
        return minLength;
    }

    public static void main(String[] args) {

    }
}
