/**
 * Given an integer array nums, find a subarray that has the largest product, and return the product.
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 */
package com.dsa;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        double ans = arr[0], prefix = 1, suffix = 1;

        for(int i = 0; i < arr.length; i++) {
            prefix = (prefix == 0) ? 1 : prefix;
            suffix = (suffix == 0) ? 1 : suffix;

            prefix *= (double) arr[i];
            suffix *= (double) arr[arr.length - i - 1];

            ans = Math.max(ans, Math.max(prefix, suffix));
        }
        System.out.println("Maximum product for subarray: - " + (int)ans);
    }
}
