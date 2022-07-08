package org.example.hash;

import java.util.HashMap;
import java.util.Map;

public class 缺失的第一个正整数 {

    /**
     * BM53 缺失的第一个正整数
     * @param nums
     * @return
     */
    public int minNumberDisappeared (int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++){
            map.put(nums[i], 1);
        }

        int res = 1;
        while (map.containsKey(res)){
            res++;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
