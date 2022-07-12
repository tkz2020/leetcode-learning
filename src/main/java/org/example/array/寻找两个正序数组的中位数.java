package org.example.array;

public class 寻找两个正序数组的中位数 {

    /**
     * https://leetcode.cn/problems/median-of-two-sorted-arrays/
     * 方法一：先将两个数组合并成一个数组，然后在求中位数
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = merge(nums1, nums2);
        int len = result.length;
        if (len % 2 == 1){
            return result[len / 2];
        } else {
            return (result[len / 2 - 1] + result[len / 2]) / 2.0;
        }
    }

    /**
     * 合并两个数组
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] merge(int[] nums1, int[] nums2){
        if (nums1 == null || nums2 == null){
            return nums1 == null ? nums2 : nums1;
        }

        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] result = new int[len1 + len2];
        int point1 = 0, point2 = 0, index = 0, cur = 0;
        while (point1 < len1 || point2 < len2){
            if (point1 == len1){
                cur = nums2[point2++];
            } else if (point2 == len2){
                cur = nums1[point1++];
            } else if (nums1[point1] < nums2[point2]){
                cur = nums1[point1++];
            } else {
                cur = nums2[point2++];
            }
            result[index++] = cur;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        寻找两个正序数组的中位数 ss = new 寻找两个正序数组的中位数();
        System.out.println(ss.findMedianSortedArrays(nums1, nums2));
    }
}
