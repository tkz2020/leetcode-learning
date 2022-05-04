package org.example.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class 字符串中的变位词 {

    /**
     * 剑指 Offer II 014. 字符串中的变位词
     * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
     * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
     *
     * 示例 1：
     * 输入: s1 = "ab" s2 = "eidbaooo"
     * 输出: True
     * 解释: s2 包含 s1 的排列之一 ("ba").
     *
     * 示例 2：
     * 输入: s1= "ab" s2 = "eidboaoo"
     * 输出: False
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()){
            return false;
        }

        //获取s1中每个字符出现的次数
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < s1.length(); i++){
            need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
        }

        //定义窗口的类型window
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int valid = 0;
        int len = s2.length();
        while (right < len){
            char rightCharacter = s2.charAt(right);
            right++;

            if (need.containsKey(rightCharacter)){
                window.put(rightCharacter, window.getOrDefault(rightCharacter, 0) + 1);
                if (need.get(rightCharacter).equals(window.get(rightCharacter))){
                    valid++;
                }
            }

            while (right - left >= s1.length()){
                if (valid == need.size()){
                    return true;
                }

                char leftCharacter = s2.charAt(left);
                left++;
                if (need.containsKey(leftCharacter)){
                    if (need.get(leftCharacter).equals(window.get(leftCharacter))){
                        valid--;
                    }
                    window.put(leftCharacter, window.get(leftCharacter) - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        字符串中的变位词 ss = new 字符串中的变位词();
        System.out.println(ss.checkInclusion(s1, s2));
    }
}
