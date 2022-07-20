package org.example.permutations;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 组合 {

    /**
     * https://leetcode.cn/problems/combinations/
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0){
            return new ArrayList<>();
        }

        List<List<Integer>> resultList = new ArrayList<>();
        int start = 1;
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, start, path, resultList);
        return resultList;
    }


    public void dfs(int n, int k, int start, Deque<Integer> path, List<List<Integer>> resultList){
        if (path.size() == k){
            resultList.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++){
            path.addLast(i);
            dfs(n, k, i+1, path, resultList);
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        int n = 4, k = 2;
        组合 ss = new 组合();
        System.out.println(ss.combine(n, k));
    }
}
