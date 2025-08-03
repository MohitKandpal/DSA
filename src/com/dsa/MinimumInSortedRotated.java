package com.dsa;

public class MinimumInSortedRotated {
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        int i;
        for(i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1])
                break;
        }

        if(i == arr.length - 1)
            System.out.println("Minimum - " + arr[0]);
        else
            System.out.println("Minimum - " + arr[i + 1]);
    }
}
