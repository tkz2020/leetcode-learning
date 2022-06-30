package org.example.sliding.window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 字符串中的所有变位词 {

    /**
     * 剑指 Offer II 015. 字符串中的所有变位词
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的 变位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     * 变位词 指字母相同，但排列不同的字符串。
     * @param s
     * @param p
     * @return
     */
//    public List<Integer> findAnagrams(String s, String p) {
//        if (s.length() < p.length()){
//            return new ArrayList<>();
//        }
//
//        Map<Character, Integer> need = new HashMap<>();
//        for (int i = 0; i < p.length(); i++){
//            need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
//        }
//
//        Map<Character, Integer> window = new HashMap<>();
//        int left = 0;
//        int right = 0;
//        int valid = 0;
//        int len = s.length();
//        List<Integer> result = new ArrayList<>();
//        while (right < len){
//            //rightCharacter是将移入窗口的字符
//            char rightCharacter = s.charAt(right);
//            //右移窗口
//            right++;
//
//            //更新窗口内的值
//            if (need.containsKey(rightCharacter)){
//                window.put(rightCharacter, window.getOrDefault(rightCharacter, 0) + 1);
//                //包装类型，用equals判断是否相等
//                if (need.get(rightCharacter).equals(window.get(rightCharacter))){
//                    valid++;
//                }
//            }
//
//            //判断左侧窗口是否需要收缩
//            while (right - left >= p.length()){
//                if (valid == need.size()){
//                    result.add(left);
//                }
//                //leftCharacter是将移出窗口的字符
//                char leftCharacter = s.charAt(left);
//                //左移窗口
//                left++;
//
//                if (need.containsKey(leftCharacter)){
//                    if (need.get(leftCharacter).equals(window.get(leftCharacter))){
//                        valid--;
//                    }
//                    window.put(leftCharacter, window.get(leftCharacter) - 1);
//                }
//            }
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//        String s = "cbaebabacd";
//        String p = "abccca";
//        字符串中的所有变位词 ss = new 字符串中的所有变位词();
//        System.out.println(ss.findAnagrams(s, p));
//    }
}
