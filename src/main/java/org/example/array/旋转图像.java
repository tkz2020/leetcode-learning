package org.example.array;

public class 旋转图像 {

    /**
     * https://leetcode.cn/problems/rotate-image/
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix[0].length == 0){
            return;
        }

        int rows = matrix.length, columns = matrix[0].length;
        int[][] matrix_new = new int[rows][columns];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                matrix_new[j][rows-i-1] = matrix[i][j];
            }
        }

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                matrix[i][j] = matrix_new[i][j];
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        旋转图像 ss = new 旋转图像();
        ss.rotate(matrix);
    }
}
