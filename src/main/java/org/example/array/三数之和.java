package org.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {

    /**
     * https://leetcode.cn/problems/3sum/
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length < 3){
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < len; i++){
            if (nums[i] > 0){
                return resultList;
            }

            if (i > 0 && nums[i-1] == nums[i]){
                continue;
            }

            int left = i+1;
            int right = len-1;
            while (left < right){
                if (nums[i] + nums[left] + nums[right] == 0){
                    List<Integer> resList = new ArrayList<>();
                    resList.add(nums[i]);
                    resList.add(nums[left]);
                    resList.add(nums[right]);
                    resultList.add(resList);
                    while (left < right && nums[left] == nums[left+1]){
                        left++;
                    }

                    while (left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                } else if (nums[i] + nums[left] + nums[right] > 0){
                    right--;
                } else {
                    left++;
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        三数之和 ss = new 三数之和();
        System.out.println(ss.threeSum(nums));
    }
}
