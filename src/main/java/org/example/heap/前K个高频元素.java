package org.example.heap;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 前K个高频元素 {

    /**
     * 347. 前 K 个高频元素
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {

        //统计每个数字出现的次数
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);
        }

        //int[] 的第一个元素代表数组的值，第二个元素代表了该数组出现的次数
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        //遍历出现次数的集合
        for (Map.Entry<Integer, Integer> map : frequency.entrySet()){
            Integer key = map.getKey();
            Integer value = map.getValue();
            //判断当前堆里面的元素格式是否等于k
            if (priorityQueue.size() == k){
                if (priorityQueue.peek()[1] < value){
                    priorityQueue.poll();
                    priorityQueue.offer(new int[]{key, value});
                }
            } else {
                priorityQueue.offer(new int[]{key, value});
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++){
            result[i] = priorityQueue.poll()[0];
        }
        return result;
    }

    /**
     * https://leetcode.cn/problems/top-k-frequent-elements/
     * 小根堆实现前K个高频元素
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent1(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return new int[]{};
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //小根堆
        PriorityQueue<int[]> queue = new PriorityQueue<>((int[] o1, int[] o2) -> o1[1] - o2[1]);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (queue.size() < k){
                queue.offer(new int[]{entry.getKey(), entry.getValue()});
            } else {
                if (entry.getValue() > queue.peek()[1]){
                    queue.poll();
                    queue.offer(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }

        int[] result = new int[k];
        int index = 0;
        while (!queue.isEmpty()){
            result[index++] = queue.poll()[0];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1,1,2,2,2,2,2,2,3,3,3,3,3,4,4,4,4,5,5,5,6,6,7,7,7,7,7,7,7};
        int k = 2;
        前K个高频元素 ss = new 前K个高频元素();
        ss.topKFrequent(nums, 4);
    }
}
