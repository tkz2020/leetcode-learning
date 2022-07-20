package org.example.sort;

import java.util.Arrays;

public class 排序数组_归并排序 {

    /**
     * 归并排序
     * https://leetcode.cn/problems/sort-an-array/
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return nums;
        }

        int len = nums.length;
        int[] tmps = new int[len];
        mergeSort(nums, 0, len-1, tmps);
        return nums;
    }


    public void mergeSort(int[] nums, int left, int right, int[] tmps){
        if (left >= right){
            return;
        }

        int middle = (left + right) >> 1;
        mergeSort(nums, left, middle, tmps);
        mergeSort(nums, middle+1, right, tmps);
        int i = left, j = middle + 1;
        int index = 0;
        while (i <= middle && j <= right){
            if (nums[i] <= nums[j]){
                tmps[index++] = nums[i++];
            } else {
                tmps[index++] = nums[j++];
            }
        }

        while (i <= middle){
            tmps[index++] = nums[i++];
        }

        while (j <= right){
            tmps[index++] = nums[j++];
        }

        for (int k = 0; k < right - left + 1; ++k){
            nums[k+left] = tmps[k];
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,1,1,2,0,0};
        排序数组_归并排序 ss = new 排序数组_归并排序();
        System.out.println(Arrays.toString(ss.sortArray(nums)));
    }
}
