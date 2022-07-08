package org.example.binary.search;

public class 二分查找_非递归 {


    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    private int binarySearch(int[] nums, int target){
        if (nums == null || nums.length == 0){
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int middle = (left + right) >> 1;
            if (nums[middle] < target){
                left = middle + 1;
            } else if (nums[middle] > target){
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        int target = 5;
        二分查找_非递归 ss = new 二分查找_非递归();
        System.out.println(ss.binarySearch(nums, target));
    }
}
