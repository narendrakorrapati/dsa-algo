package com.narendra.matrix;

import java.util.Arrays;

public class TransposeOfMatrix {

    public static void main(String[] args) {
        int arr[][] = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        //transposeMatrix(arr, arr.length);
        transposeMatrixInplace(arr, arr.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    private static void transposeMatrixInplace(int[][] arr, int n) {

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    private static void transposeMatrix(int[][] arr, int n) {

        int[][] result = new int[n][];

        for (int i = 0; i < n; i++) {
            result[i] = new int[n];
            for (int j = 0; j < n; j++) {
                //System.out.print(arr[j][i] + " ");
                result[i][j] = arr[j][i];
            }
            //System.out.println();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = result[i][j];
            }
        }
    }
}
