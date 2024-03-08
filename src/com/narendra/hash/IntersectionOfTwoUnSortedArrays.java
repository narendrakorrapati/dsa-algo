package com.narendra.hash;

import java.util.HashSet;

public class IntersectionOfTwoUnSortedArrays {

    public static void main(String[] args) {
        /**
         * Assumption: All the array elements are distinct
         */
        int arr1[] = new int[]{10, 15, 20, 25, 30, 50};
        int arr2[] = new int[]{30, 5, 15, 80};
        printIntersectionNaive(arr1, arr2);
        System.out.println();
        printIntersectionEfficient(arr1, arr2);
    }

    private static void printIntersectionEfficient(int[] arr1, int[] arr2) {
        //Time: O(n + m)
        //Space: O(m)
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }

        for (int i = 0; i < arr1.length; i++) {
            if(set.contains(arr1[i])) {
                System.out.print(arr1[i] + " ");
            }
        }
    }

    private static void printIntersectionNaive(int[] arr1, int[] arr2) {
        //Time: O(n * m)
        //Space: O(1)
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if(arr1[i] == arr2[j]) {
                    System.out.print(arr1[i] + " ");
                    break;
                }
            }
        }
    }
}
