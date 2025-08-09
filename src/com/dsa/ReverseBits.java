/**
 * Reverse bits of a given 32 bits unsigned integer.
 * Note:
 * Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation.
 */
package com.dsa;

public class ReverseBits {
    public static void main(String[] args) {
        int num = 43261596;
        System.out.println("Reversed: - " + reverseBits(num));
    }

    public static int reverseBits(int num) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            ans <<= 1;
            ans |= (num & 1);
            num >>= 1;
        }
        return ans;
    }
}
