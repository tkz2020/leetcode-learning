package org.example.dfs;

public class 岛屿数量 {

    /**
     * BM57 岛屿数量
     * @param grid
     * @return
     */
    public int solve (char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int row = grid.length;
        int column = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                if (grid[i][j] == '1'){
                    dfs(grid, row, column, i, j);
                    count++;
                }
            }
        }
        return count;
    }


    public void dfs(char[][] grid, int row, int column, int i, int j){
        if (i < 0 || i >= row || j < 0 || j >= column || grid[i][j] != '1'){
            return;
        }

        grid[i][j] = '2';
        dfs(grid, row, column, i-1, j);
        dfs(grid, row, column, i+1, j);
        dfs(grid, row, column, i, j-1);
        dfs(grid, row, column, i, j+1);
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'0','1','0','1','1'},
                {'0','0','0','1','1'},
                {'0','0','0','0','0'},
                {'0','0','1','1','1'}};
        岛屿数量 ss = new 岛屿数量();
        ss.solve(grid);
    }
}
