package org.example.dynamic.programming;

public class 礼物的最大价值 {

    /**
     * 剑指 Offer 47. 礼物的最大价值
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        //双端队列

        int[][] dp = new int[grid.length][grid[0].length];
        int rows = grid.length;
        int columns = grid[0].length;

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                if (i == 0 && j == 0){
                    dp[i][j] = grid[i][i];
                } else if (i == 0 && j != 0){
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                } else if (i != 0 && j == 0){
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                }
            }
        }
        return dp[rows-1][columns-1];
    }


    /**
     *
     * @param grid
     * @return
     */
    public int maxValue1(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                if (i == 0 && j == 0){
                    continue;
                }

                if (i == 0){
                    grid[i][j] = grid[i][j-1] + grid[i][j];
                } else if (j == 0){
                    grid[i][j] = grid[i-1][j] + grid[i][j];
                } else {
                    grid[i][j] = Math.max(grid[i-1][j], grid[i][j-1]) + grid[i][j];
                }
            }
        }
        return grid[rows-1][columns-1];
    }


    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };

        礼物的最大价值 ss = new 礼物的最大价值();
        System.out.println(ss.maxValue(grid));
    }
}
