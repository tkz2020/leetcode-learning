package org.example.permutations;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 子集 {

    /**
     * 78. 子集
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        int len = nums.length;
        int startIndex = 0;
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, len, startIndex, res, path);
        return res;
    }


    public void dfs(int[] nums, int len, int startIndex, List<List<Integer>> res, Deque<Integer> path){
        //这块需求注意下，不能放到if条件的里面
        res.add(new ArrayList<>(path));
        if (startIndex == len){
            return;
        }

        for (int i = startIndex; i < len; i++){
            path.addLast(nums[i]);
            dfs(nums, len, i+1, res, path);
            path.removeLast();
        }
    }


    /**
     * https://leetcode.cn/problems/subsets/
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets1(int[] nums) {
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }

        int len = nums.length;
        List<List<Integer>> resultList = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i <= len; i++){
            dfs(0, i, deque, nums, resultList);
        }
        return resultList;
    }


    public void dfs(int start, int k, Deque<Integer> cur, int[] nums, List<List<Integer>> resultList){
        if (k == 0){
            resultList.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < nums.length; i++){
            cur.addLast(nums[i]);
            dfs(i+1, k-1, cur, nums, resultList);
            cur.removeLast();
        }
    }


    public static void main(String[] args) {

    }
}
