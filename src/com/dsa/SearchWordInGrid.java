/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 */
package com.dsa;

public class SearchWordInGrid {
    static boolean[][] visited;
    public static void main(String[] args) {
        char[][] grid = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println("Word found: - " + exists(grid, word, grid.length, grid[0].length));
    }

    public static boolean exists(char[][] grid, String word, int m, int n) {
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == word.charAt(0) && existUtil(grid, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private static boolean existUtil(char[][] grid, String word, int i, int j, int ind) {
        if(ind == word.length())
            return true;
        if(i < 0 || i > grid.length || j < 0 || j > grid[0].length || visited[i][j] || grid[i][j] != word.charAt(ind))
            return false;
        visited[i][j] = true;
        if(existUtil(grid, word, i - 1, j, ind + 1) ||
           existUtil(grid, word, i, j - 1, ind + 1) ||
           existUtil(grid, word, i, j + 1, ind + 1) ||
           existUtil(grid, word, i + 1, j, ind + 1))
            return true;
        visited[i][j] = false;
        return false;
    }
}
