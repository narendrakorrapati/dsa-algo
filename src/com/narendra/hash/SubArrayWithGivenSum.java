package com.narendra.hash;

import java.util.HashSet;

public class SubArrayWithGivenSum {

    public static void main(String[] args) {
        //int arr[] = new int[]{5, 8, 6, 13, 3, -1};
        int arr[] = new int[]{15, 2, 8, 10, -5, -8, 6};
        boolean status = hasSubArrayWithGivenSumNaive(arr, 3);
        System.out.println(status);
        status = hasSubArrayWithGivenSumEfficient(arr, 3);
        System.out.println(status);
    }

    private static boolean hasSubArrayWithGivenSumEfficient(int[] arr, int sum) {

        HashSet<Integer> set = new HashSet<>();
        int prefixSum = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum = prefixSum + arr[i];
            if(prefixSum == sum) {
                return true;
            }
            if(set.contains(prefixSum - sum)) {
                return true;
            }
            set.add(prefixSum);
        }
        return false;
    }

    private static boolean hasSubArrayWithGivenSumNaive(int[] arr, int sum) {

        for (int i = 0; i < arr.length; i++) {
            int currentSum = 0;
            for (int j = i; j < arr.length; j++) {
                currentSum = currentSum + arr[j];
                if(currentSum == sum) {
                    return true;
                }
            }
        }

        return false;
    }
}
