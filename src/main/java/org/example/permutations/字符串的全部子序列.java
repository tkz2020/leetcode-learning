package org.example.permutations;

import java.util.*;

public class 字符串的全部子序列 {

    /**
     * https://www.nowcoder.com/practice/92e6247998294f2c933906fdedbc6e6a?tpId=196&tqId=39357&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D4%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196&difficulty=undefined&judgeStatus=undefined&tags=&title=
     * NC190 字符串的全部子序列
     * 输入：
     * "ab"
     * 返回值：
     * ["","a","ab","b"]
     * 说明：
     * 返回["","b","a","ab"]也是可以的，视为正确，顺序不唯一
     *
     * 输入：
     * "dbcq"
     * 返回值：
     * ["","b","bc","bcq","bq","c","cq","d","db","dbc","dbcq","dbq","dc","dcq","dq","q"]
     *
     * 输入：
     * "aab"
     * 返回值：
     * ["","a","aa","aab","ab","b"]
     * 说明：
     * 返回的字符串数组里面不能存在"ab","ab"这样2个相同的子序列
     * @param s
     * @return
     */
    public String[] generatePermutation (String s) {
        if (s == null || s.length() == 0){
            return new String[]{""};
        }

        char[] chars = s.toCharArray();
        StringBuilder path = new StringBuilder();
        Set<String> resultSet = new HashSet<>();
        dfs(chars, 0, path, resultSet);
        return resultSet.toArray(new String[resultSet.size()]);
    }


    public void dfs(char[] chars, int startIndex, StringBuilder path, Set<String> resultSet){
        resultSet.add(new String(path));
        if (startIndex == chars.length){
            return;
        }

        for (int i = startIndex; i < chars.length; i++){
            path.append(chars[i]);
            dfs(chars, i+1, path, resultSet);
            path.deleteCharAt(path.length() - 1);
        }
    }


    public static void main(String[] args) {
        String s = "aba";
        字符串的全部子序列 ss = new 字符串的全部子序列();
        System.out.println(Arrays.toString(ss.generatePermutation(s)));
    }
}
