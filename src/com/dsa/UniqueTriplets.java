/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 */
package com.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueTriplets {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        System.out.println(findTriplets(arr));
    }

    public static List<List<Integer>> findTriplets(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(i > 0 && arr[i] == arr[i-1])
                continue;
            int l = i + 1, r = arr.length - 1;
            while(l < r) {
                int sum = arr[i] + arr[l] + arr[r];
                if(sum < 0) {
                    l++;
                } else if(sum > 0) {
                    r--;
                } else {
                    result.add(Arrays.asList(arr[i], arr[l], arr[r]));
                    l++;

                    while(l < r && arr[l] == arr[l - 1]) {
                        l++;
                    }
                }
            }
        }
        return result;
    }
}
