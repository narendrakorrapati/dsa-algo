package com.narendra.hash;

import java.util.HashMap;

/**
 * https://www.geeksforgeeks.org/batch/dsa-self-paced/track/DSASP-Hashing/problem/check-if-two-arrays-are-equal-or-not3847
 */
public class CheckIfTwoArraysAreEqual {

    public static void main(String[] args) {
        int[] A = new int[]{1, 1, 2, 5, 4, 0};
        int[] B = new int[]{2, 4, 1, 5, 0, 1};
        boolean status = checkNaive(A, B, A.length);
        System.out.println(status);
    }

    private static boolean checkNaive(int[] a, int[] b, int length) {

        for (int i = 0; i < length; i++) {

            int countA = 0, countB = 0;

            for (int j = 0; j < length; j++) {
                if(a[i] == a[j]) {
                    countA ++;
                }
                if(a[i] == b[j]) {
                    countB ++;
                }
            }

            if(countA != countB) {
                return false;
            }
        }
        return true;
    }
}
