package org.example.array;

import java.util.Arrays;

public class 螺旋矩阵II {

    public int[][] generateMatrix(int n) {
        if (n == 0){
            return new int[n][n];
        }

        int[][] result = new int[n][n];
        int left = 0, right = n-1;
        int top = 0, bottom = n-1;
        int index = 1;
        while (left <= right && top <= bottom){
            for (int i = left; i <= right; i++){
                result[top][i] = index++;
            }

            for (int j = top + 1; j <= bottom; j++){
                result[j][right] = index++;
            }

            if (left < right && top < bottom){
                for (int i = right-1;i > left; i--){
                    result[bottom][i] = index++;
                }

                for (int j = bottom; j > top; j--){
                    result[j][left] = index++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 3;
        螺旋矩阵II ss = new 螺旋矩阵II();
        int[][] result = ss.generateMatrix(n);
        for (int i = 0; i < result.length; i++){
            System.out.println(Arrays.toString(result[i]));
        }

    }
}
