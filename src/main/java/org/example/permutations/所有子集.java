package org.example.permutations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 所有子集 {

    /**
     * https://leetcode.cn/problems/TVdhkn/
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        int start = 0;
        int len = nums.length;
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> resultList = new ArrayList<>();
        dfs(nums, start, len, path, resultList);
        return resultList;
    }


    public void dfs(int[] nums, int start, int len, Deque<Integer> path, List<List<Integer>> resultList){
        resultList.add(new ArrayList<>(path));
        if (start == len){
            return;
        }

        for (int i = start; i < len; i++){
            path.addLast(nums[i]);
            dfs(nums, i+1, len, path, resultList);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        所有子集 ss = new 所有子集();
        System.out.println(ss.subsets(nums));
    }
}
