/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 */
package com.dsa;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] arr = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = groupAnagrams(arr);
        System.out.println(result);
    }

    public static List<List<String>> groupAnagrams(String[] arr) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String word: arr) {
            String hashCode = generateHash(word);
            List<String> list;
            if(map.containsKey(hashCode)) {
                list = map.get(hashCode);
                list.add(word);
            } else {
                list = new ArrayList<>();
                list.add(word);
            }
            map.put(hashCode, list);
        }

        Iterator<String> itr = map.keySet().iterator();
        while(itr.hasNext()) {
            String key = itr.next();
            List<String> list = map.get(key);
            result.add(list);
        }
        return result;
    }

    public static String generateHash(String str) {
        String hash = "";
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            hash += arr[i];
        }
        return hash;
    }
}
