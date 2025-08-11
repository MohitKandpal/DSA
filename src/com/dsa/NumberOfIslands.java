/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */
package com.dsa;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
        System.out.println("Number of islands: - " + findNumberOfIslands(grid));
    }

    public static int findNumberOfIslands(char[][] grid) {
        int count = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid, boolean[][] visited, int x, int y) {
        int[] rowNbr = {-1, 0, 0, 1}, colNbr = {0, -1, 1, 0};
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int row = x + rowNbr[i], col = y + colNbr[i];
            if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length &&
            !visited[row][col] && grid[row][col] == '1') {
                dfs(grid, visited, row, col);
            }
        }
    }
}