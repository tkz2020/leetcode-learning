package org.example.binary.search;

import java.util.*;

public class 两个数组的交集 {


    public ArrayList<Integer> intersection (ArrayList<Integer> nums1, ArrayList<Integer> nums2) {
        if (nums1 == null || nums1.size() == 0 || nums2 == null || nums2.size() == 0){
            return new ArrayList<>();
        }

        //nums排序
        Collections.sort(nums1);
        Set<Integer> result = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (Integer num : nums2){
            Integer target = binarySearch(nums1, num);
            if (target != null){
                result.add(num);
            }
        }
        return new ArrayList<>(result);
    }


    public Integer binarySearch(ArrayList<Integer> numList, int target){
        if (numList == null || numList.size() == 0){
            return null;
        }
        int left = 0;
        int right = numList.size() - 1;
        while (left <= right){
            Integer middle = left + (right - left) / 2;
            if (target < numList.get(middle)){
                right = middle - 1;
            } else if (target > numList.get(middle)){
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{5,50,40,14,75,35,28,97,38,30,38,39,57,76,78,87,23,71,43,82,78,81,66,36,38,33,57,53,92,36,39,57,46,9,10,61,89,28,97,3,70,11,100,20,37,12,60,31,59,97,47,17};
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int num : nums1){
            list1.add(num);
        }

        int[] nums2 = new int[]{49,46,23,95,21,55,98,11,73,34,18,40,78,69,69,3,55,51,32,6,2,47,40,42,58,26,53,22,74,42,23,32,41,50,53,43,30,96,80,96,41,80,51,21,71,91,24,33,14,48,96,37,1,58,50,54,7,15,85,72,33,43,39,50,81};
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int num : nums2){
            list2.add(num);
        }

        两个数组的交集 ss = new 两个数组的交集();
        ss.intersection(list1, list2);
    }
}
