/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 */
package com.dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {
        int numOfCourses = 2;
        int[][] prerequisites = {{1,0}};
        System.out.println("Courses " + ((canBeFinished(numOfCourses, prerequisites) ? "can" : "cannot") + " be finished"));
    }

    private static boolean canBeFinished(int numOfCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < numOfCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++) {
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] in = new int[numOfCourses];
        for(int i = 0 ; i < numOfCourses; i++) {
            for(int adjElem: adjList.get(i)) {
                in[adjElem]++;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int it: in) {
            if(in[it] == 0) {
                queue.add(it);
            }
        }

        while(!queue.isEmpty()) {
            int courseInd = queue.remove();
            result.add(courseInd);
            for(int it: adjList.get(courseInd)) {
                in[it]--;
                if(in[it] == 0) {
                    queue.add(it);
                }
            }
        }
        return result.size() == numOfCourses;
    }
}
