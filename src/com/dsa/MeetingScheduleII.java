/**
 * Given an array of meeting time interval objects consisting of start and end times [[start_1,end_1],[start_2,end_2],...] (start_i < end_i), find the minimum number of days required to schedule all meetings without any conflicts.
 * Note: (0,8),(8,10) is not considered a conflict at 8.
 */
package com.dsa;

import java.util.Arrays;

public class MeetingScheduleII {
    public static void main(String[] args) {
        int[][] intervals = {{0,30}, {5,10}, {15,20}};
        System.out.println("Minimum days required to schedule all meetings: - " + findMinDaysRequiredToSchedule(intervals));
    }

    private static int findMinDaysRequiredToSchedule(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n], end = new int[n];
        for(int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start); Arrays.sort(end);
        int s = 0, e = 0, count = 0, res = 0;
        while(s < n) {
            if(start[s] < end[e]) {
                s++;
                count++;
            } else {
                e++;
                count--;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
