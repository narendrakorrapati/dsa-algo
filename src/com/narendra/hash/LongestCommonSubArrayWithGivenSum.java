package com.narendra.hash;

public class LongestCommonSubArrayWithGivenSum {

    public static void main(String[] args) {
        int arr1[] = new int[]{0, 1, 0, 0, 0, 0};
        int arr2[] = new int[]{1, 0, 1, 0, 0, 1};
        int length = longestCommonSubArrayNaive(arr1, arr2, arr1.length);
        System.out.println(length);
    }

    private static int longestCommonSubArrayNaive(int[] arr1, int[] arr2, int n) {
        int length = 0;

        for (int i = 0; i < n; i++) {
            int sum1 = 0;
            int sum2 = 0;

            for (int j = i; j < n; j++) {
                sum1 += arr1[j];
                sum2 += arr2[j];
                if(sum1 == sum2) {
                    length = Math.max(length, j-i+1);
                    System.out.println(i + "," + j);
                }
            }
        }
        return length;
    }
}
