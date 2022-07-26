package org.example.hash;

import java.util.*;

public class 字符串出现次数的TopK问题 {


    /**
     * https://www.nowcoder.com/practice/fd711bdfa0e840b381d7e1b82183b3ee?tpId=196&tqId=37142&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D2%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196&difficulty=undefined&judgeStatus=undefined&tags=&title=
     * NC97 字符串出现次数的TopK问题
     * @param strings
     * @param k
     * @return
     */
    public String[][] topKstrings (String[] strings, int k) {
        if (strings == null || strings.length == 0){
            return new String[][]{};
        }

        TreeMap<String, Integer> map = new TreeMap<>();
        for (String string : strings){
            map.put(string, map.getOrDefault(string, 0) + 1);
        }

        ArrayList<Map.Entry<String, Integer>> resultList = new ArrayList<>(map.entrySet());
        Collections.sort(resultList, ((o1, o2) -> {
            return o1.getValue().compareTo(o2.getValue()) == 0 ? o1.getKey().compareTo(o2.getKey()) : o2.getValue().compareTo(o1.getValue());
        }));

        String[][] result = new String[k][2];
        for (int i = 0; i < k; i++){
            result[i][0] = resultList.get(i).getKey();
            result[i][1] = String.valueOf(resultList.get(i).getValue());
        }
        return result;
    }


    /**
     * 通过小根堆实现
     * @param strings
     * @param k
     * @return
     */
    public String[][] topKstrings1 (String[] strings, int k) {
        if (strings == null || strings.length == 0){
            return new String[][]{};
        }

        TreeMap<String, Integer> map = new TreeMap<>();
        for (String string : strings){
            map.put(string, map.getOrDefault(string, 0) + 1);
        }

        Comparator comparator = new CustomComparator();
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(k, comparator);

        for (Map.Entry<String, Integer> entry : map.entrySet()){
            if (queue.size() < k){
                queue.offer(entry);
            } else {
                if (comparator.compare(queue.peek(), entry) < 0){
                    queue.poll();
                    queue.offer(entry);
                }
            }
        }

        String[][] result = new String[k][2];
        for (int i = k-1; i >= 0; i--){
            Map.Entry<String, Integer> entry = queue.poll();
            result[i][0] = entry.getKey();
            result[i][1] = String.valueOf(entry.getValue());
        }
        return result;
    }


    public static void main(String[] args) {
        String[] strings = new String[]{"1","1","2","3"};
        int k = 2;
        字符串出现次数的TopK问题 ss = new 字符串出现次数的TopK问题();
        String[][] result = ss.topKstrings1(strings, k);
        for (int i = 0; i < result.length; i++){
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
