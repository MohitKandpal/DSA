/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 */
package com.dsa;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        int n = arr.length;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) {
                    lis[i] = Math.max(lis[i], 1 + lis[j]);
                }
            }
        }

        int ans = 1;
        for(int len : lis) {
            ans = Math.max(ans, len);
        }
        System.out.println("Length of LIS: - " + ans);
    }
}
