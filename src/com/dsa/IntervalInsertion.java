/**
 * You are given an array of non-overlapping intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * Return intervals after the insertion.
 * Note that you don't need to modify intervals in-place. You can make a new array and return it.
 */
package com.dsa;

import java.util.ArrayList;
import java.util.Arrays;

public class IntervalInsertion {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3,5}, {6,7}, {8,10}, {12,16}};
        int[] newInterval = {4,8};
        int[][] output = insertIntervalInSortedIntervals(intervals, newInterval);
        System.out.println("Output : - ");
        for (int[] ints : output) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] insertIntervalInSortedIntervals(int[][] intervals, int[] interval) {
        if(interval.length == 0)
            return intervals;
        if(intervals.length == 0) {
            int[][] output = new int[1][2];
            output[0] = interval;
            return output;
        }

        if(interval[1] < intervals[0][0]) {
            int[][] output = new int[intervals.length + 1][2];
            int k = 0;
            output[k++] = interval;
            for (int[] ints : intervals) {
                output[k++] = ints;
            }
            return output;
        }

        if(interval[0] > intervals[intervals.length - 1][1]) {
            int[][] output = new int[intervals.length + 1][2];
            int k = 0;
            for (int[] ints : intervals) {
                output[k++] = ints;
            }
            output[k] = interval;
            return output;
        }

        if(interval[0] <= intervals[0][0] && interval[1] >= intervals[intervals.length - 1][1]) {
            int[][] output = new int[1][2];
            output[0] = interval;
            return output;
        }

        boolean isOverlap = false;
        ArrayList<int[]> result = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++) {
            isOverlap = isOverlapping(intervals[i], interval);
            if(!isOverlap) {
                result.add(intervals[i]);
                if(i < intervals.length - 1 && interval[0] > intervals[i][1] && interval[1] < intervals[i + 1][0]) {
                    result.add(interval);
                }
                continue;
            }

            int[] tempInterval = new int[2];
            tempInterval[0] = Math.min(intervals[i][0], interval[0]);
            while(i < intervals.length && isOverlap) {
                tempInterval[1] = Math.max(intervals[i][1], interval[1]);
                if(i == intervals.length - 1) {
                    isOverlap = false;
                } else {
                    isOverlap = isOverlapping(intervals[i + 1], interval);
                }
                i++;
            }
            i--;
            result.add(tempInterval);
        }

        int[][] output = new int[result.size()][2];
        int k = 0;
        for(int[] intvl: result) {
            output[k++] = intvl;
        }
        return output;
    }

    private static boolean isOverlapping(int[] interval1, int[] interval2) {
        return Math.min(interval1[1], interval2[1]) >= Math.max(interval1[0], interval2[0]);
    }
}
