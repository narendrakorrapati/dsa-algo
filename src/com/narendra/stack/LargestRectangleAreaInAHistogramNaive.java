package com.narendra.stack;

public class LargestRectangleAreaInAHistogramNaive {

    public static void main(String[] args) {
        int[] height = new int[]{6, 2, 5, 4, 1, 5, 6};
        int largestArea = getLargestArea(height);
        System.out.println(largestArea);
    }

    private static int getLargestArea(int[] height) {

        int largestArea = 0;

        for (int i = 0; i < height.length; i++) {
            int currentArea = height[i];

            for(int j=i-1; j>=0; j--) {
                if(height[j] >= height[i]) {
                    currentArea = currentArea + height[i];
                } else {
                    break;
                }
            }

            for(int j=i+1; j<height.length; j++) {
                if(height[j] >= height[i]) {
                    currentArea = currentArea + height[i];
                } else {
                    break;
                }
            }
            largestArea = Math.max(largestArea, currentArea);
        }

        return largestArea;
    }
}
