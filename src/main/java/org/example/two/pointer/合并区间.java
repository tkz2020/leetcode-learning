package org.example.two.pointer;

import java.lang.reflect.Array;
import java.util.*;

public class 合并区间 {


    /**
     * 合并区间   牛客网
     * @param intervals
     * @return
     */
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        if (intervals.size() == 1){
            return intervals;
        }

        //按照开始时间进行排序
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        ArrayList<Interval> resultList = new ArrayList<>();
        int index = -1;
        for (Interval interval : intervals){
            if (index == -1 || interval.start > resultList.get(index).end){
                // 区间 [a,b]  [c,d]   c 大于 b的话
                //不合并
                resultList.add(interval);
                index++;
            } else {
                //如果 c 大于 b 那么就需要找一个最大的作为 右边的边界 因为数据start都从左到右排好序了
                resultList.get(index).end = Math.max(interval.end, resultList.get(index).end);
            }
        }
        return resultList;
    }

    /**
     * https://leetcode.cn/problems/merge-intervals/
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length == 0 || intervals[0].length == 0){
            return intervals;
        }

        if (intervals.length == 1){
            return intervals;
        }

        // 针对区间的第一个元素进行排序
        Arrays.sort(intervals, (int[] o1, int[] o2) -> o1[0] - o2[0]);

        List<int[]> resultList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++){
            //获取第 i 个区间的左右边界值
            int left = intervals[i][0], right = intervals[i][1];
            // 如果当前 resultList 没有元素 或者 resultList 的最后一个元素的右边界小于 第 i 个元素的左边界，则添加到 resultList 里面去
            if (resultList.size() == 0 || resultList.get(resultList.size() - 1)[1] < left){
                resultList.add(new int[]{left, right});
            } else {
                // 取一个右边界的最大值
                resultList.get(resultList.size() - 1)[1] = Math.max(resultList.get(resultList.size() - 1)[1], right);
            }
        }
        return resultList.toArray(new int[resultList.size()][]);
    }


    public static void main(String[] args) {

    }
}
