package org.example.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class 滑动窗口的最大值 {


    /**
     * NC82 滑动窗口的最大值
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        if (num == null || num.length == 0 || size == 0){
            return new ArrayList<>();
        }

        //维护一个大根堆，堆顶的元素最大，堆里面存一个数组，第0位表示数组的下标，第1位表示数组的值
        PriorityQueue<int[]> queue = new PriorityQueue<>(size, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        ArrayList<Integer> resultList = new ArrayList<>();
        int left = 0;  //滑动窗口的左边界
        for (int i = 0; i < num.length; i++){
            queue.add(new int[]{i, num[i]});
            if (i >= size - 1){
                //若此时，堆顶元素不在窗口呢，弹出堆顶元素
                while (queue.size() > 0 && queue.peek()[0] < left){
                    queue.poll();
                }
                resultList.add(queue.peek()[1]);
                left++;
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,4,2,6,2,5,1};
        滑动窗口的最大值 ss = new 滑动窗口的最大值();
        int size = 3;
        System.out.println(ss.maxInWindows(nums, size));
    }
}
