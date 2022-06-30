package org.example.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class 字符串的排列 {

    /**
     * 567. 字符串的排列
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()){
            return false;
        }

        //统计s1中每个字符出现的次数
        Map<Character, Integer> s1Count = count(s1);

        int left = 0;
        int right = s1.length() - 1;
        int len = s2.length();
        while (right < len){
            Map<Character, Integer> s2Count = count(s2.substring(left, right + 1));
            if (s1Count.equals(s2Count)){
                return true;
            }
            right++;
            left++;
        }
        return false;
    }


    private Map<Character, Integer> count(String s){
        if (s == null || s.length() == 0){
            return new HashMap<>();
        }

        Map<Character, Integer> sCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (sCount.containsKey(ch)){
                sCount.put(ch, sCount.get(ch)+1);
            } else {
                sCount.put(ch, 1);
            }
        }
        return sCount;
    }


    /**
     * 方法二
     * @param s1
     * @param s2
     * @return
     */
//    public boolean checkInclusion2(String s1, String s2) {
//        Map<Character, Integer> need = count(s1);
//        Map<Character, Integer> window = new HashMap<>();
//
//        int left = 0;
//        int right = 0;
//        int valid = 0;
//        while (right < s2.length()){
//            char c = s2.charAt(right);
//            right++;
//
//            if (need.containsKey(c)){
//                window.put(c, window.getOrDefault(c, 0) + 1);
//                if (window.get(c) == need.get(c)){
//                    valid++;
//                }
//            }
//
//            while (right - left >= s1.length()){
//                if (valid == s1.length()){
//                    return true;
//                }
//                Character d = s2.charAt(left);
//                left++;
//
//                if (need.containsKey(d)){
//                    if (window.get(d) == need.get(d)){
//                        valid--;
//                    }
//                    window.put(d, window.getOrDefault(d, 0) - 1);
//                }
//            }
//        }
//        return false;
//    }
//
//
//    public static void main(String[] args) {
//        String s1 = "ab";
//        String s2 = "eidbaooo";
//        字符串的排列 ss = new 字符串的排列();
//        System.out.println(ss.checkInclusion2(s1, s2));
//    }
}
