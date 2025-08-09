/**
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 * The test cases are generated so that the answer will be less than or equal to 2 * 109.
 */
package com.dsa;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println(uniquePathsUtil(m, n));
    }

    private static int uniquePathsUtil(int m, int n) {
        int[][] table = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                table[i][j] = -1;
            }
        }
        return findUniqPaths(0, 0, m, n, table);
    }

    private static int findUniqPaths(int x, int y, int m, int n, int[][] table) {
        if(x > m - 1 || y > n - 1)
            return 0;
        if(table[x][y] != -1)
            return table[x][y];
        if(x == m - 1 || y == n - 1)
            return 1;
        return table[x][y] = findUniqPaths(x + 1, y, m, n, table) + findUniqPaths(x, y + 1, m, n, table);
    }
}
