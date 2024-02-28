package com.narendra.matrix;

import java.util.Arrays;

public class RotateMatrixBy90AntiClock {

    public static void main(String[] args) {
        int arr[][] = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //rotateBy90(arr, arr.length);
        rotateBy90Inplace(arr, arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    private static void rotateBy90Inplace(int[][] arr, int n) {

        //Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        //Swap first row with last row, second first row with second last row and so on.

        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[n-1-i][j];
                arr[n-1-i][j] = temp;
            }
        }

    }

    private static void rotateBy90(int[][] arr, int n) {

        int temp[][] = new int[n][n];

        for (int i = 0; i < n; i++) {

            for (int j = n-1; j>=0; j--) {
                temp[n-1-j] [i] = arr[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = temp[i][j];
            }
        }
    }
}
