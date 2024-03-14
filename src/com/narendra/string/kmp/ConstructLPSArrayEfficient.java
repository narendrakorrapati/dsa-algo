package com.narendra.string.kmp;

import java.util.Arrays;

public class ConstructLPSArrayEfficient {

    public static void main(String[] args) {

        String str = "ABCABDABCABCABD";
        int[] lps = getLPS(str);
        System.out.println(Arrays.toString(lps));
    }

    public static int[] getLPS(String str) {

        int[] lps = new int[str.length()];
        int length = 0;
        int i = 1;

        while(i < str.length()) {

            if(str.charAt(length) == str.charAt(i)) {
                lps[i] = length + 1;
                length++;
                i++;
            } else {
                if(length == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    length = lps[length-1];
                }
            }
        }

        return lps;
    }
}
