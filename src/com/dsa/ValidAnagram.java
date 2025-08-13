/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 */
package com.dsa;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        String str1 = "rat", str2 = "car";
        System.out.println("Valid Anagrams: - " + isValidAnagram(str1, str2));
    }

    private static boolean isValidAnagram(String str1, String str2) {
        char[] ch1 = str1.toCharArray(), ch2 = str2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        for(int i = 0; i < ch1.length; i++) {
            if(ch1[i] != ch2[i])
                return false;
        }
        return true;
    }
}
