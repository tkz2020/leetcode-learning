package org.example.permutations;

public class 单词搜索 {

    /**
     * https://leetcode.cn/problems/word-search/
     * 深度优先遍历+回溯
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0){
            return false;
        }

        int rows = board.length, columns = board[0].length;
        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k){
        if (board[i][j] != s.charAt(k)){
            return false;
        } else if (k == s.length() - 1){
            return true;
        }

        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions){
            int newI = i + dir[0], newJ = j + dir[1];
            if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length){
                if (!visited[newI][newJ]){
                    boolean flag = check(board, visited, newI, newJ, s, k+1);
                    if (flag){
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        单词搜索 ss = new 单词搜索();
        ss.exist(board, word);
    }
}
