package org.example.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 有效的括号 {

    /**
     * 有效的括号
     * https://leetcode.cn/problems/valid-parentheses/
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0){
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        char[] chars = s.toCharArray();
        int point = 0, len = s.length();
        Stack<Character> stack = new Stack<>();
        while (point < len){
            char c = chars[point++];
            if (map.containsKey(c)){
                while (stack.isEmpty() || stack.peek() != map.get(c)){
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String s = "()";
        有效的括号 ss = new 有效的括号();
        ss.isValid(s);
    }
}
