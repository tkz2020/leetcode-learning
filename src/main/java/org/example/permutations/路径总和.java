package org.example.permutations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 路径总和 {

    /**
     * https://leetcode.cn/problems/path-sum/
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }

        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> resultList = new ArrayList<>();
        dfs(root, path, resultList);
        System.out.println(resultList);
        for (List<Integer> res : resultList){
            int sum = 0;
            for (Integer s : res){
                sum = sum * 10 + s;
            }
            if (sum == targetSum){
                return true;
            }
        }
        return false;
    }

    public void dfs(TreeNode root, Deque<Integer> path, List<List<Integer>> resultList){
        if (root == null){
            return;
        }

        path.addLast(root.val);
        if (root.left == null && root.right == null){
            resultList.add(new ArrayList<>(path));
        }

        dfs(root.left, path, resultList);
        dfs(root.right, path, resultList);
        path.removeLast();
    }

    public static void main(String[] args) {

    }
}
