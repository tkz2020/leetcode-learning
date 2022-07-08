package org.example.permutations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 组合总和 {

    /**
     * https://leetcode.cn/problems/combination-sum/
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0){
            return new ArrayList<>();
        }

        int len = candidates.length;
        List<List<Integer>> resList = new ArrayList<>();
        int start = 0;
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, start, len, target, path, resList);
        return resList;
    }


    /**
     * dfs
     * @param candidates
     * @param start
     * @param len
     * @param target
     * @param path
     * @param resList
     */
    public void dfs(int[] candidates, int start, int len, int target, Deque<Integer> path,
                    List<List<Integer>> resList){
        if (target < 0){
            return;
        }

        if (target == 0){
            resList.add(new ArrayList<>(path));
        }

        // 重点理解这里从 begin 开始搜索的语意
        for (int i = start; i < len; i++){
            path.addLast(candidates[i]);
            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(candidates, i, len, target - candidates[i], path, resList);

            path.removeLast();
        }
    }


    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        int target = 7;
        组合总和 ss = new 组合总和();
        System.out.println(ss.combinationSum(nums, target));
    }
}
