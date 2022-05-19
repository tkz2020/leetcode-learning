package org.example.binary.search;

public class 二分查找_递归 {


    /**
     * 二分查找目标元素
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target){
        if (nums == null || nums.length == 0){
            return -1;
        }

        int left = 0, right = nums.length - 1;
        return recursionBinarySearch(nums, target, left, right);
    }


    public int recursionBinarySearch(int[] nums, int target, int left, int right){
        int low = left;
        int high = right;
        if (low > high){
            return -1;
        }

        int middle = low + (high - low) / 2;
        if (nums[middle] > target){
            return recursionBinarySearch(nums, target, low, middle - 1);
        } else if (nums[middle] < target){
            return recursionBinarySearch(nums, target, middle + 1, high);
        } else {
            return middle;
        }
    }


    public static void main(String[] args) {

    }
}
