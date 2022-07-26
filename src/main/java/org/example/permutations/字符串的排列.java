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
        Arrays.fill(used, false);
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
    public void dfs(char[] chars, boolean[] used, StringBuilder path, ArrayList<String> resultList){
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


    public void recursion(ArrayList<String> res, char[] str, StringBuffer temp, boolean[] vis){
        //临时字符串满了加入输出
        if(temp.length() == str.length){
            res.add(new String(temp));
            return;
        }
        //遍历所有元素选取一个加入
        for(int i = 0; i < str.length; i++){
            //如果该元素已经被加入了则不需要再加入了
            if(vis[i])
                continue;
            if(i > 0 && str[i - 1] == str[i] && !vis[i - 1])
                //当前的元素str[i]与同一层的前一个元素str[i-1]相同且str[i-1]已经用过了
                continue;
            //标记为使用过
            vis[i] = true;
            //加入临时字符串
            temp.append(str[i]);
            recursion(res, str, temp, vis);
            //回溯
            vis[i] = false;
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public ArrayList<String> Permutation1(String str) {
        ArrayList<String> res = new ArrayList<String>();
        if(str == null || str.length() == 0)
            return res;
        //转字符数组
        char[] charStr = str.toCharArray();
        // 按字典序排序
        Arrays.sort(charStr);
        boolean[] vis = new boolean[str.length()];
        //标记每个位置的字符是否被使用过
        Arrays.fill(vis, false);
        StringBuffer temp = new StringBuffer();
        //递归获取
        recursion(res, charStr, temp, vis);
        return res;
    }


    public static void main(String[] args) {
        String s = "ab";
        字符串的排列 ss = new 字符串的排列();
        System.out.println(ss.Permutation(s));
    }
}
