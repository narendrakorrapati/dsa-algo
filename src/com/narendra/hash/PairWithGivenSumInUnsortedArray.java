package com.narendra.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PairWithGivenSumInUnsortedArray {

    public static void main(String[] args) {
        int arr[] = new int[]{3, 2, 8, 15, -8};
        boolean status = hasPariWithGivenSumNaive(arr, 17);
        System.out.println(status);

        status = hasPariWithGivenSumEffective(arr, 17);
        System.out.println(status);
    }

    private static boolean hasPariWithGivenSumEffective(int[] arr, int sum) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if(set.contains(sum - arr[i])) {
                return true;
            } else {
                set.add(arr[i]);
            }
        }
        return false;
    }

    private static boolean hasPariWithGivenSumNaive(int[] arr, int sum) {

        for (int i = 0; i < arr.length-1; i++) {
            int tempSum = sum - arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] == tempSum) {
                    return true;
                }
            }
        }
        return false;
    }
}
