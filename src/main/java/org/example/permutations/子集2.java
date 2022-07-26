package org.example.permutations;

import java.util.*;

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

        //todo 这块注意是先要排序的
        Arrays.sort(nums);
        int len = nums.length;
        int startIndex = 0;
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, len, startIndex, res, path);
        return res;
    }


    public void dfs(int[] nums, int len, int startIndex, List<List<Integer>> res,
                    Deque<Integer> path){
        //这块需求注意下，不能放到if条件的里面
        res.add(new ArrayList<>(path));
        if (startIndex == len){
            return;
        }

        for (int i = startIndex; i < len; i++){
            if (i > startIndex && nums[i] == nums[i-1]){
                continue;
            }

            path.addLast(nums[i]);
            dfs(nums, len, i+1, res, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        子集2 ss = new 子集2();
        System.out.println(ss.subsetsWithDup(nums));
    }
}
