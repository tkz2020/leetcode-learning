package org.example.dfs;

import java.util.ArrayList;

public class 括号生成 {

    /**
     * BM60 括号生成
     * @param n
     * @return
     */
    public ArrayList<String> generateParenthesis (int n) {
        ArrayList<String> resList = new ArrayList<>();
        dfs(0, 0, "", resList, n);
        return resList;
    }


    public void dfs(int left, int right, String temp, ArrayList<String> resList, int n){
        if (left == n && right == n){
            resList.add(temp);
            return;
        }

        if (left < n){
            dfs(left+1, right, temp + "(", resList, n);
        }

        if (right < n && left > right){
            dfs(left, right+1, temp + ")", resList, n);
        }
    }


    public static void main(String[] args) {
        括号生成 ss = new 括号生成();
        System.out.println(ss.generateParenthesis(2));
    }
}
