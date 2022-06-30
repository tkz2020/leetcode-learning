package org.example.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 多数组第K小数 {

    /**
     * NC251 多数组第 K 小数
     * @param arr1
     * @param arr2
     * @param target
     * @return
     */
    public int findKthNum (int[] arr1, int[] arr2, int target) {
        if (arr1 == null && arr2 == null){
            return -1;
        }

        int[] sorted = merge(arr1, arr2);
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < sorted.length; i++){
            if (queue.size() < target){
                queue.add(sorted[i]);
            } else {
                if (sorted[i] < queue.peek()){
                    queue.poll();
                    queue.add(sorted[i]);
                }
            }
        }

        return queue.isEmpty() ? 0 : queue.peek();
    }


    public int[] merge(int[] arr1, int[] arr2){
        int len1 = arr1.length, len2 = arr2.length;
        int[] sorted = new int[len1+len2];
        int i = 0, j = 0;
        int index = 0;
        while (i < len1){
            sorted[index++] = arr1[i];
            i++;
        }

        while (j < len2){
            sorted[index++] = arr2[j];
            j++;
        }

        Arrays.sort(sorted);
        return sorted;
    }


    public static void main(String[] args) {
        int[] arr1 = new int[]{0,2,4,6,7,8,9,9,10,12,17,18};
        int[] arr2 = new int[]{0,4,6,8,12,13,22,30,30,31,42,43,45};
        int n = 19;
        多数组第K小数 ss = new 多数组第K小数();
        System.out.println(ss.findKthNum(arr1, arr2, n));
    }
}
