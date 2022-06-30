package org.example.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 根据字符出现频率排序 {

    /**
     * https://leetcode.cn/problems/sort-characters-by-frequency/
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        if (s == null || s.length() == 0){
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        //维护一个大顶堆
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });


        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            queue.add(entry);
        }

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()){
            Map.Entry<Character, Integer> rec = queue.poll();
            int frequency = rec.getValue();
            while (frequency-- > 0){
                result.append(rec.getKey());
            }
        }
        return result.toString();
    }


    public static void main(String[] args) {
        String s = "tree";
        根据字符出现频率排序 ss = new 根据字符出现频率排序();
        ss.frequencySort(s);
    }
}
