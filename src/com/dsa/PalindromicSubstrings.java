/**
 * Given a string s, return the number of palindromic substrings in it.
 * A string is a palindrome when it reads the same backward as forward.
 * A substring is a contiguous sequence of characters within the string.
 */
package com.dsa;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        String str = "abc";
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            int even = count(str, i, i + 1);
            int odd = count(str, i - 1, i + 1);
            count += even + odd + 1;
        }
        System.out.println("Number of palindromic substrings - " + count);
    }

    private static int count(String str, int l, int r) {
        int count = 0;
        while(l >= 0 && r < str.length() && str.charAt(l) == str.charAt(r)) {
            count++;
            l--;
            r++;
        }
        return count;
    }
}
