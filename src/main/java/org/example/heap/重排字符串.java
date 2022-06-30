package org.example.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 重排字符串 {

    /**
     * NC379 重排字符串
     * @param str
     * @return
     */
    public String rearrangestring (String str) {
        if (str == null || str.length() == 0){
            return "";
        }


        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return 0;
            }
        });

        return "";
    }


    public static void main(String[] args) {

    }
}
