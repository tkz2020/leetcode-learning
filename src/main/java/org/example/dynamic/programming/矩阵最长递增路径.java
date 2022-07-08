package org.example.dynamic.programming;

public class 矩阵最长递增路径 {

    /**
     * BM61 矩阵最长递增路径
     * @param matrix
     * @return
     */
    public int solve (int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        return 0;
    }


    public static void main(String[] args) {

    }
}
