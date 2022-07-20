package org.example.array;

import java.util.*;

public class 螺旋矩阵 {

        /**
         * https://leetcode.cn/problems/spiral-matrix/
         * 螺旋矩阵
         * @param matrix
         * @return
         */
        public List<Integer> spiralOrder(int[][] matrix) {
                if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
                        return new ArrayList<>();
                }

                int rows = matrix.length;
                int columns = matrix[0].length;
                int left = 0, right = columns - 1;
                int top = 0, bottom = rows - 1;
                List<Integer> resList = new ArrayList<>();
                while (left <= right && top <= bottom){

                        for (int i = left; i <= right; i++){
                                resList.add(matrix[top][i]);
                        }

                        for (int j = top + 1; j <= bottom; j++){
                                resList.add(matrix[j][right]);
                        }

                        if (left < right && top < bottom){
                                for (int i = right - 1; i > left; i--){
                                        resList.add(matrix[bottom][i]);
                                }

                                for (int j = bottom; j > top; j--){
                                        resList.add(matrix[j][left]);
                                }
                        }
                        left++;
                        right--;
                        top++;
                        bottom--;
                }
                return resList;
        }

        public static void main(String[] args) {
                int[][] matrix = {
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}};
                螺旋矩阵 ss = new 螺旋矩阵();
                System.out.println(ss.spiralOrder(matrix));
        }
}
