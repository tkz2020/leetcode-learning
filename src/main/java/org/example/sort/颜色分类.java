package org.example.sort;

public class 颜色分类 {

    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int start, int end){
        if (start > end){
            return;
        }

        int qivot = nums[start];
        int left = start;
        int right = end;
        while (left < right){
            while (left < right && nums[right] >= qivot){
                right--;
            }

            if (nums[right] < qivot){
                swap(nums, left, right);
            }

            while (left < right && nums[left] <= qivot){
                left++;
            }

            if (nums[left] > qivot){
                swap(nums, left, right);
            }
        }

        if (start < left){
            quickSort(nums, start, left - 1);
        }

        if (right < end){
            quickSort(nums, right + 1, end);
        }
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
