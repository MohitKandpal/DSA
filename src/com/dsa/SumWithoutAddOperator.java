/**
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 */
package com.dsa;

public class SumWithoutAddOperator {
    public static void main(String[] args) {
        int a = 3, b = 5;
        System.out.println(String.format("Sum of %s and %s is: - ", a, b) + sum(a, b));
    }

    private static int sum(int a, int b) {
        while(b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
