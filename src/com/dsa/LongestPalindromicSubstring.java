/**
 * Given a string s, return the longest palindromic substring in s.
 */
package com.dsa;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String str = "cbbd";
        int n = str.length(), maxLen = 1, start = 0, i = 0, j = 0, k = 0;
        boolean[][] table = new boolean[n][n];
        for(i = 0; i < n; i++) {
            table[i][i] = true;
        }
        for(i = 0; i < n - 1; i++) {
            if(str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                maxLen = 2;
                start = i;
            }
        }


        for(k = 3; k <= n; k++) {
            for(i = 0; i < n - k + 1; i++) {
                j = i + k - 1;
                if(str.charAt(i) == str.charAt(j) && table[i + 1][j - 1]) {
                    table[i][j] = true;
                    if(k > maxLen) {
                        maxLen = k;
                        start = i;
                    }
                }
            }
        }
        System.out.println("Longest Palindromic substring: - " + str.substring(start, start + maxLen));
    }
}
