/**
 * Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.
 * Please implement encode and decode
 */
package com.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeStrings {
    public static void main(String[] args) {
        String[] words = {"leet","code","love","you"};
        String encodedStr = encode(Arrays.asList(words));
        System.out.println("Encoded String: - " + encodedStr);
        System.out.println("Decoded String: - " + decode(encodedStr));
    }

    private static String encode(List<String> words) {
        if(words.isEmpty())
            return "";
        StringBuilder res = new StringBuilder();
        for(String word: words) {
            res.append(word.length()).append("#").append(word);
        }
        return res.toString();
    }

    private static List<String> decode(String str) {
        List<String> words = new ArrayList<>();
        int i = 0;
        while(i < str.length()) {
            int j = i;
            while(str.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + len;
            words.add(str.substring(i, j));
            i = j;
        }
        return words;
    }
}
