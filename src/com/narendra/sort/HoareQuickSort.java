package com.narendra.sort;

import java.util.Arrays;

public class HoareQuickSort {

    public static void main(String[] args) {
        int arr[] = new int[]{8, 4, 7, 8, 3, 10, 5};
        //int arr[] = new int[]{8, 8, 8, 8, 8, 8, 8};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {

        if(low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p);
            quickSort(arr, p+1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {

        int i = low - 1;
        int j = high + 1;
        int pivot = arr[low];

        while(true) {

            do{
                i++;
            } while(arr[i] < pivot); //Ignoring equal to pivot

            do{
                j--;
            } while(j>=low && arr[j] > pivot); //Ignoring equal to pivot

            //Both sides ignoring equal to pivot so if the elements are equal to pivot on both the sides, they still get swapped.
            //This is to avoid i or j running out of boundaries of low and high.

            if(i >= j) { //Here we need equal sign if i and j stops at same element, ideally that element will be equal to pivot (if we have duplicate elements of pivot).
                return j;
            }
            swap(arr, i, j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
