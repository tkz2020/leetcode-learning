package org.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 四数之和 {

    /**
     * https://leetcode.cn/problems/4sum/
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length == 0 || nums.length < 4){
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        return resultList;
    }


    public static void main(String[] args) {

    }
}
