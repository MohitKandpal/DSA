package com.dsa;

import java.util.Arrays;

public class CountingBits {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Answer - " + Arrays.toString(findOneBits(n)));
    }

    public static int[] findOneBits(int n) {
        int[] ans = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            if(i > 0 && i % 2 == 0) {
                ans[i] = 1;
            } else {
                ans[i] = countBits(i);
            }
        }
        return ans;
    }

    private static int countBits(int num) {
        int count = 0;
        while(num > 0) {
            count += (num & 1);
            num >>= 1;
        }
        return count;
    }
}
