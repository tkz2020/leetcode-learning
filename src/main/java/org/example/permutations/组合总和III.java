package org.example.permutations;

import java.util.*;

public class 组合总和III {

    /**
     * https://leetcode.cn/problems/combination-sum-iii/
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n == 0 || k == 0){
            return new ArrayList<>();
        }

        Deque<Integer> deque = new ArrayDeque<>();
        List<List<Integer>> resultList = new ArrayList<>();
        dfs(n, k, 1, deque, resultList);
        return resultList;
    }


    public void dfs(int n, int k, int startIndex, Deque<Integer> deque, List<List<Integer>> resultList){
        if (n == 0 && deque.size() == k){
            resultList.add(new ArrayList<>(deque));
            return;
        }

        if (n < 0){
            return;
        }

        for (int i = startIndex; i <= 9; i++){
            deque.addLast(i);
            //i+1表示每个数只能用一次
            dfs(n-i, k, i+1, deque, resultList);
            deque.removeLast();
        }
    }


    public static void main(String[] args) {
        int n = 7, k = 3;
        组合总和III ss = new 组合总和III();
        System.out.println(ss.combinationSum3(k, n));
    }
}
