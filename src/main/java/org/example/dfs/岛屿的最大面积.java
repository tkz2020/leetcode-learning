package org.example.dfs;

public class 岛屿的最大面积 {

    /**
     * https://leetcode.cn/explore/featured/card/bytedance/243/array-and-sorting/1034/
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int row = grid.length;
        int column = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                if (grid[i][j] == 1){
                    int count = dfs(grid, row, column, i, j);
                    maxArea = Math.max(maxArea, count);
                }
            }
        }
        return maxArea;
    }


    public int dfs(int[][] grid, int row, int column, int i, int j){
        if (i < 0 || i >= row || j < 0 || j >= column || grid[i][j] != 1){
            return 0;
        }

        grid[i][j] = 0;
        return 1 + dfs(grid, row, column, i+1, j)
                 + dfs(grid, row, column, i-1, j)
                 + dfs(grid, row, column, i, j+1)
                 + dfs(grid, row, column, i, j-1);
    }

    public static void main(String[] args) {
        int[][] nums = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        岛屿的最大面积 ss = new 岛屿的最大面积();
        System.out.println(ss.maxAreaOfIsland(nums));
    }
}
