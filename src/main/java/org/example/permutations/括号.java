package org.example.permutations;

import java.util.ArrayList;
import java.util.List;

public class 括号 {

    /**
     * https://leetcode.cn/problems/bracket-lcci/
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        if (n == 0){
            return new ArrayList<>();
        }

        List<String> resultList = new ArrayList<>();
        dfs(n, 0, 0, "", resultList);
        return resultList;
    }


    public void dfs(int n, int left, int right, String tmp, List<String> resultList){
        if (left == n && right == n){
            resultList.add(new String(tmp));
            return;
        }

        if (left < n){
            dfs(n, left+1, right, tmp + "(", resultList);
        }

        if (right < n && left > right){
            dfs(n, left, right + 1, tmp + ")", resultList);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        括号 ss = new 括号();
        System.out.println(ss.generateParenthesis(n));
    }
}
