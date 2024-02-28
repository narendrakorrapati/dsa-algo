package com.narendra.sort;

import java.util.Arrays;

public class MinimumDifferenceInArray {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 8, 12, 5, 18};
        int minDiff = minimumDiffNaive(arr);
        int minDiffUsingSort = minimumDiffUsingSort(arr);
        System.out.println("Naive:" + minDiff);
        System.out.println("Using Sort:" + minDiffUsingSort);
    }

    private static int minimumDiffUsingSort(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length-1; i++) {
            min = Math.min(min, Math.abs(arr[i+1] - arr[i]));
        }

        return min;
    }

    private static int minimumDiffNaive(int[] arr) {

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                min = Math.min(min, Math.abs(arr[j] - arr[i]));
            }
        }
        return min;
    }
}
