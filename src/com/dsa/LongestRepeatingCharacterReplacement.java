/**
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 */
package com.dsa;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String str = "ABAB";
        int n = str.length(), k = 2, ans = 0;
        for(char c = 'A'; c <= 'Z'; c++) {
            int i = 0, j = 0, replaced = 0;
            while(j < n) {
                if(str.charAt(j) == c) {
                    j++;
                } else if(replaced < k) {
                    j++;
                    replaced++;
                } else if(str.charAt(i) == c) {
                    i++;
                } else {
                    i++;
                    replaced--;
                }
                ans = Math.max(ans, j - i);
            }
        }
        System.out.println("Answer: - " + ans);
    }
}
