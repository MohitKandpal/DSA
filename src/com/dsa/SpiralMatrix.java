/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 */
package com.dsa;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(printInSpiralForm(mat));
    }

    public static List<Integer> printInSpiralForm(int[][] mat) {
        List<Integer> result = new ArrayList<>();
        int m = mat.length, n = mat[0].length, k = 0, l = 0;
        while(k < m && l < n) {
            for(int i = l; i < n; i++) {
                result.add(mat[k][i]);
            }
            k++;

            for(int i = k ; i < m; i++) {
                result.add(mat[i][n - 1]);
            }
            n--;

            if(k < m) {
                for(int i = n - 1; i >= l; i--) {
                    result.add(mat[m - 1][i]);
                }
            }
            m--;

            if(l < n) {
                for(int i = m - 1; i >= k; i--) {
                    result.add(mat[i][l]);
                }
            }
            l++;
        }
        return result;
    }
}
