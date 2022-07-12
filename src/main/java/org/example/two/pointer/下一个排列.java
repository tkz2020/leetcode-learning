package org.example.two.pointer;

import java.util.Arrays;

public class 下一个排列 {

    /**
     * https://leetcode.cn/problems/next-permutation/
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    /**
     * https://leetcode.cn/problems/next-permutation/solution/ren-zhe-suan-fa-quan-wang-zui-qing-xi-yi-s3rr/
     * @param nums
     */
    public void nextPermutation1(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }

        int len = nums.length;
        for (int i = len - 1; i >= 0; i--){
            for (int j = len - 1; j > i; j--){
                if (nums[i] < nums[j]){
                    swap(nums, i, j);
                    Arrays.sort(nums, i+1, len);
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        下一个排列 ss = new 下一个排列();
        ss.nextPermutation(nums);
    }
}
