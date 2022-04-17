package org.example.sliding.window;

import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;

public class 无重复字符的最长子串 {

    /**
     * 无重复字符的最长子串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        Set<Character> result = new HashSet<>();
        while (right < s.length()){
            if (result.add(s.charAt(right))){
                right++;
            } else {
                left++;
                result.remove(s.charAt(left-1));
            }
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        无重复字符的最长子串 ss = new 无重复字符的最长子串();
        System.out.println(ss.lengthOfLongestSubstring(s));
    }
}
