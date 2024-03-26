package com.narendra.stack;

import java.util.ArrayDeque;
import java.util.Arrays;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 15, 10, 8, 6, 12, 9, 18};
        int[] prevGreater = getNextGreater(arr);
        System.out.println(Arrays.toString(prevGreater));
    }

    private static int[] getNextGreater(int[] arr) {

        int[] nextGreater = new int[arr.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        stack.push(arr[arr.length-1]);
        nextGreater[arr.length-1] = -1;

        for (int i = arr.length-2; i >=0; i--) {

            while(!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            nextGreater[i] = stack.isEmpty()? -1: stack.peek();
            stack.push(arr[i]);
        }
        return nextGreater;
    }
}
