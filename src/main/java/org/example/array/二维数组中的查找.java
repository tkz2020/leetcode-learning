package org.example.array;

public class 二维数组中的查找 {

    /**
     * https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int i = 0, j = matrix[0].length - 1;
        int rows = matrix.length;
        while (i < rows && j >= 0){
            if (matrix[i][j] == target){
                return true;
            } else if (matrix[i][j] > target){
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 20;
        二维数组中的查找 ss = new 二维数组中的查找();
        System.out.println(ss.findNumberIn2DArray(matrix, target));
    }
}
