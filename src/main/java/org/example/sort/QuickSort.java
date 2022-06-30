package org.example.sort;

import java.util.Arrays;

public class QuickSort {


    public void quickSort(int[] nums, int start, int end){
        if (nums == null || nums.length == 0){
            return;
        }

        int left = start;
        int right = end;
        int pivot = nums[start];
        while (left < right){

            while (left < right && nums[right] >= pivot){
                right--;
            }

            if (nums[right] < pivot){
                swap(nums, left, right);
            }

            while (left < right && nums[left] <= pivot){
                left++;
            }

            if (nums[left] > pivot){
                swap(nums, left, right);
            }
        }
        if (left > start){
            quickSort(nums, start, left-1);
        }
        if (right < end){
            quickSort(nums, right+1, end);
        }
    }


    public void swap(int[] nums, int left, int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        int[] num = {0,1,7,2,5};
        QuickSort q = new QuickSort();
        q.quickSort(num, 0, num.length - 1);
        System.out.println(Arrays.toString(num));
    }
}
