package com.narendra.sort;

import java.util.Arrays;

public class EfficientCountingSort {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 4, 4, 1, 0, 1};
        sort(arr, 5);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int k) {
        int count[] = new int[k];
        int output[] = new int[arr.length];

        for(int i=0;i<arr.length;i++)
            count[arr[i]]++;

        //Create prefix sum for count array so that we know how elements less than or equal to current elements exists.

        for (int i = 1; i < count.length; i++) {
            count[i] = count[i-1] + count[i];
        }

        for (int i = arr.length-1; i >=0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]] = count[arr[i]] - 1;
        }

        System.out.println("Output array:" + Arrays.toString(output));
        System.out.println("Count array:" + Arrays.toString(count));

        for (int i = 0; i < output.length; i++) {
            arr[i] = output[i];
        }
    }
}
