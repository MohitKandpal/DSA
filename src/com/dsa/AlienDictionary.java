/**
 * Given an array of strings words[], sorted in an alien language. Your task is to determine the correct order of letters in this alien language based on the given words. If the order is valid, return a string containing the unique letters in lexicographically increasing order as per the new language's rules.
 */
package com.dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
    public static void main(String[] args) {
        String[] words = {"baa", "abcd", "abca", "cab", "cad"};
        System.out.println("Order as per Alien Dictionary: - " + findOrder(words));
    }

    private static String findOrder(String[] words) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] exists = new boolean[26];
        int[] indegree = new int[26];

        for(int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }

        for(String word: words) {
            char[] charArr = word.toCharArray();
            for(char ch: charArr)
                exists[ch - 'a'] = true;
        }

        for(int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int len = Math.min(word1.length(), word2.length()), j = 0;
            while(j < len && word1.charAt(j) == word2.charAt(j))
                j++;
            if(j < len) {
                int u = word1.charAt(j) - 'a';
                int v = word2.charAt(j) - 'a';
                adj.get(u).add(v);
                indegree[v]++;
            } else if(word1.length() > word2.length()) {
                return "";
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0 && exists[i]) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int u = queue.remove();
            char ch = (char)(u + 'a');
            res.append(ch);
            for(int v: adj.get(u)) {
                indegree[v]--;
                if(indegree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        for(int i = 0; i < 26; i++) {
            if(exists[i] && indegree[i] != 0) {
                return "";
            }
        }
        return res.toString();
    }
}
