package com.narendra.sort;

import java.util.Arrays;

/**
 * Three way partition using Dutch national flag algorithm
 */
public class ThreeWayPartition {

    public static void main(String[] args) {
        int arr[] = new int[]{2, 1, 2, 20, 20, 20, 1};
        threeWayPartition(arr, 2);
        System.out.println(Arrays.toString(arr));
    }

    private static void threeWayPartition(int[] arr, int pivot) {

        int low = 0, mid = 0, high = arr.length-1;

        while(mid <= high) {
            if(arr[mid] == pivot) {
                mid++;
            } else if(arr[mid] < pivot) {
                swap(arr, mid, low);
                low ++;
                mid ++;
            } else {
                swap(arr, mid, high);
                high --;
            }
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
