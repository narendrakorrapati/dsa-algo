package com.narendra.stack;

import java.util.ArrayDeque;

public class LargestRectangleAreaInAHistogramEfficient {

    public static void main(String[] args) {
        int[] height = new int[]{6, 2, 5, 4, 1, 5, 6};
        int largestArea = getLargestArea(height);
        System.out.println(largestArea);
    }

    private static int getLargestArea(int[] heights) {

        int largestArea = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < heights.length; i++) {

            /*
            If top of stack is >= current height, we pop it.
            At that time, the 'i' becomes next small for the item being popped.
            Once item is popped, we need to look at the current top of the stack to get the previous small for the item just popped out.
                If the stack is empty -1 is the previous small.
            How current top becomes previous small? Ans: We are only keeping small items up to that point in the stack. Keeping the items in increasing order.
            If it was not the previous small of the item being popped then it should have been already popped by this item when processed previously.
             */
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int index = stack.pop(); //Current index that we are computing area.
                int ns = i; //Next small is the item at index 'i' that popped the current top of stack.
                int ps = stack.isEmpty() ? -1: stack.peek(); //Previous small is the current peek of the stack.
                int currentArea = (ns - ps - 1) * heights[index];
                System.out.println("Area of Index:" +index + " is:" + currentArea);
                largestArea = Math.max(largestArea, currentArea);
            }
            stack.push(i);
        }

        /*
        This is the process the leftover items in stack as we are only computing area when item is popped.
        For all these items, the next small becomes array length because they don't have next small in the array that's why they are still in stack and not popped.
        Remember we are doing the same array length if next small is not available in better solutions also.
            Refer: com.narendra.stack.LargestRectangleAreaInAHistogramBetter.getNextSmall
         */
        while (!stack.isEmpty()) {
            int index = stack.pop();
            int ns = heights.length;
            int ps = stack.isEmpty() ? -1: stack.peek();
            int currentArea = (ns - ps - 1) * heights[index];
            System.out.println("Area of Index:" +index + " is:" + currentArea);
            largestArea = Math.max(largestArea, currentArea);
        }
        return largestArea;
    }

}
