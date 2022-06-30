package org.example.heap;

import java.util.PriorityQueue;

public class 最小K个数 {


    /**
     * 面试题 17.14. 最小K个数
     * @param arr
     * @param k
     * @return
     */
    public int[] smallestK(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0){
            return new int[]{};
        }

        //维护一个大根堆，每次比较当前元素和堆顶的元素，要是比堆顶元素小，就弹出堆顶的元素，放入当前元素。
        PriorityQueue<Integer> queue = new PriorityQueue<>((Integer o1, Integer o2) -> o2 - o1);

        for (int i = 0; i < arr.length; i++){
            if (queue.size() < k){
                queue.add(arr[i]);
            } else {
                if (arr[i] < queue.peek()){
                    queue.poll();
                    queue.add(arr[i]);
                }
            }
        }

        int[] result = new int[queue.size()];
        int index = 0;
        while (!queue.isEmpty()){
            result[index++] = queue.poll();
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
