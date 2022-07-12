package org.example.二分查找;

import java.util.Arrays;

public class 在排序数组中查找元素的第一个和最后一个位置 {


    /**
     * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }

        int leftPosition = findFirstPosition(nums, target);
        int rightPosition = findLastPosition(nums, target);
        if (leftPosition > rightPosition){
            return new int[]{-1, -1};
        }
        return new int[]{leftPosition, rightPosition};
    }

    /**
     * 寻找 target 在 nums 数组中的最左边的下标
     * @param nums
     * @param target
     * @return
     */
    public int findFirstPosition(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int middle = left + ((right - left) >> 1);
            if (target <= nums[middle]){
                //当目标值小于等于nums[mid]时，继续在左区间检索，找到第一个数
                right = middle - 1;
            } else if (target > nums[middle]){
                //目标值大于nums[mid]时，则在右区间继续检索，找到第一个等于目标值的数
                left = middle + 1;
            }
        }
        return left;
    }

    /**
     * 寻找 target 在 nums 数组中的最右边的下标
     * @param nums
     * @param target
     * @return
     */
    public int findLastPosition(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int middle = left + ((right - left) >> 1);
            if (target >= nums[middle]){
                //移动左指针情况
                left = middle + 1;
            } else if (target < nums[middle]){
                //移动右指针情况
                right = middle - 1;
            }
        }
        return right;
    }


    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 6;
        在排序数组中查找元素的第一个和最后一个位置 ss = new 在排序数组中查找元素的第一个和最后一个位置();
        System.out.println(Arrays.toString(ss.searchRange(nums, target)));
    }
}
