package org.example.array;

import java.util.HashMap;
import java.util.Map;

public class 缺失的第一个正数 {

    /**
     * https://leetcode.cn/problems/first-missing-positive/
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++){
            map.put(nums[i], i);
        }

        int x = 1;
        while (map.containsKey(x)){
            x++;
        }
        return x;
    }

    public static void main(String[] args) {

    }
}
