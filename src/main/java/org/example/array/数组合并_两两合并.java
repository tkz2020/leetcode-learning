package org.example.array;

import java.util.Arrays;

public class 数组合并_两两合并 {


    public int[] mergeArray(int[][] nums){
        if (nums.length == 0){
            return new int[]{};
        }

        if (nums.length == 1){
            return nums[0];
        }

        int rows = nums.length / 2;
        //两两合并后的数组
        int[][] result = new int[rows][];
        for (int i = 0; i < nums.length; i+=2){
            result[i/2] = merge(nums[i], nums[i+1]);
        }
        return mergeArray(result);
    }

    /**
     * 合并两个排序链表
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] merge(int[] nums1, int[] nums2){
        if (nums1.length == 0 || nums2.length == 0){
            return nums1.length == 0 ? nums2 : nums1;
        }

        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] result = new int[len1 + len2];
        int tmp1 = 0, tmp2 = 0, index = 0;
        while (tmp1 < len1 && tmp2 < len2){
            if (nums1[tmp1] < nums2[tmp2]){
                result[index++] = nums1[tmp1++];
            } else {
                result[index++] = nums2[tmp2++];
            }
        }

        while (tmp1 < len1){
            result[index++] = nums1[tmp1++];
        }

        while (tmp2 < len2){
            result[index++] = nums2[tmp2++];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 5, 11, 23}, {3, 6, 8, 20}, {2, 4, 7, 15}, {9, 10, 19, 28}};
        数组合并_两两合并 ss = new 数组合并_两两合并();
        System.out.println(Arrays.toString(ss.mergeArray(nums)));
    }
}
