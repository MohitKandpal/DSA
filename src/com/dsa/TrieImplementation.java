/**
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 * Implement the Trie class:
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 */
package com.dsa;

import java.util.Arrays;

public class TrieImplementation {
    public static void main(String[] args) {
    }
}

class Trie {
    boolean isEndOfWord;
    Trie[] childs = null;

    Trie() {
        this.isEndOfWord = false;
        this.childs = new Trie[26];
        Arrays.fill(this.childs, null);
    }

    public void insert(String word) {
        Trie temp = this;
        if(temp == null)
            return;

        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(temp.childs[ch - 'a'] == null) {
                temp.childs[ch - 'a'] = new Trie();
            }
            temp = temp.childs[ch - 'a'];
        }
        temp.isEndOfWord = true;
    }

    public boolean search(String word) {
        Trie temp = this;
        if(temp == null)
            return false;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(temp.childs[ch - 'a'] == null)
                return false;
            temp = temp.childs[ch - 'a'];
        }
        return temp.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        Trie temp = this;
        if(temp == null)
            return false;
        int i;
        for(i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(temp.childs[ch - 'a'] == null)
                return false;
            temp = temp.childs[ch - 'a'];
        }
        return i == prefix.length();
    }
}
