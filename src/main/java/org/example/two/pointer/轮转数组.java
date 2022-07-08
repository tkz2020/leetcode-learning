package org.example.two.pointer;

public class 轮转数组 {

    /**
     * https://leetcode.cn/problems/rotate-array/
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return;
        }

        int len = nums.length;
        k = k % len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    /**
     * 交换数组中两个数的位置
     * @param nums
     * @param left
     * @param right
     */
    public void reverse(int[] nums, int left, int right){
        if (left > right){
            return;
        }

        while (left < right){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        轮转数组 ss = new 轮转数组();
        ss.rotate(nums, k);
    }
}
