package org.example.sliding.window;

import java.util.ArrayList;
import java.util.List;

public class 找到字符串中所有字母异位词 {

    /**
     * 438. 找到字符串中所有字母异位词
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()){
            return new ArrayList<>();
        }

        int[] hash = new int[26];
        for (int i = 0; i < p.length(); i++){
            hash[s.charAt(i) - 'a']++;
        }

        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        int valid = 0;
        for (right = 0; right < s.length(); right++){
            hash[s.charAt(right) - 'a']--;

            if (hash[s.charAt(right) - 'a'] >= 0){
                valid++;
            }

            if (right > p.length() - 1){
                hash[s.charAt(left) - 'a']++;
                if (hash[s.charAt(left) - 'a'] > 0){
                    valid--;
                }
                left++;
            }

            if (valid == p.length()){
                result.add(left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        找到字符串中所有字母异位词 ss = new 找到字符串中所有字母异位词();
        ss.findAnagrams(s, p);
    }
}





















