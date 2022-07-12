package org.example.permutations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 路径总和II {


    /**
     * https://leetcode.cn/problems/path-sum-ii/
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null){
            return new ArrayList<>();
        }

        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> allResultList = new ArrayList<>();
        dfs(root, path, allResultList);
        List<List<Integer>> resultList = new ArrayList<>();
        for (List<Integer> result : allResultList){
            int sum = 0;
            for (Integer res : result){
                sum += res;
            }

            if (targetSum == sum){
                resultList.add(result);
            }
        }
        return resultList;
    }


    /**
     * 回溯找到二叉树的所有路径
     * @param root
     * @param path
     * @param resultList
     */
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
