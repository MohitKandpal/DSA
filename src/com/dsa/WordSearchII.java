/**
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 */
package com.dsa;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    public static void main(String[] args) {
        String[] words = {"oath","pea","eat","rain"};
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        System.out.println("Words found in board: - " + findWordsInBoard(board, words));
    }

    public static List<String> findWordsInBoard(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> res = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    private static void dfs(char[][] board, int i, int j, TrieNode root, List<String> result) {
        char ch = board[i][j];
        if(ch == '#' || root.childs[ch - 'a'] == null)
            return;
        root = root.childs[ch - 'a'];
        if(!root.word.isEmpty()) {
            result.add(root.word);
            root.word = "";
        }
        board[i][j] = '#';
        if(i > 0) dfs(board, i - 1, j, root, result);
        if(j > 0) dfs(board, i, j - 1, root, result);
        if(i < board.length - 1) dfs(board, i + 1, j, root,result);
        if(j < board[0].length - 1) dfs(board, i, j + 1, root, result);
        board[i][j] = ch;
    }

    private static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word: words) {
            TrieNode temp = root;
            for(char ch: word.toCharArray()) {
                if(temp.childs[ch - 'a'] == null) {
                    temp.childs[ch - 'a'] = new TrieNode();
                }
                temp = temp.childs[ch - 'a'];
            }
            temp.word = word;
        }
        return root;
    }
}

class TrieNode {
    String word;
    TrieNode[] childs;
    
    public TrieNode() {
        this.word = "";
        this.childs = new TrieNode[26];
        for(int i = 0; i < 26; i++) {
            this.childs[i] = null;
        }
    }
}
