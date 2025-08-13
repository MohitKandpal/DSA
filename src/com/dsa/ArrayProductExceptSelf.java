/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 */
package com.dsa;

import java.util.Arrays;

public class ArrayProductExceptSelf {
    public static void main(String[] args) {
        int[] arr = {2,3,5,7,10};
        System.out.println("Product of array except self: - " + Arrays.toString(findProductExceptSelf(arr)));
    }

    private static int[] findProductExceptSelf(int[] arr) {
        int[] product = new int[arr.length];
        Arrays.fill(product, 1);

        int temp = 1;
        for(int i = 0; i < arr.length; i++) {
            product[i] = temp;
            temp *= arr[i];
        }

        temp = 1;
        for(int i = arr.length - 1; i >= 0; i--) {
            product[i] *= temp;
            temp *= arr[i];
        }
        return product;
    }
}
