package org.example.heap;

import java.util.*;

public class 出现频率最高的k个数字 {


    /**
     * https://leetcode.cn/problems/g5c51o/
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {

        //统计nums数组中每个元素出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        //构建一个结点个数为K的小顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(k, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (queue.size() < k){
                queue.add(entry);
            } else {
                if (entry.getValue() > queue.peek().getValue()){
                    queue.poll();
                    queue.add(entry);
                }
            }
        }

        int[] result = new int[queue.size()];
        int index = 0;
        while (!queue.isEmpty()){
            result[index++] = queue.poll().getKey();
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        出现频率最高的k个数字 ss = new 出现频率最高的k个数字();
        System.out.println(Arrays.toString(ss.topKFrequent(nums, 2)));
    }
}
