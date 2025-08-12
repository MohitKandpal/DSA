/**
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 * Implement the WordDictionary class:
 * WordDictionary() Initializes the object.
 * void addWord(word) Adds word to the data structure, it can be matched later.
 * bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 */
package com.dsa;

public class WordDS {
    boolean isEndOfWord = false;
    WordDS[] childs = null;

    WordDS() {
        this.isEndOfWord = false;
        this.childs = new WordDS[26];
        for(int i = 0; i < 26; i++) {
            this.childs[i] = null;
        }
    }

    public void addWord(String word) {
        WordDS temp = this;
        if(temp == null)
            return;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(temp.childs[ch - 'a'] == null) {
                temp.childs[ch - 'a'] = new WordDS();
            }
            temp = temp.childs[ch - 'a'];
        }
        temp.isEndOfWord = true;
    }

    public boolean search(String word) {
        WordDS temp = this;
        if(temp == null)
            return false;
        return searchUtil(word, temp);
    }

    private boolean searchUtil(String word, WordDS temp) {
        if(temp == null)
            return false;
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == '.') {
                for(int j = 0; j < 26; j++) {
                    if(temp.childs[j] == null)
                        continue;
                    if(searchUtil(word.substring(i + 1), temp.childs[j]))
                        return true;
                }
                return false;
            } else {
                if(temp.childs[word.charAt(i) - 'a'] == null)
                    return false;
                temp = temp.childs[word.charAt(i) - 'a'];
            }
        }
        return temp.isEndOfWord;
    }
}
