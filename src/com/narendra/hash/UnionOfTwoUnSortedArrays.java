package com.narendra.hash;

import java.util.Arrays;
import java.util.HashSet;

public class UnionOfTwoUnSortedArrays {
    public static void main(String[] args) {
        int arr1[] = new int[]{10, 30, 10};
        int arr2[] = new int[]{5, 10, 5};
        printUnionCountNaive(arr1, arr2);
        System.out.println();
        printUnionCountEfficient(arr1, arr2);
    }

    private static void printUnionCountEfficient(int[] arr1, int[] arr2) {

        //Time: O(n + m)
        //Space: O(n + m)
        //We can use LinkedHashSet to maintain the order
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }

        System.out.println("Count of distinct elements:" + set.size());
        System.out.println(set);
    }

    private static void printUnionCountNaive(int[] arr1, int[] arr2) {
        //Time O(n * n + m * (n+m))
        //Space O(n + m)
        int dist[] = new int[arr1.length + arr2.length];
        int index = 0;

        for (int i = 0; i < arr1.length; i++) {
            if(!isPresent(dist, index, arr1[i])) {
                dist[index] = arr1[i];
                index ++;
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            if(!isPresent(dist, index, arr2[i])) {
                dist[index] = arr2[i];
                index ++;
            }
        }

        System.out.println("Count of distinct elements:" + index);

        System.out.println(Arrays.toString(dist));
    }

    private static boolean isPresent(int[] dist, int index, int value) {
        for (int i = 0; i <=index; i++) {
            if(dist[i] == value) {
                return true;
            }
        }
        return false;
    }
}
