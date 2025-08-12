/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 */
package com.dsa;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] arr = {1,1,1,3,3,4,3,2,4,2};
        System.out.println("Any number appearing exactly twice: - " + checkDuplicates(arr));
    }

    public static boolean checkDuplicates(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: arr) {
            if(map.containsKey(num))
                return true;
            map.put(num, num);
        }
        return false;
    }
}
