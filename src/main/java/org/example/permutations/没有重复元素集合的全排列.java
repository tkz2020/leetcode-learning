package org.example.permutations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 没有重复元素集合的全排列 {

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        int len = nums.length;
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> resultList = new ArrayList<>();
        dfs(nums, len, 0, used, path, resultList);
        return resultList;
    }


    public void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> resultList){
        if (depth == len){
            resultList.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++){
            if (used[i]){
                continue;
            }

            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }

            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth+1, used, path, resultList);
            used[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        没有重复元素集合的全排列 ss = new 没有重复元素集合的全排列();
        System.out.println(ss.permute(nums));
    }
}
