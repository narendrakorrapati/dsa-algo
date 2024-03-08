package com.narendra.hash;

import java.util.HashSet;

public class CountDistinctElements {

    public static void main(String[] args) {
        int arr[] = new int[]{15, 12, 13, 12, 13, 13, 18};
        int count = countDistinct(arr);
        System.out.println(count);
    }

    private static int countDistinct(int[] arr) {
        HashSet<Integer> temp = new HashSet<>(arr.length);

        for (int i = 0; i < arr.length; i++) {
            temp.add(arr[i]);
        }
        return temp.size();
    }
}
