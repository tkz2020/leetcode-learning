package org.example.二分查找;

public class 搜索插入位置 {

    /**
     * https://leetcode.cn/problems/search-insert-position/
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int middle = (left + right) >> 1;
            if (nums[middle] == target){
                return middle;
            } else if (nums[middle] < target){
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }


    public int searchInsert1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right){
            // 这块不用(left + right) >> 1 是为了防止溢出
            int middle = left + ((right - left) >> 1);
            if (nums[middle] == target){
                return middle;
            } else if (nums[middle] < target){
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {

    }
}
