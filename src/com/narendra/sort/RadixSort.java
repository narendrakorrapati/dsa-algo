package com.narendra.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int arr[] = new int[]{319, 212, 6, 8, 100, 50};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int arr[]) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        for(int exp = 1; max/exp >0 ; exp = exp*10) {
            countingSort(arr, exp);
        }
    }

    private static void countingSort(int[] arr, int exp) {
        int count[] = new int[10];
        int output[] = new int[arr.length];

        for(int i=0;i<arr.length;i++)
            count[(arr[i]/exp)%10]++; //For exp = 1 take last digit, for exp = 10 take last second digit

        //Create prefix sum for count array so that we know how elements less than or equal to current elements exists.

        for (int i = 1; i < count.length; i++) {
            count[i] = count[i-1] + count[i];
        }

        for (int i = arr.length-1; i >=0; i--) {
            output[count[(arr[i]/exp) % 10] - 1] = arr[i]; //Arranging array elements according to their current digit in processing.
            count[(arr[i]/exp) % 10]--;
        }

        //System.out.println("Output array:" + Arrays.toString(output));
        //System.out.println("Count array:" + Arrays.toString(count));

        for (int i = 0; i < output.length; i++) {
            arr[i] = output[i];
        }
    }
}
