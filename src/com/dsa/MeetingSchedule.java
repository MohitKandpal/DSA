/**
 * Given an array of meeting time interval objects consisting of start and end times [[start_1,end_1],[start_2,end_2],...] (start_i < end_i), determine if a person could add all meetings to their schedule without any conflicts.
 */
package com.dsa;

import java.util.Arrays;

public class MeetingSchedule {
    public static void main(String[] args) {
        int[][] intervals = {{0,30}, {5,10}, {15,20}};
        System.out.println("All meetings " + (canAttend(intervals) ? "can" : "cannot") + " be attended");
    }

    private static boolean canAttend(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2)->i1[0] - i2[0]);

        for(int i = 0; i < intervals.length - 1; i++) {
            int[] curInterval = intervals[i], nextInterval = intervals[i + 1];
            if(curInterval[1] > nextInterval[0])
                return false;
        }
        return true;
    }
}
