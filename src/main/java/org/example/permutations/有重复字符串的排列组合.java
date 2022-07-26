package org.example.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 有重复字符串的排列组合 {

    /**
     * https://leetcode.cn/problems/permutation-ii-lcci/
     * @param S
     * @return
     */
    public String[] permutation(String S) {
        if (S == null && S.length() == 0){
            return new String[]{};
        }

        char[] chars = S.toCharArray();
        Arrays.sort(chars);
        int len = S.length();
        boolean[] used = new boolean[len];
        StringBuilder path = new StringBuilder();
        List<String> resultList = new ArrayList<>();
        dfs(chars, 0, used, path, resultList);
        return resultList.toArray(new String[resultList.size()]);
    }


    public void dfs(char[] chars, int depth, boolean[] used, StringBuilder path, List<String> resultList){
        if (chars.length == depth){
            resultList.add(new String(path));
            return;
        }

        for (int i = 0; i < chars.length; i++){
            if (used[i]){
                continue;
            }

            if (i > 0 && chars[i] == chars[i-1] && used[i-1]){
                continue;
            }

            used[i] = true;
            path.append(chars[i]);
            dfs(chars, depth+1, used, path, resultList);
            used[i] = false;
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        String s = "qqe";
        有重复字符串的排列组合 ss = new 有重复字符串的排列组合();
        System.out.println(Arrays.toString(ss.permutation(s)));
    }
}
