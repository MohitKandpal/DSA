/**
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 */
package com.dsa;

public class JumpGame {
    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        int maxReachableInd = 0;
        for(int i = 0; i < arr.length; i++) {
            if(i > maxReachableInd) {
                System.out.println("Cannot reach end of array");
                return;
            }
            maxReachableInd = Math.max(maxReachableInd, i + arr[i]);
        }
        System.out.println("End can be reached");
    }
}
