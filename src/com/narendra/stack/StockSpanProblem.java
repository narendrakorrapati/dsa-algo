package com.narendra.stack;

import java.util.ArrayDeque;
import java.util.Arrays;

public class StockSpanProblem {

    public static void main(String[] args) {

        int arr[] = new int[]{60, 10, 20, 40, 35, 30, 50, 70, 65};
        int span[] = getSpan(arr);
        System.out.println(Arrays.toString(span));
    }

    private static int[] getSpan(int[] arr) {

        int[] span = new int[arr.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        span[0] = 1;
        stack.push(0); //Index of first price

        for (int i = 1; i < arr.length; i++) { //Traverse through each price

            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) { //Check if top of stack is <= arr[i] if yes, we don't need it and look for its previous greater element.
                stack.pop();
            }

            span[i] = stack.isEmpty()? i+1: i - stack.peek();
            stack.push(i);
        }
        return span;
    }
}
