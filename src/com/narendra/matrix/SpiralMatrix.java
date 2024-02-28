package com.narendra.matrix;

public class SpiralMatrix {

    public static void main(String[] args) {
        //int arr[][] = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int arr[][] = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        //int arr[][] = new int[][]{{1, 2, 3}, {4, 5, 6}};
        //int arr[][] = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}};
        //int arr[][] = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        printSpiral(arr);
    }

    private static void printSpiral(int[][] arr) {

        int top = 0;
        int right = arr[0].length-1;
        int bottom = arr.length-1;
        int left = 0;

        while(true) {

            for (int i = left; i <= right; i++) {
                System.out.print(arr[top][i] + " ");
            }
            top++;

            if(top > bottom){
                return;
            }

            for (int i = top; i <= bottom; i++) {
                System.out.print(arr[i][right] + " ");
            }
            right --;

            if(right < left) {
                return;
            }

            for (int i = right; i >= left ; i--) {
                System.out.print(arr[bottom][i] + " ");
            }

            bottom --;

            if(bottom < top) {
                return;
            }

            for (int i = bottom; i >=top ; i--) {
                System.out.print(arr[i][left] + " ");
            }

            left++;

            if(left > right) {
                return;
            }
        }
    }
}
