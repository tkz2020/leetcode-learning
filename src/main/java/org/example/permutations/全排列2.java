package org.example.permutations;

import java.util.*;

public class 全排列2 {

    /**
     * 47. 全排列 II
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        int len = nums.length;
        int depth = 0;
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[len];
        dfs(nums, len, depth, path, used, res);
        return res;
    }


    public void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used,
                    List<List<Integer>> res){
        if (len == depth){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++){
            if (used[i]){
                continue;
            }

            if (i > 0 && nums[i] == nums[i-1] && used[i-1]){
                continue;
            }

            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth+1, path, used, res);
            used[i] = false;
            path.removeLast();
        }
    }


    public static void main(String[] args) {

    }
}
