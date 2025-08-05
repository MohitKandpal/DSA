package com.dsa;

public class KadaneAlgorithm {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int maxEndingHere = 0, maxSofar = Integer.MIN_VALUE;
        for(int num: arr) {
            maxEndingHere += num;
            if(maxEndingHere < 0)
                maxEndingHere = 0;
            maxSofar = Math.max(maxSofar, maxEndingHere);
        }
        System.out.println("Maximum sum for a subarray: - " + maxSofar);
    }
}
