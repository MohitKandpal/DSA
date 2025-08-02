/**
 * Given a string s, find the length of the longest substring without duplicate characters.
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
package com.dsa;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println("Length of the longest substring without duplicate characters: - " + LongestSubstringWithoutRepeatingCharacters.findLength(str));
    }

    public static int findLength(String str) {
        if(str.isEmpty())
            return 0;
        if(str.length() == 1)
            return 1;
        int l = 0, r = 0, ans = Integer.MIN_VALUE;
        boolean[] visited = new boolean[256];
        while(r < str.length()) {
            if(visited[str.charAt(r)]) {
                while(visited[str.charAt(r)]) {
                    visited[str.charAt(l)] = false;
                    l++;
                }
            }
            visited[str.charAt(r)] = true;
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
