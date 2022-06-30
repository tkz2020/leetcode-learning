package org.example.permutations;

import java.util.*;

public class 字符串的排列 {

    public ArrayList<String> Permutation (String str) {
        if (str == null || str.length() == 0){
            return new ArrayList<>();
        }

        char[] chars = str.toCharArray();
        int len = str.length();
        boolean[] used = new boolean[len];
        StringBuilder path = new StringBuilder();
        ArrayList<String> resultList = new ArrayList<>();
        dfs(chars, len, used, path, resultList);
        return resultList;
    }


    /**
     *
     * @param chars
     * @param len
     * @param used
     * @param path
     */
    public void dfs(char[] chars, int len, boolean[] used, StringBuilder path,
                    List<String> resultList){
        if (len == chars.length){
            resultList.add(path.toString());
            return;
        }

        for (int i = 0; i < len; i++){
            if (used[i]){
                continue;
            }

            if (i > 0 && chars[i-1] == chars[i] && !used[i-1]){
                continue;
            }

            path.append(chars[i]);
            used[i] = true;
            dfs(chars, len, used, path, resultList);
            used[i] = false;
            path.deleteCharAt(path.length() - 1);
        }
    }


    public static void main(String[] args) {
        String s = "ab";
        字符串的排列 ss = new 字符串的排列();
        System.out.println(ss.Permutation(s));
    }
}
