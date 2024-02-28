package com.narendra.matrix;

public class BoundaryElements {

    public static void main(String[] args) {
        int arr[][] = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        //int arr[][] = new int[][]{{1, 2, 3, 4}};
        //int arr[][] = new int[][]{{1}, {2}, {3}, {4}};
        //int arr[][] = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        //int arr[][] = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}};
        printBoundaryElements(arr, 4, 4);
    }

    private static void printBoundaryElements(int[][] arr, int row, int col) {

        if(row == 1) {
            //Top row
            for(int j=0; j<col; j++) {
                System.out.print(arr[0][j] + " ");
            }
        } else if(col == 1) {
            for(int j=0; j<row; j++) {
                System.out.print(arr[j][0] + " ");
            }
        } else {
            //Top row
            for(int j=0; j<arr[0].length; j++) {
                System.out.print(arr[0][j] + " ");
            }

            //Right side column
            for (int i = 1; i < arr.length-1; i++) {
                System.out.print(arr[i][arr[i].length-1] + " ");
            }

            //Bottom row
            for (int j = arr[arr.length-1].length - 1; j >=0 ; j--) {
                System.out.print(arr[arr.length-1][j] + " ");
            }

            //Left column
            for(int i=arr.length-2; i>=1; i--) {
                System.out.print(arr[i][0] + " ");
            }
        }
    }
}
