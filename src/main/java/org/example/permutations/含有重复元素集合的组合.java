package org.example.permutations;

import java.util.*;

public class 含有重复元素集合的组合 {

    /**
     * https://leetcode.cn/problems/4sjJUc/
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target == 0){
            return new ArrayList<>();
        }

        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> resultList = new ArrayList<>();
        dfs(candidates, target, 0, path, resultList);
        return resultList;
    }


    public void dfs(int[] candidates, int target, int start, Deque<Integer> path, List<List<Integer>> resultList){
        if (target == 0){
            resultList.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++){

            if (candidates[i] > target){
                break;
            }

            if (i > start && candidates[i] == candidates[i-1]){
                //因为前面那个同样的数已经经历过dfs，再拿同样的数dfs就会得到重复的答案
                continue;
            }

            path.addLast(candidates[i]);
            dfs(candidates, target - candidates[i],  i + 1, path, resultList);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        含有重复元素集合的组合 ss = new 含有重复元素集合的组合();
        System.out.println(ss.combinationSum2(candidates, target));
    }
}
