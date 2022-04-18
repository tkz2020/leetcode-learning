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

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        字符串的排列 ss = new 字符串的排列();
        System.out.println(ss.checkInclusion(s1, s2));
    }
}
