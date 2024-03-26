package com.narendra.stack;

import java.util.ArrayDeque;

public class LargestRectangleAreaInAHistogramBetter {

    public static void main(String[] args) {
        int[] height = new int[]{6, 2, 5, 4, 1, 5, 6};
        int largestArea = getLargestArea(height);
        System.out.println(largestArea);
    }

    private static int getLargestArea(int[] heights) {

        int largestArea = 0;
        int[] previousSmall = getPreviousSmall(heights);
        int[] nextSmall = getNextSmall(heights);

        for (int i = 0; i < heights.length; i++) {
            int width = ((nextSmall[i]) - (previousSmall[i])) - 1;
            int height = heights[i];
            largestArea = Math.max(largestArea, width * height);
        }

        return largestArea;
    }

    private static int[] getPreviousSmall(int[] arr) {

        int[] prevSmaller = new int[arr.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        stack.push(0);
        prevSmaller[0] = -1;

        for (int i = 1; i < arr.length; i++) {

            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            prevSmaller[i] = stack.isEmpty()? -1: stack.peek();
            stack.push(i);
        }
        return prevSmaller;
    }

    private static int[] getNextSmall(int[] arr) {

        int[] nextSmaller = new int[arr.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        stack.push(arr.length-1);
        nextSmaller[arr.length-1] = arr.length;

        for (int i = arr.length-2; i >= 0; i--) {

            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            nextSmaller[i] = stack.isEmpty()? arr.length: stack.peek();
            stack.push(i);
        }
        return nextSmaller;
    }
}
