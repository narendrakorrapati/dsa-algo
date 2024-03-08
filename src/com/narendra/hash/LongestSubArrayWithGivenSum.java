package com.narendra.hash;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithGivenSum {

    public static void main(String[] args) {
        //int arr[] = new int[]{5, 8, -4, -4, 9, -2, 2}; // 0
        int arr[] = new int[]{3, 1, 0, 1, 8, 2, 3}; // 5
        //int arr[] = new int[]{8, 3, 7}; // 15
        int length = getLongestSubArrayWithGivenSumNaive(arr, 5);
        System.out.println(length);
        length = getLongestSubArrayWithGivenSumEfficient(arr, 5);
        System.out.println(length);
    }

    private static int getLongestSubArrayWithGivenSumEfficient(int[] arr, int sum) {
        int length = 0;
        int prefix = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            prefix = prefix + arr[i];

            if(prefix == sum) {
                length = Math.max(length, i+1);
            }

            if(map.containsKey(prefix - sum)) {
                int position = map.get(prefix - sum);
                length = Math.max(length, i - position);
            }

            if(!map.containsKey(prefix)) {
                map.put(prefix, i + 1); //Not overriding already found prefix. Meaning of same prefix is the sum of in between elements is 0. It can increase the length of sub array.
            }
        }
        System.out.println(map);
        return length;
    }

    private static int getLongestSubArrayWithGivenSumNaive(int[] arr, int sum) {

        int length = 0;

        for (int i = 0; i < arr.length; i++) {
            int currentSum = 0;
            for (int j = i; j < arr.length; j++) {
                currentSum += arr[j];
                if(currentSum == sum) {
                    length = Math.max(length, (j-i+1));
                }
            }
        }
        return length;
    }
}
