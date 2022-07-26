package org.example.permutations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 幂集 {

    /**
     * https://leetcode.cn/problems/power-set-lcci/
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> resultList = new ArrayList<>();
        dfs(nums, 0, path, resultList);
        return resultList;
    }


    public void dfs(int[] nums, int startIndex, Deque<Integer> path, List<List<Integer>> resultList){
        resultList.add(new ArrayList<>(path));
        if (startIndex == nums.length){
            return;
        }

        for (int i = startIndex; i < nums.length; i++){
            path.addLast(nums[i]);
            dfs(nums, i + 1, path, resultList);
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        幂集 ss = new 幂集();
        System.out.println(ss.subsets(nums));
    }
}
