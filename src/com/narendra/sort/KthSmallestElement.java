package com.narendra.sort;

public class KthSmallestElement {

    public static void main(String[] args) {
        int arr[] = new int[]{10, 4, 5, 8, 11, 6, 26};
        int smallest = kthSmallest(arr, 5);
        System.out.println(smallest);
    }

    private static int kthSmallest(int[] arr, int k) {

        int low = 0;
        int high = arr.length-1;

        while(low <= high) {
            int p = partition(arr, low, high);
            if(p == k-1) {
                return arr[p];
            } else if(p > k-1) {
                high = p-1;
            } else {
                low = p + 1;
            }
        }
        return -1;
    }

    private static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i= low - 1;

        for (int j = low; j <= high-1; j++) {
            if(arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
