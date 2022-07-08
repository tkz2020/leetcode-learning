package org.example.dynamic.programming;

public class 最小路径和 {

    /**
     * https://leetcode.cn/problems/minimum-path-sum/
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid[0] == null){
            return 0;
        }

        int rows = grid.length;
        int columns = grid[0].length;
        int[][] dp = new int[rows][columns];

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                if (i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                } else if (i == 0 && j != 0){
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                } else if (i != 0 && j == 0){
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                }
            }
        }
        return dp[rows-1][columns-1];
    }


    /**
     * https://leetcode.cn/problems/minimum-path-sum/
     * @param grid
     * @return
     */
    public int minPathSum1(int[][] grid) {
        if (grid == null || grid[0] == null){
            return 0;
        }

        int rows = grid.length;
        int columns = grid[0].length;

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                if (i == 0 && j == 0){
                    continue;
                } else if (i == 0 && j != 0){
                    grid[i][j] = grid[i][j-1] + grid[i][j];
                } else if (i != 0 && j == 0){
                    grid[i][j] = grid[i-1][j] + grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
                }
            }
        }
        return grid[rows-1][columns-1];
    }



    public static void main(String[] args) {

    }
}
