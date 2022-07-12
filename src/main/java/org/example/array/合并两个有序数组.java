package org.example.array;

public class 合并两个有序数组 {

        public void merge(int[] nums1, int m, int[] nums2, int n) {
                int[] merge = new int[m+n];
                int index = 0;
                int i = 0, j = 0;
                int cur = 0;
                while (i < m || j < n){
                        if (i == m){
                                // num1 数组已经遍历完了
                                cur = nums2[j++];
                        } else if (j == n){
                                // num2 数组已经遍历完了
                                cur = nums1[i++];
                        } else if (nums1[i] < nums2[j]){
                                cur = nums1[i++];
                        } else {
                                cur = nums2[j++];
                        }
                        merge[index++] = cur;
                }

                for (int s = 0; s != m+n; s++){
                        nums1[s] = merge[s];
                }
        }

        public static void main(String[] args) {
                int[] nums1 = {1,2,3,0,0,0};
                int m = 3;
                int[] nums2 = {2,5,6};
                int n = 3;
                合并两个有序数组 ss = new 合并两个有序数组();
                ss.merge(nums1, m, nums2, n);
        }
}
