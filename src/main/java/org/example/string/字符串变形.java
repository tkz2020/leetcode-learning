package org.example.string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class 字符串变形 {

    /**
     * BM83 字符串变形
     * @param s
     * @param n
     * @return
     */
    public String trans(String s, int n) {
        if ((s == null && s.length() == 0) || n == 0){
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                sb.append((char) (s.charAt(i) + 32));
            } else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                sb.append((char) (s.charAt(i) - 32));
            } else {
                sb.append(s.charAt(i));
            }
        }

        //栈->先进后出
        Deque<String> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            int tmp = i;
            while (tmp < n && sb.charAt(tmp) != ' '){
                tmp++;
            }
            deque.addFirst(sb.substring(i, tmp));
            i = tmp;
        }

        StringBuilder result = new StringBuilder();
        //这块需要注意，得判断字符串最后一位是空格的情况
        if (s.charAt(n - 1) == ' '){
            result.append(" ");
        }
        while (!deque.isEmpty()){
            String tmp = deque.pop();
            result.append(tmp);
            //这块if判断需要用栈是否为空的条件去判断
            if (!deque.isEmpty()){
                result.append(" ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "This is a sample";
        int n = 16;
        字符串变形 ss = new 字符串变形();
        ss.trans(s, n);
    }
}
