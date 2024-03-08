package com.narendra.hash;

import java.util.HashMap;
import java.util.HashSet;

public class CountDistinctElementsInEveryWindow {

    public static void main(String[] args) {
        int arr[] = new int[]{10, 20, 20, 10, 30, 40, 10};
        printDistinctCount(arr, 4);
        System.out.println();
        printDistinctCountEfficient(arr, 4);
    }

    private static void printDistinctCountEfficient(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int i=0;
        int j=k-1;

        while(j<arr.length) {
            System.out.print(map.size() + " ");
            i++;
            j++;

            if(j<arr.length) {
                int count = map.get(arr[i-1]);
                if(count == 1) {
                    map.remove(arr[i-1]);
                } else {
                    map.put(arr[i-1], count - 1);
                }
                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            }
        }
    }

    private static void printDistinctCount(int[] arr, int k) {

        int i=0;
        int j=k-1;

        while(j < arr.length) {
            int count = getCount(arr, i, j);
            System.out.print(count + " ");
            i++;
            j++;
        }
    }

    private static int getCount(int[] arr, int i, int j) {

        HashSet<Integer> set = new HashSet<>();
        for (int k = i; k <=j ; k++) {
            set.add(arr[k]);
        }

        return set.size();
    }
}
