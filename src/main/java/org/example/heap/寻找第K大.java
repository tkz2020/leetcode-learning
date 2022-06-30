package org.example.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class 寻找第K大 {

    public int findKth(int[] a, int n, int K) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int i = 0; i < n; i++){
            queue.offer(a[i]);
            if (queue.size() > K){
                queue.remove();
            }
        }

        return queue.peek();
    }


    /**
     * 寻找第K大
     * @param a
     * @param n
     * @param K
     * @return
     */
    public int findKth1(int[] a, int n, int K){

        //维护一个结点个数为K的小根堆，堆顶元素是最小值，也就是小根堆。
        PriorityQueue<Integer> queue = new PriorityQueue<>(K, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        //遍历每一个元素，调整小根堆
        for (int num : a){
            //对于小根堆来说，只要没满就可以加入（不需要比较）；如果满了，才判断是否需要替换第一个元素
            if (queue.size() < K){
                queue.add(num);
            } else {
                //在小根堆内，存储着K个较大的元素，根是这K个中最小的，如果出现比根还要大的元素，说明可以替换根
                if (num > queue.peek()){
                    queue.poll();  //调整堆顶元素
                    queue.add(num);  //把新元素放入到堆中，重新调整堆的顺序
                }
            }
        }
        return queue.isEmpty() ? 0 : queue.peek();
    }


    /**
     * 寻找第K大
     * @param a
     * @param n
     * @param K
     * @return
     */
    public int findKth2(int[] a, int n, int K) {
        quickSort(a, 0, a.length - 1);
        return a[n-K];
    }

    public void quickSort(int[] nums, int start, int end){
        if (nums == null || nums.length == 0){
            return;
        }

        int pivot = nums[start];
        int left = start;
        int right = end;
        while (left < right){
            while (left < right && nums[right] >= pivot){
                right--;
            }

            if (nums[right] < pivot){
                swap(nums, left, right);
            }

            while (left < right && nums[left] <= pivot){
                left++;
            }

            if (nums[left] > pivot){
                swap(nums, left, right);
            }
        }

        if (start < left){
            quickSort(nums, start, left-1);
        }

        if (right < end){
            quickSort(nums, right+1, end);
        }
    }


    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{10,10,9,9,8,7,5,6,4,3,4,2};
        int n = 12;
        int k = 3;
        寻找第K大 ss = new 寻找第K大();
        System.out.println(ss.findKth2(nums, n, k));
    }
}
