package com.narendra.sort;

import java.util.Arrays;

public class SegregatePositiveAndNegative {

    public static void main(String[] args) {
        int arr[] = new int[]{15, -3, -2, 18, -6};
        segregateLomuto(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{15, -3, -2, 18, -6};
        segregateHoare(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void segregateHoare(int[] arr) {

        int i=-1;
        int j = arr.length;

        while(true) {

            do {
                i++;
            }while (arr[i] < 0);

            do {
                j--;
            } while(arr[j] > 0);
            if(i>=j) {
                return;
            }
            swap(arr, i, j);

        }

    }

    private static void segregateLomuto(int[] arr) {

        int i = -1;

        for (int j = 0; j < arr.length; j++) {
            if(arr[j] < 0) {
                i++;
                swap(arr, i, j);
            }
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
