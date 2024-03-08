package com.narendra.matrix;

import java.util.Arrays;

public class BooleanMatrix {

    public static void main(String[] args) {
        //int arr[][] = new int[][]{{1, 0, 0}, {1, 0, 0}, {1, 0, 0}, {0, 0, 0}};
        //int arr[][] = new int[][]{{1, 0}, {0, 0}};
        int arr[][] = new int[][]{{1, 0, 0}, {1, 0, 0}, {0, 0, 1}, {0, 0, 0}};
        booleanMatrix(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    private static void booleanMatrix(int[][] arr) {

        int rowSize = arr.length;
        int colSize = arr[0].length;

        int temp[][] = new int[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if(arr[i][j] == 1) {
                    setOnes(temp, i, j, rowSize, colSize);
                }
            }
        }

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                arr[i][j] = temp[i][j];
            }
        }

    }

    private static void setOnes(int[][] temp, int row, int col, int rowSize, int colSize) {

        for (int i = 0; i < colSize; i++) {
            temp[row][i] = 1;
        }

        for (int i = 0; i < rowSize; i++) {
            temp[i][col] = 1;
        }
    }

}
