package org.example.practise;

public class 按奇偶排序数组 {


    /**
     * 905. 按奇偶排序数组
     * @param nums
     * @return
     */
    public int[] sortArrayByParity(int[] nums) {
        if (nums == null || nums.length == 0){
            return nums;
        }

        int length = nums.length;
        int[] result = new int[length];
        int index = 0;
        for (int i = 0; i < length; i++){
            if (nums[i] % 2 == 1){
                result[index++] = nums[i];
            }
        }

        for (int i = 0; i < length; i++){
            if (nums[i] % 2 == 0){
                result[index++] = nums[i];
            }
        }
        return result;
    }


    /**
     * 左右指针
     * @param nums
     * @return
     */
    public int[] sortArrayByParity1(int[] nums){
        if (nums == null || nums.length == 0){
            return nums;
        }

        int length = nums.length;
        int[] result = new int[length];
        int left = 0, right = nums.length - 1;
        for (int i = 0; i < length; i++){
            if (nums[i] % 2 == 0){
                result[left++] = nums[i];
            } else {
                result[right--] = nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
