/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 * The testcases will be generated such that the answer is unique.
 */
package com.dsa;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println("Minimum window substring: - " + findMinWindowString(s, t));
    }

    public static String findMinWindowString(String s, String t) {
        if(s.length() < t.length())
            return "";
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0, right = 0, leftStart = -1, minWindow = Integer.MAX_VALUE, required = t.length();
        while(right < s.length()) {
            char ch = s.charAt(right);
            if(map.containsKey(ch)) {
                if(map.get(ch) > 0) {
                    required--;
                }
                map.put(ch, map.get(ch) - 1);
            }

            while(required == 0) {
                char leftChar = s.charAt(left);
                int currWindow = right - left + 1;
                if(currWindow < minWindow) {
                    minWindow = currWindow;
                    leftStart = left;
                }

                if(map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if(map.get(leftChar) > 0)
                        required++;
                }
                left++;
            }
            right++;
        }
        return minWindow == Integer.MAX_VALUE ? "" : s.substring(leftStart, leftStart + minWindow);
    }
}
