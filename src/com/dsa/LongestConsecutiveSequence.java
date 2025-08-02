/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
package com.dsa;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {0,3,7,2,5,8,4,6,0,1};
        Set<Integer> nums = new HashSet<Integer>();
        for(int num: arr) {
            nums.add(num);
        }

        int maxLen = 1, len = 1;
        for(int num: nums) {
            if(nums.contains(num - 1))
                continue;
            int next = num + 1;
            if(nums.contains(next)) {
                while(nums.contains(next)) {
                    next++;
                    len++;
                }
                maxLen = Math.max(maxLen,len);
            } else {
                len = 1;
            }
        }
        System.out.println("Length of Longest Consecutive Sequence- " + maxLen);
    }
}
