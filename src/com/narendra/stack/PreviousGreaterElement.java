package com.narendra.stack;

import java.util.ArrayDeque;
import java.util.Arrays;

public class PreviousGreaterElement {

    public static void main(String[] args) {
        int[] arr = new int[]{15, 10, 18, 12, 4, 6, 2, 8};
        int[] prevGreater = getPrevGreater(arr);
        System.out.println(Arrays.toString(prevGreater));
    }

    private static int[] getPrevGreater(int[] arr) {

        int[] prevGreater = new int[arr.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        stack.push(arr[0]);
        prevGreater[0] = -1;

        for (int i = 1; i < arr.length; i++) {

            while(!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            prevGreater[i] = stack.isEmpty()? -1: stack.peek();
            stack.push(arr[i]);
        }
        return prevGreater;
    }
}
