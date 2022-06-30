package org.example.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 合并N个有序数组，每个有序数组的长度为K
 */
public class 数组合并_小根堆实现 {

    static class Node implements Comparable<Node>{
        private int value;
        private int index;
        private int next;

        public Node(int value, int index, int next) {
            this.value = value;
            this.index = index;
            this.next = next;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    /**
     * 堆实现数组排序
     * @param nums
     * @return
     */
    public int[] mergeArray(int[][] nums){
        if (nums.length == 0){
            return new int[]{};
        }

        if (nums.length == 1){
            return nums[0];
        }

        int N = nums.length;
        int K = nums[0].length;
        int length = N*K;    //合并之后的数组长度
        int[] result = new int[N*K];

        //定义一个长度为N的小顶堆
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++){
            queue.offer(new Node(nums[i][0], i, 0));
        }

        int index = 0;
        while (index < length){
            Node tmp = queue.poll();
            if (tmp != null){
                result[index++] = tmp.value;
                if (tmp.next + 1 < K){
                    queue.offer(new Node(nums[tmp.index][tmp.next+1], tmp.index, tmp.next+1));
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 5, 11, 23}, {3, 6, 8, 20}, {2, 4, 7, 15}, {9, 10, 19, 28}};
        数组合并_小根堆实现 ss = new 数组合并_小根堆实现();
        System.out.println(Arrays.toString(ss.mergeArray(nums)));
    }
}
