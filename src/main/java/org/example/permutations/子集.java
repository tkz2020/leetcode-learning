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


    public static void main(String[] args) {

    }
}
