package com.narendra.sort;

import java.util.Arrays;

public class NaiveCountingSort {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 4, 4, 1, 0, 1};
        sort(arr, 5);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int k) {

        int count[] = new int[k];
        int index = 0;
        for (int i = 0; i < k; i++) {
            int occur = 0;
            for (int j = 0; j < arr.length; j++) {
                if(arr[j] == i) {
                    occur ++;
                }
            }

            count[i] = occur;
        }

        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr[index] = i; //In the naive approach we are writing the whole new object to the array. This will not work for reference types. Stability is also not supported.
                index ++;
            }
        }

    }
}
