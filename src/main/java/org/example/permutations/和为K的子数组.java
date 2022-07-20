package org.example.permutations;

import java.util.*;

public class 和为K的子数组 {

    /**
     * https://leetcode.cn/problems/subarray-sum-equals-k/
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || k == 0){
            return 0;
        }

        int startIndex = 0;
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> resultList = new ArrayList<>();
        dfs(nums, k, startIndex, path, resultList);
        return resultList != null ? resultList.size() : 0;
    }

    //todo dfs处理有问题，有些情况是处理不到的
    public void dfs(int[] nums, int k, int startIndex, Deque<Integer> path, List<List<Integer>> resultList){
        if (k == 0){
            resultList.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < nums.length; i++){
            if (nums[i] > k){
                break;
            }

            if (i > startIndex && nums[i] == nums[i-1]){
                continue;
            }

            path.addLast(nums[i]);
            dfs(nums, k - nums[i], i + 1, path, resultList);
            path.removeLast();
        }
    }

    /**
     * https://leetcode.cn/problems/subarray-sum-equals-k/
     * 前缀和+哈希
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum1(int[] nums, int k) {
        int count = 0, pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++){
            pre += nums[i];
            if (map.containsKey(pre - k)){
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int k = 3;
        和为K的子数组 ss = new 和为K的子数组();
        System.out.println(ss.subarraySum1(nums, k));
    }
}
