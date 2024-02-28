package com.narendra.sort;

import java.util.ArrayList;
import java.util.List;

public class SortByAbsoluteDiffQuickSort {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(5);
        arr.add(3);
        arr.add(9);
        arr.add(2);
        quickSort(arr, arr.size(), 7, 0, arr.size()-1);
        System.out.println(arr);

    }

    static void quickSort(List<Integer> arr, int n, int k, int low, int high) {

        if(low < high) {
            int p = partition(arr, n, k, low, high);
            quickSort(arr, n, k, low, p);
            quickSort(arr, n, k, p+1, high);

        }
    }

    static int partition(List<Integer> arr, int n, int k, int low, int high) {

        int i = low-1;
        int j = high+1;
        int pivot = Math.abs(arr.get(low) - k);

        while(i <= j) {

            do{
                i++;
            } while(Math.abs(arr.get(i) - k) < pivot);

            do{
                j--;
            } while(Math.abs(arr.get(j)- k) > pivot);

            if(i >= j) {
                return j;
            }
            swap(arr, i, j);
        }

        return -1;
    }

    static void swap(List<Integer> arr, int i, int j) {

        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}
