package org.example.two.pointer;

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
        //对数组进行从小到大的排序
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < len; i++){
            //排序数组，第一个大于0，那肯定不会有相加和尾0的，直接返回
            if (nums[i] > 0){
                return resultList;
            }

            //有相等的元素直接跳过
            if (i > 0 && nums[i-1] == nums[i]){
                continue;
            }

            //定义左右指针
            int left = i+1;
            int right = len-1;

            while (left < right){
                if (nums[i] + nums[left] + nums[right] == 0){
                    List<Integer> recList = new ArrayList<>();
                    recList.add(nums[i]);
                    recList.add(nums[left]);
                    recList.add(nums[right]);
                    resultList.add(recList);
                    //排除相等的元素
                    while (left < right && nums[left] == nums[left+1]){
                        left++;
                    }

                    //排除相等的元素
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

    }
}
