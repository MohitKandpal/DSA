/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */
package com.dsa;

public class WordBreak {
    public static void main(String[] args) {
        String str = "leetcode";
        String[] wordDict = {"leet","code"};
        System.out.println("Word break successful - " + wordBreakUtil(str, wordDict));
    }

    public static boolean wordBreakUtil(String str, String[] wordDict) {
        int n = str.length();
        boolean[] visited = new boolean[n + 1];
        visited[0] = true;
        for(int i = 1; i <= n; i++) {
            if(!visited[i] && wordPresentInDictionary(str.substring(0, i), wordDict)) {
                visited[i] = true;
            }

            if(visited[i] && i == n) {
                return true;
            }

            for(int j = i + 1; j <= n; j++) {
                if(!visited[j] && wordPresentInDictionary(str.substring(i, j), wordDict)) {
                    visited[j] = true;
                }
                if(j == n && visited[j])
                    return true;
            }
        }
        return false;
    }

    public static boolean wordPresentInDictionary(String word, String[] dict) {
        for(String dictWord: dict) {
            if(dictWord.equals(word))
                return true;
        }
        return false;
    }
}
