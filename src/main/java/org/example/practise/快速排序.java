package org.example.practise;

import java.util.Arrays;

public class 快速排序 {


    public void quickSort(int[] nums, int left, int right){
        if (left >= right){
            return;
        }

        int point = nums[left];
        int i = left;
        int j = right;
        while (i < j){
            //
            while (i < j && nums[j] >= point){
                j--;
            }

            if (i < j){
                swap(nums, i, j);
            }

            while (i < j && nums[i] < point){
                i++;
            }

            if (i < j){
                swap(nums, i, j);
            }
        }
        quickSort(nums, left, i-1);
        quickSort(nums, i+1, right);
    }


    public void swap(int[] nums, int i, int j){
        if (nums == null || nums.length == 0){
            return;
        }

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{47,29,71,99,78,19,24,47};
        快速排序 s = new 快速排序();
        s.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

}
