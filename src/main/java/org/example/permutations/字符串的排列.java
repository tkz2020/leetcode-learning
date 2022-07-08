package org.example.permutations;

import java.util.*;

public class 字符串的排列 {

    public ArrayList<String> Permutation (String str) {
        if (str == null || str.length() == 0){
            return new ArrayList<>();
        }

        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        boolean[] used = new boolean[str.length()];
        StringBuilder path = new StringBuilder();
        ArrayList<String> resultList = new ArrayList<>();
        dfs(chars, used, path, resultList);
        return resultList;
    }


    /**
     * dfs
     * @param chars
     * @param used
     * @param path
     */
    public void dfs(char[] chars, boolean[] used, StringBuilder path, List<String> resultList){
        if (chars.length == path.length()){
            resultList.add(new String(path));
            return;
        }

        for (int i = 0; i < chars.length; i++){
            if (used[i]){
                continue;
            }

            if (i > 0 && chars[i-1] == chars[i] && !used[i-1]){
                continue;
            }

            used[i] = true;
            path.append(chars[i]);
            dfs(chars, used, path, resultList);
            used[i] = false;
            path.deleteCharAt(path.length() - 1);
        }
    }


    public static void main(String[] args) {
        String s = "qwertyuio";
        字符串的排列 ss = new 字符串的排列();
        System.out.println(ss.Permutation(s));
    }
}
