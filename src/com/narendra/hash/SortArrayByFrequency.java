package com.narendra.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/batch/dsa-self-paced/track/DSASP-Hashing/problem/sorting-elements-of-an-array-by-frequency-1587115621
 */
public class SortArrayByFrequency {

    public static void main(String[] args) {
        int arr[] = new int[]{9, 9, 9, 2, 5};
        System.out.println(sortByFreq(arr, arr.length));
    }

    static ArrayList<Integer> sortByFreq(int arr[], int n)
    {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int i=0; i<n; i++) {
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }

        quickSort(arr, 0, n-1, freqMap);

        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0; i<n; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    static void quickSort(int arr[], int low, int high, Map<Integer, Integer> freqMap) {

        if(low < high) {
            int pivot = partition(arr, low, high, freqMap);
            quickSort(arr, low, pivot-1, freqMap);
            quickSort(arr, pivot + 1, high, freqMap);
        }
    }

    static int partition(int arr[], int low, int high, Map<Integer, Integer> freqMap) {

        int i=low - 1;
        int freqPivot = freqMap.get(arr[high]);
        int elePivot = arr[high];

        for(int j=low; j<=high-1; j++) {
            if(freqMap.get(arr[j]) > freqPivot) {
                i++;
                swap(arr, i, j);
            } else if(freqMap.get(arr[j]) == freqPivot) {
                if(arr[j] < elePivot) {
                    i++;
                    swap(arr, i, j);
                }
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
