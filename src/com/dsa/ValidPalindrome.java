/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */
package com.dsa;

public class ValidPalindrome {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println("Valid Palindrome: - " + validPalindrome(str));
    }

    private static boolean validPalindrome(String str) {
        if(str.length() == 0)
            return true;
        str = str.trim();
        str = str.toLowerCase();
        int l = 0, r = str.length() - 1;
        while(l < r) {
            if(!Character.isLetter(str.charAt(l)) && !Character.isDigit(str.charAt(l))) {
                l++;
                continue;
            }
            if(!Character.isLetter(str.charAt(r)) && !Character.isDigit(str.charAt(r))) {
                r--;
                continue;
            }
            if(str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
