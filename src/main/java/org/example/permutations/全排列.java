package org.example.permutations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 全排列 {

    /**
     * 46. 全排列
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        int len = nums.length;
        int depth = 0;
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, len, depth, path, used, res);
        return res;
    }


    private void dfs(int[] nums, int len, int depth, Deque<Integer> path,
                     boolean[] used, List<List<Integer>> res){
        if (depth == len){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++){
            if (used[i]){
                continue;
            }

            path.addLast(nums[i]);
            used[i] = true;

            System.out.println("  递归之前 => " + path);
            dfs(nums, len, depth+1, path, used, res);
            used[i] = false;
            path.removeLast();
            System.out.println("递归之后 => " + path);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        全排列 ss = new 全排列();
        System.out.println(ss.permute(nums));
    }
}
