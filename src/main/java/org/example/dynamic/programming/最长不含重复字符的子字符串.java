package org.example.dynamic.programming;

import java.util.HashSet;
import java.util.Set;

public class 最长不含重复字符的子字符串 {


    /**
     * https://www.nowcoder.com/practice/48d2ff79b8564c40a50fa79f9d5fa9c7?tpId=265&tqId=39289&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D13%26type%3D265&difficulty=3&judgeStatus=undefined&tags=&title=
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring (String s) {
        if (s == null || s.length() == 0){
            return 0;
        }

        int maxLength = 0;
        int len = s.length();
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();
        while (right < len){
            char c = s.charAt(right);
            if (set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            } else {
                set.add(s.charAt(right));
                right++;
            }
            maxLength = Math.max(maxLength, set.size());
        }
        return maxLength;
    }


    public static void main(String[] args) {

    }
}
