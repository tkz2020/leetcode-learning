package org.example.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class 长度为三且各字符不同的子字符串 {

    /**
     * 1876. 长度为三且各字符不同的子字符串
     * @param s
     * @return
     */
//    public int countGoodSubstrings(String s) {
//        if (s == null || s.length() == 0){
//            return 0;
//        }
//
//        int left = 0;
//        int right = 0;
//        int len = s.length();
//        int result = 0;
//        Map<Character, Integer> window = new HashMap<>();
//        while (right < len){
//            char rightCharacter = s.charAt(right);
//            right++;
//            //统计窗口内每个字符出现的个数
//            window.put(rightCharacter, window.getOrDefault(rightCharacter, 0) + 1);
//            //一个窗口的大小为3
//            while (right - left == 3){
//                Long characterCount = window.entrySet().stream().filter(e -> e.getValue() == 1).count();
//                if (characterCount == 3){
//                    result++;
//                }
//                char leftCharacter = s.charAt(left);
//                left++;
//                window.put(leftCharacter, window.get(leftCharacter) - 1);
//            }
//        }
//        return result;
//    }


    public static void main(String[] args) {

    }
}
