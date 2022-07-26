package org.example.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 数组中的第k大的数字 {

    /**
     * 剑指 Offer II 076. 数组中的第 k 大的数字
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return -1;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(k);

        for (int i = 0; i < nums.length; i++){
            if (queue.size() < k){
                queue.offer(nums[i]);
            } else {
                if (nums[i] > queue.peek()){
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
        }
        return queue.size() == 0 ? -1 : queue.peek();
    }

    public static void main(String[] args) {

    }
}
