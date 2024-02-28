package com.narendra.sort;

import java.util.Arrays;

/**
 * Dutch national flag algorithm.
 */
public class SortArrayWithThreeElements {

    public static void main(String[] args) {
        int arr[] = new int[]{0, 1, 2, 1, 1, 2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {

        int low=0, mid = 0, high = arr.length-1;

        while(mid<=high) {
            if(arr[mid] == 0) {
                swap(arr, mid, low);
                low ++;
                mid ++;
            } else if (arr[mid] == 1) {
                mid ++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
