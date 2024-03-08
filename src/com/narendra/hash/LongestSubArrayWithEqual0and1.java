package com.narendra.hash;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubArrayWithEqual0and1 {

    public static void main(String[] args) {
        //int arr[] = new int[]{1, 0, 1, 1, 1, 0, 0};
        int arr[] = new int[] {1, 1, 1, 0, 1, 0, 1, 1, 1};
        //int arr[] = new int[]{1, 1, 1, 1};
        //int arr[] = new int[]{0, 0, 1, 1, 1, 1, 1};
        //int arr[] = new int[]{0, 0, 1, 0, 1, 1};
        int length = getLengthNaive(arr);
        System.out.println(length);
        length = getLengthEfficient(arr);
        System.out.println(length);
    }

    private static int getLengthEfficient(int[] arr) {
        int length = 0;
        int prefix = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                arr[i] = -1;
            }
        }

        for (int i = 0; i < arr.length; i++) {

            prefix = prefix + arr[i];

            if(prefix == 0) {
                length = Math.max(length, i+1);
            }

            if(map.containsKey(prefix)) {
                int position = map.get(prefix);
                length = Math.max(length, i-position);
            } else {
                map.put(prefix, i);
            }

        }
        System.out.println(map);
        return length;
    }

    private static int getLengthNaive(int[] arr) {
        int length = 0;

        for (int i = 0; i < arr.length; i++) {
            int count1 = 0;
            int count0 = 0;
            for (int j = i; j < arr.length; j++) {
                if(arr[j] == 1) {
                    count1++;
                } else {
                    count0 ++;
                }
                if(count1 == count0) {
                    length = Math.max(length, j-i + 1);
                    System.out.println(i + "," + j);
                }

            }
        }

        return length;
    }
}
