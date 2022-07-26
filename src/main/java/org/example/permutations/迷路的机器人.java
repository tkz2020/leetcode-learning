package org.example.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 迷路的机器人 {

    /**
     * https://leetcode.cn/problems/robot-in-a-grid-lcci/
     * @param obstacleGrid
     * @return
     */
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid[0].length == 0){
            return new ArrayList<>();
        }

        int rows = obstacleGrid.length, columns = obstacleGrid[0].length;
        List<List<Integer>> resultList = new LinkedList<>();
        boolean[][] visited = new boolean[rows][columns];
        dfs(obstacleGrid, rows, columns, 0, 0, visited, resultList);
        return resultList;
    }


    public boolean dfs(int[][] obstacleGrid, int rows, int columns, int x, int y, boolean[][] visited, List<List<Integer>> resultList){
        if (x >= rows || y >= columns || visited[x][y] || obstacleGrid[x][y] == 1){
            return false;
        }

        resultList.add(Arrays.asList(x, y));
        visited[x][y] = true;
        if (x == rows - 1 && y == columns - 1){
            return true;
        }

        //向下走
        if (dfs(obstacleGrid, rows, columns, x + 1, y, visited, resultList)){
            return  true;
        }
        //向右走
        if (dfs(obstacleGrid, rows, columns, x, y + 1, visited, resultList)){
            return true;
        }
        //回溯
        resultList.remove(resultList.size() - 1);
        return false;
    }


    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };

        迷路的机器人 ss = new 迷路的机器人();
        System.out.println(ss.pathWithObstacles(graph));
    }
}
