package org.example.heap;

import java.util.*;

public class 前K个高频单词 {

    /**
     * 692. 前K个高频单词
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
        if ((words == null && words.length == 0) || k == 0){
            return new ArrayList<>();
        }

        Map<String, Integer> frequency = new HashMap<>();
        for (int i = 0; i < words.length; i++){
            frequency.put(words[i], frequency.getOrDefault(words[i], 0) + 1);
        }

        //如果不同的单词有相同的出现频率，按照字典顺序进行排序，否则，按照出现次数进行排序
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() == o2.getValue() ? o2.getKey().compareTo(o1.getKey()) : o1.getValue() - o2.getValue();
            }
        });


        for (Map.Entry<String, Integer> map : frequency.entrySet()){
            if (queue.size() > k){
                queue.poll();
            } else {
                queue.offer(map);
            }
        }

        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < k; i++){
            resultList.add(queue.poll().getKey());
        }
        Collections.reverse(resultList);
        return resultList;
    }

    public static void main(String[] args) {
        String[] result = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        前K个高频单词 ss = new 前K个高频单词();
        ss.topKFrequent(result, k);
    }
}
