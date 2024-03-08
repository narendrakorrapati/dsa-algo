package com.narendra.hash;

import java.util.Arrays;
import java.util.HashMap;

public class FrequenciesOfArrayElements {

    public static void main(String[] args) {
        int arr[] = new int[]{10, 12, 10, 15, 10, 20, 12, 12, 20};
        printFrequenciesNaive(arr);
        printFrequencies(arr);
    }

    private static void printFrequencies(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>(arr.length);

        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                int count = map.get(arr[i]) + 1;
                map.put(arr[i], count);
            } else {
                map.put(arr[i], 1);
            }
        }

        System.out.println(map);
    }

    private static void printFrequenciesNaive(int[] arr) {

        Arrays.sort(arr);

        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i-1]) {
                count++;
            } else {
                System.out.println(arr[i-1] + " : " + count);
                count = 1;
            }
        }

        System.out.println(arr[arr.length-1] + " : " + count);
    }
}
