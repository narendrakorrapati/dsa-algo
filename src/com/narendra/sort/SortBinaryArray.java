package com.narendra.sort;

import java.util.Arrays;

public class SortBinaryArray {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] A) {

        if(A.length == 1) {
            return;
        }

        int i=-1;
        int j=A.length;

        while(true) {

            do{
                i++;
            } while(i<A.length && A[i] == 0);

            do{
                j--;
            } while(j>=0 && A[j] == 1);

            if(i >= j) {
                return;
            }
            swap(A, i, j);

        }
    }

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
