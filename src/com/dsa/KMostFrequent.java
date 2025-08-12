/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 */
package com.dsa;

import java.util.*;

public class KMostFrequent {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(k + " most frequent elements are: - " + Arrays.toString(kMostFrequent(arr, k)));
    }

    private static int[] kMostFrequent(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num: arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (e1, e2)-> e2.getValue() - e1.getValue());
        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = list.get(i).getKey();
        }
        return ans;
    }
}
