/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
package com.dsa;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        Arrays.sort(arr);
        int l = 0, r = arr.length - 1;
        while(l < r) {
            if(arr[l] + arr[r] == target) {
                System.out.println("Required indexes: - (" + l + ", " + r + ")");
                break;
            }
            if(arr[l] + arr[r] < target) {
                l++;
            } else {
                r--;
            }
        }
    }
}
