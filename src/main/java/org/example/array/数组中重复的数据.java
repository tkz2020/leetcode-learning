package org.example.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 数组中重复的数据 {

    /**
     * https://leetcode.cn/problems/find-all-duplicates-in-an-array/
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        List<Integer> resultList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums){
            if (map.containsKey(num)){
                resultList.add(num);
            }
            map.put(num, num);
        }
        return resultList;
    }
}
