package org.example.string;

import java.util.Stack;

public class 颠倒字符串中的单词 {

    /**
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0){
            return "";
        }

        Stack<String> stack = new Stack<>();
        String[] strings = s.trim().split(" ");
        for (String ss : strings){
            if (!"".equals(ss)){
                stack.push(ss);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()){
            if (result.length() > 0){
                result.append(" ");
            }
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "a good   example";
        颠倒字符串中的单词 ss = new 颠倒字符串中的单词();
        System.out.println(ss.reverseWords(s));
    }
}
