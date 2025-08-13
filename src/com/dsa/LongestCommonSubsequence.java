/**
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 */
package com.dsa;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String str1 = "abcde", str2 = "ace";
        System.out.println("Length of LCS: - " + findLCS(str1, str2));
    }

    private static int findLCS(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] table = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == 0 || j == 0) {
                    table[i][j] = 0;
                } else {
                    if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                        table[i][j] = 1 + table[i - 1][j - 1];
                    } else {
                        table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                    }
                }
            }
        }
        return table[m][n];
    }
}
