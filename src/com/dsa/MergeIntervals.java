/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
package com.dsa;

import java.util.Arrays;
import java.util.Stack;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] ans = mergeOverlappingIntervals(intervals);

        System.out.println("Merged Intervals: - ");
        for(int i = 0; i < ans.length; i++) {
            System.out.print("[");
            for(int j = 0; j < ans[0].length; j++) {
                System.out.print((j == ans[0].length - 1) ? ans[i][j] : ans[i][j] + ",");
            }
            System.out.print((i == ans.length - 1) ? "]" : "],");
        }
    }

    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        if(intervals.length == 1)
            return intervals;
        Arrays.sort(intervals, (i1, i2)-> i1[0] - i2[0]);

        Stack<int[]> st = new Stack<>();
        st.push(intervals[0]);

        for(int i = 1; i < intervals.length; i++) {
            int[] peekInterval = st.peek();
            if(intervals[i][0] > peekInterval[1]) {
                st.push(intervals[i]);
            } else {
                peekInterval[1] = Math.max(peekInterval[1], intervals[i][1]);
                st.pop();
                st.push(peekInterval);
            }
        }

        int[][] ans = new int[st.size()][2];
        int k = 0;
        while(!st.isEmpty()) {
            int[] interval = st.pop();
            ans[k++] = interval;
        }
        return ans;
    }
}
