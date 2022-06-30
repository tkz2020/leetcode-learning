package org.example.two.pointer;

public class 删除有序数组中的重复项 {

    /**
     * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int left = 0, right = 1;
        while (right < len){
            if (nums[left] != nums[right]){
                left++;
                nums[left] = nums[right];
            }
            right++;
        }
        return left+1;
    }

    public static void main(String[] args) {

    }
}
