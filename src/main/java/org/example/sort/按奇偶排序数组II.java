package org.example.sort;

public class 按奇偶排序数组II {


    /**
     * https://leetcode.cn/problems/sort-array-by-parity-ii/
     * @param nums
     * @return
     */
    public int[] sortArrayByParityII(int[] nums) {
        if (nums == null || nums.length == 0){
            return new int[]{};
        }

        //i指向偶数位置，j指向奇数位置。
        int len = nums.length;
        int j = 1;
        for (int i = 0; i < len; i+=2){
            if (nums[i] % 2 == 1){
                while (nums[j] % 2 == 1){
                    j+=2;
                }
                swap(nums, i, j);
            }
        }
        return nums;
    }


    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {

    }
}
