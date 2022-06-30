package org.example.practise;

import java.util.LinkedHashMap;
import java.util.Map;

public class 第一个只出现一次的字符 {

    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0){
            return ' ';
        }

        Map<Character, Integer> frequency = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++){
            if (frequency.get(s.charAt(i)) == 1){
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public static void main(String[] args) {

    }
}
