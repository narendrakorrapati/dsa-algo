package com.narendra.hash;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSubSequence {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 3, 4, 3, 3, 2, 9, 10};
        //int arr[] = new int[]{1, 9, 3, 4, 2, 20};
        //int arr[] = new int[]{8, 20, 7, 30};
        //int arr[] = new int[]{20, 30, 40};
        int length = getSubsequenceLengthNaive(arr);
        System.out.println(length);
        length = getSubsequenceLengthEfficient(arr);
        System.out.println(length);
    }

    private static int getSubsequenceLengthEfficient(int[] arr) {

        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<arr.length; i++) {
            set.add(arr[i]);
        }

        int maxLength = 1;

        for(Integer key: set) {
            int currentLength = 1;
            if(!set.contains(key-1)) {
                while(set.contains(key + currentLength)) {
                    currentLength++;
                }
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }

    private static int getSubsequenceLengthNaive(int[] arr) {
        Arrays.sort(arr);

        int maxLength = 1;
        int currentLength = 1;

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i-1] + 1) {
                currentLength ++;
            } else if(arr[i] != arr[i-1]) {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
        }
        return Math.max(maxLength, currentLength);
    }
}
