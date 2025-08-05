/**
 * Given an array of intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 * Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.
 */
package com.dsa;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,2}, {2,3}, {3,4}, {1,3}};
        Arrays.sort(intervals, (i1, i2)-> i1[1] - i2[1]);

        int removedIntervalCount = 0;
        int[] compInterval = intervals[0];
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < compInterval[1]) {
                removedIntervalCount++;
            } else {
                compInterval = intervals[i];
            }
        }
        System.out.println("Number of intervals to be removed: - " + removedIntervalCount);
    }
}
