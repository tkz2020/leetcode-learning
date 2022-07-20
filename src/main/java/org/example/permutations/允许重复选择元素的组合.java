package org.example.permutations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 允许重复选择元素的组合 {

    /**
     * https://leetcode.cn/problems/Ygoe9J/
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || target == 0){
            return new ArrayList<>();
        }

        int start = 0;
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> resultList = new ArrayList<>();
        dfs(candidates, target, start, path, resultList);
        return resultList;
    }


    public void dfs(int[] candidates, int target, int start, Deque<Integer> path, List<List<Integer>> resultList){
        if (target == 0){
            resultList.add(new ArrayList<>(path));
            return;
        }

        if (target < 0){
            return;
        }

        for (int i = start; i < candidates.length; i++){
            path.addLast(candidates[i]);
            dfs(candidates, target - candidates[i], i, path, resultList);
            path.removeLast();
        }
    }

    public static void main(String[] args) {

    }
}
