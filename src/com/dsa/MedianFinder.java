/**
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * Implement the MedianFinder class:
 * MedianFinder() initializes the MedianFinder object.
 * void addNum(int num) adds the integer num from the data stream to the data structure.
 * double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 */
package com.dsa;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> smaller;
    PriorityQueue<Integer> larger;

    MedianFinder() {
        this.smaller = new PriorityQueue<>(Comparator.reverseOrder());
        this.larger = new PriorityQueue<>();
    }

    public void addNumber(int num) {
        smaller.add(num);
        if(!smaller.isEmpty() && !larger.isEmpty() && smaller.peek() > larger.peek()) {
            larger.offer(smaller.poll());
        }
        if(smaller.size() > larger.size() + 1) {
            larger.offer(smaller.poll());
        }
        if(larger.size() > smaller.size() + 1) {
            smaller.offer(larger.poll());
        }
    }

    public double findMedian() {
        if(smaller.size() > larger.size())
            return smaller.peek();
        if(larger.size() > smaller.size())
            larger.peek();
        return (smaller.peek() + larger.peek()) / 2.0;
    }

}
