package org.example.二分查找;

public class 搜索二维矩阵II {


    /**
     * https://leetcode.cn/problems/search-a-2d-matrix-ii/
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int rows = matrix.length, columns = matrix[0].length;
        int i = 0, j = columns - 1;
        while (i < rows && j >= 0){
            if (matrix[i][j] == target){
                return true;
            } else if (matrix[i][j] < target){
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
