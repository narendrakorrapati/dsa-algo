package com.narendra.string;

public class LeftmostRepeatingCharacter {

    public static void main(String[] args) {
        String str = "narendrandrakorrapati";
        System.out.println(leftmostRepeatingChar(str));
    }

    private static int leftmostRepeatingChar(String str) {
        int[] count = new int[256];

        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)] ++;
        }

        for (int i = 0; i < str.length(); i++) {
            if(count[str.charAt(i)] > 1) {
                return i;
            }
        }

        return -1;
    }
}
