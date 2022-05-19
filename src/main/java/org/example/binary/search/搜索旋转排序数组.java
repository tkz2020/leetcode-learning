package org.example.binary.search;

public class 搜索旋转排序数组 {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right){
            int middle = left + (right - left) / 2;
            if (nums[middle] == target){
                return middle;
            } else if (nums[left] <= nums[middle]){
                if (nums[left] <= target && nums[middle] > target){
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                if (nums[middle] < target && nums[right] >= target){
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,1,1,1};
        int target = 0;
        搜索旋转排序数组 ss = new 搜索旋转排序数组();
        ss.search(nums, target);
    }
}
