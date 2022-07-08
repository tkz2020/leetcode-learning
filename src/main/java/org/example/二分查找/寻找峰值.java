package org.example.二分查找;

public class 寻找峰值 {

    /**
     * BM19 寻找峰值
     * @param nums
     * @return
     */
    public int findPeakElement (int[] nums) {

        int left = 0, right = nums.length - 1;
        while (left < right){
            int middle = (left + right) >> 1;
            if (nums[middle] > nums[middle+1]){
                right = middle;
            } else {
                left = middle;
            }
        }
        return right;
    }


    public static void main(String[] args) {


    }
}
