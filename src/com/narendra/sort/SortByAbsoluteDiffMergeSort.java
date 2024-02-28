package com.narendra.sort;

import java.util.ArrayList;
import java.util.List;

public class SortByAbsoluteDiffMergeSort {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(5);
        arr.add(3);
        arr.add(9);
        arr.add(2);
        mergeSort(arr, arr.size(), 7, 0, arr.size()-1);
        System.out.println(arr);
    }

    private static void mergeSort(List<Integer> arr, int n, int k, int low, int high) {

        if(low < high) {
            int mid = low + (high - low)/2;
            mergeSort(arr, n, k, low, mid);
            mergeSort(arr, n, k, mid+1, high);
            merge(arr, n, k, low, mid, high);
        }
    }

    private static void merge(List<Integer> arr, int n, int k, int low, int mid, int high) {

        int left[] = new int[mid - low + 1];
        int right[] = new int[high - mid];
        int index = low;

        for(int i=0; i<left.length; i++) {
            left[i] = arr.get(low + i);
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = arr.get(mid+1+i);
        }

        int i=0;
        int j=0;

        while (i< left.length && j<right.length) {

            int leftI = Math.abs(left[i] - k);
            int rightJ = Math.abs(right[j] - k);

            if(leftI < rightJ) {
                arr.set(index, left[i]);
                i++;
            } else if(leftI > rightJ) {
                arr.set(index, right[j]);
                j++;
            } else {
                arr.set(index, left[i]);
                index ++;
                arr.set(index, right[j]);
                i++;
                j++;
            }
            index ++;
        }

        while(i<left.length) {
            arr.set(index, left[i]);
            i++;
            index++;
        }

        while(j<right.length) {
            arr.set(index, right[j]);
            j++;
            index++;
        }

    }

    static void arrange(long arr[], int n)
    {
        // your code here

        for(int i=0; i<n; i++) {
            arr[i] = ((arr[(int)arr[i]]%n) * n) + arr[i];
        }

        for(int i=0; i<n; i++) {
            arr[i] = arr[i]/2;
        }
    }
}
