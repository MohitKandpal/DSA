/**
 *There is an integer array nums sorted in ascending order (with distinct values).
 *Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 *You must write an algorithm with O(log n) runtime complexity.
 */
package com.dsa;

public class SearchInRotatedSorted {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println("Index is - " + searchInRotatedSorted(arr, 0, 0, arr.length - 1));
    }

    public static int searchInRotatedSorted(int[] arr, int target, int l, int r) {
        if(l > r)
            return -1;
        int m = l + ((r - l) / 2);
        if(arr[m] == target)
            return m;

        if(arr[l] <= arr[m]) {
            if(arr[l] <= target && target < arr[m]) {
                return searchInRotatedSorted(arr, target, l, m - 1);
            }
            return searchInRotatedSorted(arr, target, m + 1, r);
        }

        if(arr[m] <= target && target <= arr[r]) {
            return searchInRotatedSorted(arr, target, m + 1, r);
        }
        return searchInRotatedSorted(arr, target, l, m - 1);
    }
}
