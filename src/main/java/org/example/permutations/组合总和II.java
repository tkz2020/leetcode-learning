package org.example.permutations;

import java.util.*;

public class 组合总和II {

    /**
     * https://leetcode.cn/problems/combination-sum-ii/
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0){
            return new ArrayList<>();
        }

        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> resultList = new ArrayList<>();
        dfs(candidates, target, 0, path, resultList);
        return resultList;
    }


    public void dfs(int[] candidates, int target, int startIndex, Deque<Integer> path, List<List<Integer>> resultList){
        if (target == 0){
            resultList.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++){

            if (candidates[i] > target){
                break;
            }

            if (i > startIndex && candidates[i] == candidates[i-1]){
                continue;
            }

            path.addLast(candidates[i]);
            dfs(candidates, target - candidates[i], i+1, path, resultList);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        组合总和II ss = new 组合总和II();
        System.out.println(ss.combinationSum2(candidates, target));
    }
}
