package org.example.permutations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 子集2 {


    /**
     * 90. 子集 II
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        int len = nums.length;
        int startIndex = 0;
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        dfs(nums, len, startIndex, res, path, used);
        return res;
    }


    public void dfs(int[] nums, int len, int startIndex, List<List<Integer>> res,
                    Deque<Integer> path, boolean[] used){
        //这块需求注意下，不能放到if条件的里面
        res.add(new ArrayList<>(path));
        for (int i = startIndex; i < len; i++){

            if (i != startIndex && nums[i] == nums[i-1]){
                continue;
            }

            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, i+1, res, path, used);
            used[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {

    }
}
