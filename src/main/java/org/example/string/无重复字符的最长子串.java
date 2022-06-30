package org.example.string;

import java.util.HashSet;
import java.util.Set;

public class 无重复字符的最长子串 {


    public int lengthOfLongestSubstring(String s){
        if (s == null || s.length() == 0){
            return 0;
        }

        int left = 0, right = 0;
        int len = s.length();
        Set<Character> set = new HashSet<>();
        int max = 0;
        while (right < len){
            if (set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            } else {
                set.add(s.charAt(right));
                right++;
            }
            max = Math.max(max, s.substring(left, right).length());
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
