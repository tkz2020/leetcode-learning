package org.example.二分查找;

public class 搜索旋转排序数组 {

        public int search(int[] nums, int target) {
                if (nums == null || nums.length == 0){
                        return -1;
                }

                int left = 0, right = nums.length - 1;
                while (left <= right){
                        int middle = (left + right) >> 1;
                        if (nums[middle] == target){
                                return middle;
                        } else if (nums[left] <= nums[middle]){    //在左半边查找
                                if (nums[left] <= target && target < nums[middle]){
                                        right = middle - 1;
                                } else {
                                        left = middle + 1;
                                }
                        } else {
                                if (nums[middle] < target && target <= nums[right]){  //在右半边查找
                                        left = middle + 1;
                                } else {
                                        right = middle - 1;
                                }
                        }
                }
                return -1;
        }

        public static void main(String[] args) {

        }
}
