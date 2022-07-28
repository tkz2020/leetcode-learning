package org.example.sliding.window;

import java.util.*;

public class 滑动窗口最大值 {

    /**
     * 求滑动窗口的最大值
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0){
            return new int[]{};
        }

        //建立一个大根堆，int[0]表示当前元素在数组中的下标，int[1]表示当前数组中的元素
        PriorityQueue<int[]> queue = new PriorityQueue<>((int[] o1, int[] o2) -> o2[1] - o1[1]);

        List<Integer> resultList = new ArrayList<>();
        int left = 0, right = 0, len = nums.length;
        while (right < len){
            queue.offer(new int[]{right, nums[right]});
            if (right >= k-1){
                resultList.add(queue.peek()[1]);
                while (queue.peek()[0] < left){
                    queue.poll();
                }
                queue.offer(new int[]{right, nums[right]});
                left++;
            }
            right++;
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++){
            result[i] = resultList.get(i);
        }
        return result;
    }



    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0){
            return new int[]{};
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((int[] o1, int[] o2) -> o2[1] - o1[1]);

        List<Integer> recList = new ArrayList<>();
        for (int i = 0; i < k; i++){
            queue.offer(new int[]{i, nums[i]});
        }

        recList.add(queue.peek()[1]);
        for (int i = k; i < nums.length; i++){
            queue.offer(new int[]{i, nums[i]});
            while (queue.peek()[0] <= i-k){
                queue.poll();
            }
            recList.add(queue.peek()[1]);
        }

        int[] result = new int[recList.size()];
        for (int i = 0; i < recList.size(); i++){
            result[i] = recList.get(i);
        }
        return result;
    }

    /**
     * https://www.nowcoder.com/practice/1624bc35a45c42c0bc17d17fa0cba788?tpId=196&tqId=37118&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%25E6%25BB%2591%25E5%258A%25A8%25E7%25AA%2597%25E5%258F%25A3%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196&difficulty=undefined&judgeStatus=undefined&tags=&title=%E6%BB%91%E5%8A%A8%E7%AA%97%E5%8F%A3
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
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        滑动窗口最大值 ss = new 滑动窗口最大值();
        System.out.println(Arrays.toString(ss.maxSlidingWindow1(nums, k)));
    }
}
