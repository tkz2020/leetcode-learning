package org.example.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class 表达式求值 {

    Map<Character, Integer> map = new HashMap<Character, Integer>(){{
        put('-', 1);
        put('+', 1);
        put('*', 2);
    }};


    public int solve(String s){
        s = s.replaceAll(" ", "");
        char[] chars = s.toCharArray();
        int length = s.length();

        Deque<Integer> nums = new ArrayDeque<>();
        nums.addLast(0);
        Deque<Character> operates = new ArrayDeque<>();

        for (int i = 0; i < length; i++){
            char c = chars[i];
            if (c == '('){
                operates.addLast(c);
            } else if (c == ')'){

                while (!operates.isEmpty()){
                    if (operates.peekLast() != '('){
                        calculate(nums, operates);
                    } else {
                        operates.pollLast();
                        break;
                    }
                }
            } else {
                if (Character.isDigit(c)){
                    int u = 0;
                    int j = i;
                    while (j < length && Character.isDigit(chars[j])){
                        u = u * 10 + (chars[j++] - '0');
                    }
                    nums.addLast(u);
                    i = j - 1;
                } else {
                    if (i > 0 && (chars[i-1] == '(' || chars[i-1] == '+' || chars[i-1] == '-')){
                        nums.addLast(0);
                    }

                    while (!operates.isEmpty() && operates.peekLast() != '('){
                        char prev = operates.peekLast();
                        if (map.get(prev) >= map.get(c)){
                            calculate(nums, operates);
                        } else {
                            break;
                        }
                    }
                    operates.addLast(c);
                }
            }
        }

        while (!operates.isEmpty() && operates.peekLast() != '('){
            calculate(nums, operates);
        }
        return nums.peekLast();
    }

    /**
     * 计算结果
     * @param result
     * @param operates
     */
    public void calculate(Deque<Integer> result, Deque<Character> operates){
        if (result.isEmpty() || result.size() < 2){
            return;
        }

        if (operates.isEmpty()){
            return;
        }

        int b = result.pollLast();
        int a = result.pollLast();
        char op = operates.pollLast();
        int ans = 0;
        if (op == '+'){
            ans = a + b;
        } else if (op == '-'){
            ans = a - b;
        } else if (op == '*'){
            ans = a * b;
        }
        result.addLast(ans);
    }

    public static void main(String[] args) {
//        String s = "1+2";
        String s = "3+2*3*4-1";
        表达式求值 ss = new 表达式求值();
        System.out.println(ss.solve(s));
    }
}
