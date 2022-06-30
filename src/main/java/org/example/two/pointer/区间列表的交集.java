package org.example.two.pointer;

import java.util.ArrayList;
import java.util.List;

public class 区间列表的交集 {

    /**
     * 986. 区间列表的交集
     * @param firstList
     * @param secondList
     * @return
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<int[]> resultList = new ArrayList<>();
        int i = 0, len1 = firstList.length;
        int j = 0, len2 = secondList.length;
        while (i < len1 && j < len2){
            int maxLeft = Math.max(firstList[i][0], secondList[j][0]);
            int minRight = Math.min(firstList[i][1], secondList[j][1]);
            if (maxLeft <= minRight){
                resultList.add(new int[]{maxLeft, minRight});
            }

            if (firstList[i][1] < secondList[j][1]){
                i++;
            } else {
                j++;
            }
        }

        return resultList.toArray(new int[resultList.size()][]);
    }


    public static void main(String[] args) {

    }
}
