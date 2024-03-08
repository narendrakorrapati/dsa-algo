package com.narendra.hash;

import java.util.HashSet;

public class SubArrayWithZeroSum {

    public static void main(String[] args) {
        //int arr[] = new int[]{1, 4, 13, -3, -10, 5};
        //int arr[] = new int[]{-1, 4, -3, 5, 1};
        //int arr[] = new int[]{3, 1, -2, 5, 6};
        int arr[] = new int[]{5, 6, 0, 8};
        boolean status = hasSubArrayWithZeroSumNaive(arr);
        System.out.println(status);

        status = hasSubArrayWithZeroSumEfficient(arr);
        System.out.println(status);
    }

    private static boolean hasSubArrayWithZeroSumEfficient(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        int prefixSum = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum = prefixSum + arr[i];
            if(prefixSum == 0) {
                return true;
            }

            if(set.contains(prefixSum)) {
                return true;
            } else {
                set.add(prefixSum);
            }

        }

        return false;
    }

    private static boolean hasSubArrayWithZeroSumNaive(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                return true;
            }
            int currSum = arr[i];

            for (int j = i+1; j < arr.length; j++) {
                currSum = currSum + arr[j];
                if(currSum == 0) {
                    System.out.println(i + "," + j);
                    return true;
                }
            }
        }

        return false;
    }
}
