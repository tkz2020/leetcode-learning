package org.example.array;

import java.util.ArrayList;
import java.util.List;

public class 杨辉三角 {

    /**
     * https://leetcode.cn/problems/pascals-triangle/
     * @param rowIndex
     * @return
     */
    public List<Integer> generate(int rowIndex) {
        if (rowIndex == 0){
            return new ArrayList<>();
        }

        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++){
            List<Integer> recList = new ArrayList<>();
            for (int j = 0; j <= i; j++){
                if (j == 0 || i == j){
                    recList.add(1);
                } else {
                    recList.add(resultList.get(i-1).get(j-1)+resultList.get(i-1).get(j));
                }
            }
            resultList.add(recList);
        }
        return resultList.get(rowIndex);
    }

    public static void main(String[] args) {
        杨辉三角 s = new 杨辉三角();
        System.out.println(s.generate(0));
    }
}
