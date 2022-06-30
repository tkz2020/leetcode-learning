package org.example.practise;

import java.util.HashMap;
import java.util.Map;

public class 多数元素 {

    /**
     * 169. 多数元素
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0){
            return -1;
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> map : countMap.entrySet()){
            if (map.getValue() > nums.length / 2){
                return map.getKey();
            }
        }
        return -1;
    }


    public static void main(String[] args) {

    }
}
