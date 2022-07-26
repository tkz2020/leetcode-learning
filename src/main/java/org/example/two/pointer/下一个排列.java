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
    public void nextPermutation2(int[] nums) {
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


    /**
     * nowcoder.com/practice/50b0b87e50be4944b34cb0f2ce618197?tpId=196&tqId=39375&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D4%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196&difficulty=undefined&judgeStatus=undefined&tags=&title=
     * NC194 下一个排列
     * @param nums
     * @return
     */
    public int[] nextPermutation1 (int[] nums) {
        // write code here
        if (nums == null || nums.length == 0){
            return new int[]{};
        }

        int len = nums.length;
        for (int i = len - 1; i >= 0; i--){
            for (int j = len - 1; j > i; j--){
                if (nums[i] < nums[j]){
                    swap(nums, i, j);
                    Arrays.sort(nums, i+1, len);
                    return nums;
                }
            }
        }
        Arrays.sort(nums);
        return nums;
    }



    public static void main(String[] args) {
        int[] nums = {1,2,3};
        下一个排列 ss = new 下一个排列();
        ss.nextPermutation(nums);
    }
}
