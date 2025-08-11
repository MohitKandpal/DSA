package com.dsa;

import java.util.Arrays;

public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] mat = {{1,1,1}, {1,0,1}, {1,1,1}};
        setMatrixZero(mat);
        System.out.println("Converted Matrix is: - ");
        for (int[] ints : mat) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    public static void setMatrixZero(int[][] mat) {
        boolean firstColZero = false, firstRowZero = false;
        for(int i = 0; i < mat.length; i++) {
            if(mat[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        for(int j = 0; j < mat[0].length; j++) {
            if(mat[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        for(int i = 1; i < mat.length; i++) {
            for(int j = 1; j < mat[0].length; j++) {
                if(mat[i][j] == 0) {
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < mat.length; i++) {
            for(int j = 1; j < mat[0].length; j++) {
                if(mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }

        if(firstRowZero) {
            Arrays.fill(mat[0], 0);
        }

        if(firstColZero) {
            for(int i = 0; i < mat.length; i++) {
                mat[i][0] = 0;
            }
        }
    }
}
