/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */
package com.dsa;

public class HouseRobberII {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println("Maximum money that can be stolen without alerting police: - " + houseRobberII(nums));
    }

    public static int houseRobberII(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);
        return Math.max(houseRobberIIUtil(nums, 0, nums.length - 2), houseRobberIIUtil(nums, 1, nums.length - 1));
    }

    private static int houseRobberIIUtil(int[] nums, int start, int end) {
        if(start == end)
            return nums[start];
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for(int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[end];
    }
}
