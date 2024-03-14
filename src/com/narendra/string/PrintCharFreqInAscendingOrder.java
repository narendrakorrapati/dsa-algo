package com.narendra.string;

public class PrintCharFreqInAscendingOrder {

    public static void main(String[] args) {
        String name = "narendrakorrapati";
        printCharFreq(name);
    }

    private static void printCharFreq(String name) {

        int[] arr = new int[26]; //0-a, 1-b .... 24-y and 25-z

        for (int i = 0; i < name.length(); i++) {
            arr[name.charAt(i) - 'a'] ++;
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0)
                System.out.println((char)(i+'a') + " " + arr[i]);
        }
    }
}
