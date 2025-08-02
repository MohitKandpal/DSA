/**
 * Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 */
package com.dsa;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {3, 0, 1};
        int xor1 = 0, n = 3;
        for(int i = 1; i <= n; i++) {
            xor1 ^= i;
        }

        int xor2 = 0;
        for(int num: arr) {
            xor2 ^= num;
        }
        System.out.println("Missing Number - " + (xor1^xor2)); ;
    }
}
