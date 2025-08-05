/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 */
package com.dsa;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        int target = 7;
        List<List<Integer>> result = new ArrayList<>();
        combinationSumUtil(result, new ArrayList<Integer>(), arr, target, 0);
        System.out.println(result);
    }

    public static void combinationSumUtil(List<List<Integer>> answer,
           List<Integer> tempList, int[] candidates, int remain, int start) {
        if(remain < 0)
            return;
        if(remain == 0) {
            answer.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            tempList.add(candidates[i]);
            combinationSumUtil(answer, tempList, candidates, remain - candidates[i], i);
            tempList.remove(tempList.size() - 1);
        }
    }
}
