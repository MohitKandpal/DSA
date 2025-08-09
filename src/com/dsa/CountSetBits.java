/**
 * Given a positive integer n, write a function that returns the number of set bits in its binary representation (also known as the Hamming weight).
 */
package com.dsa;

public class CountSetBits {
    public static void main(String[] args) {
        int num = 10;
        int count = 0;
        while(num > 0) {
            count += (num & 1);
            num >>= 1;
        }
        System.out.println("Number of set bits: - " + count);
    }
}
