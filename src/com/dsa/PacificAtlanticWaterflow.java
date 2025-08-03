/**
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 */
package com.dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterflow {
    public static void main(String[] args) {
        int[][] heights = {{1,2,2,3,5}, {3,2,3,4,4}, {2,4,5,3,1}, {6,7,1,4,5}, {5,1,1,2,4}};
        List<List<Integer>> result = pacificAtlanticUtil(heights);
        System.out.println(result);
    }

    public static List<List<Integer>> pacificAtlanticUtil(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        Queue<int[]> pacQueue = new LinkedList<>();
        Queue<int[]> atlanQueue = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            pacific[i][0] = true;
            atlantic[i][n - 1] = true;
            pacQueue.add(new int[]{i, 0});
            atlanQueue.add(new int[]{i, n - 1});
        }

        for(int j = 0; j < m; j++) {
            pacific[0][j] = true;
            atlantic[m - 1][j] = true;
            pacQueue.add(new int[]{0, j});
            atlanQueue.add(new int[]{m - 1, j});
        }

        bfs(heights, pacQueue, pacific);
        bfs(heights, atlanQueue, atlantic);

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(atlantic[i][j] && pacific[i][j]) {
                    List<Integer> arr = new ArrayList<>();
                    arr.add(i);
                    arr.add(j);
                    result.add(arr);
                }
            }
        }
        return result;
    }

    private static void bfs(int[][] heights, Queue<int[]> queue, boolean[][] visited) {
        int[] rowNbr = {-1, 0, 0, 1}, colNbr = {0, -1, 1, 0};
        while(!queue.isEmpty()) {
            int[] coordinates = queue.poll();
            for(int i = 0; i < 4; i++) {
                int rowCoor = rowNbr[i] + coordinates[0];
                int colCoor = colNbr[i] + coordinates[1];
                if(rowCoor < 0 || rowCoor >= heights.length ||
                   colCoor < 0 || colCoor >= heights[0].length ||
                   visited[rowCoor][colCoor] || heights[rowCoor][colCoor] < heights[coordinates[0]][coordinates[1]])
                    continue;
                visited[rowCoor][colCoor] = true;
                queue.add(new int[] {rowCoor, colCoor});
            }
        }
    }
}
