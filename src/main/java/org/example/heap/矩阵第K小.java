package org.example.heap;

import java.util.*;

public class 矩阵第K小 {


    /**
     * NC357 矩阵第K小
     * @param matrix
     * @param k
     * @return
     */
    public int KthinMatrix (ArrayList<ArrayList<Integer>> matrix, int k) {
        if (matrix == null || matrix.size() == 0){
            return -1;
        }

        //合并矩阵，然后排序
        ArrayList<Integer> dataList = new ArrayList<>();
        for (ArrayList<Integer> list : matrix){
            dataList.addAll(list);
        }
        Collections.sort(dataList);

        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (Integer data : dataList){
            if (queue.size() < k){
                queue.add(data);
            } else {
                if (data < queue.peek()){
                    queue.poll();
                    queue.add(data);
                }
            }
        }
        return queue.size() == 0 ? -1 : queue.peek();
    }

    public static void main(String[] args) {

    }
}
