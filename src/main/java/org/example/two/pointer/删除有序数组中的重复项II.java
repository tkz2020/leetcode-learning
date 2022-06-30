package org.example.two.pointer;

public class 删除有序数组中的重复项II {

    /**
     * https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        return process(nums, 2);
    }


    private int process(int[] nums, int k){
        int left = 0;
        for (int x : nums){
            if (left < k || nums[left-k] != x){
                nums[left++] = x;
            }
        }
        return left;
    }


    public int removeDuplicates1(int[] nums) {

        int len = nums.length;
        int index = 1;
        int count = 1;
        for (int i = 1; i < len; i++){
            if (nums[i-1] != nums[i]){
                count=1;
            } else {
                count++;
            }

            if (count <= 2){
                nums[index++] = nums[i];
            }
        }
        return index;
    }


    public static void main(String[] args) {

    }
}
