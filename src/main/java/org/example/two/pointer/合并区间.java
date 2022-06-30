package org.example.two.pointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 合并区间 {


    /**
     * 合并区间
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


    public static void main(String[] args) {

    }
}
