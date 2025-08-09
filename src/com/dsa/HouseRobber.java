/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */
package com.dsa;

public class HouseRobber {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println("Maximum amount that can be robbed: - " + findMaxAmount(arr));
    }

    private static int findMaxAmount(int[] arr) {
        if(arr.length == 0)
            return 0;
        if(arr.length == 1)
            return arr[0];

        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for(int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }
        return dp[arr.length - 1];
    }
}
