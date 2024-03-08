package com.narendra.matrix;

import java.util.Arrays;

public class SearchInRowWiseAndColWiseSortedMatrix {

    public static void main(String[] args) {
        int arr[][] = new int[][]{{10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48}, {32, 33, 39, 50}};
        int [] result = binarySearch(arr, 10);
        System.out.println(Arrays.toString(result));
    }

    private static int[] binarySearch(int[][] arr, int target) {

        int row = 0;
        int col = arr[0].length-1;

        while(row < arr.length && col >=0 ){

            if(target == arr[row][col]) {
                return new int[]{row, col};
            } else if(target < arr[row][col]) {
                col--;
            } else {
                row ++;
            }
        }
        return new int[]{-1, -1};
    }
}
