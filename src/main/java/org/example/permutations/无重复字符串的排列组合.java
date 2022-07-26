package org.example.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 无重复字符串的排列组合 {

    /**
     * https://leetcode.cn/problems/permutation-i-lcci/
     * @param S
     * @return
     */
    public String[] permutation(String S) {
        if (S == null || S.length() == 0){
            return new String[]{};
        }

        char[] chars = S.toCharArray();
        int len = S.length();
        boolean[] used = new boolean[len];
        StringBuilder path = new StringBuilder();
        List<String> resultList = new ArrayList<>();
        dfs(chars, 0, used, path, resultList);
        return resultList.toArray(new String[resultList.size()]);
    }


    public void dfs(char[] chars, int depth, boolean[] used, StringBuilder path, List<String> resultList){
        if (depth == chars.length){
            resultList.add(new String(path));
            return;
        }


        for (int i = 0; i < chars.length; i++){
            if (used[i]){
                continue;
            }

            path.append(chars[i]);
            used[i] = true;
            dfs(chars, depth + 1, used, path, resultList);
            used[i] = false;
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        String s = "qwe";
        无重复字符串的排列组合 ss = new 无重复字符串的排列组合();
        System.out.println(Arrays.toString(ss.permutation(s)));
    }
}
