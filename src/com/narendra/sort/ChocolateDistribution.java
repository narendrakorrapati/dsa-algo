package com.narendra.sort;

import java.util.Arrays;

public class ChocolateDistribution {

    public static void main(String[] args) {
        /**
         * Each element in array is the pack of chocolates.
         * Need to pick m packets such that difference between them is minimum (Fair distribution)
         */
        int arr[] = new int[]{7, 3, 2, 4, 9, 12, 56};
        int minimum = pickChocolates(arr, 3);
        System.out.println(minimum);
    }

    private static int pickChocolates(int[] arr, int m) {

        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - m -1; i++) {
            min = Math.min(min, arr[m-1+i] - arr[i]);
        }
        return min;
    }
}
