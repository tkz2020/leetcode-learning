package org.example.array;

import com.sun.org.apache.xerces.internal.impl.dv.xs.AnyURIDV;

import java.util.*;

public class 两个数组的交集 {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null){
            return new int[]{};
        }

       int len1 = nums1.length, len2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        Set<Integer> set = new HashSet<>();
        while (i < len1 && j < len2){
            if (nums1[i] == nums2[j]){
                set.add(nums1[i]);
                i++; j++;
            } else if (nums1[i] < nums2[j]){
                i++;
            } else {
                j++;
            }
        }

        int[] res = new int[set.size()];
        int index = 0;
        for (Integer s : set){
            res[index++] = s;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        两个数组的交集 ss = new 两个数组的交集();
        ss.intersection(nums1, nums2);
    }
}
