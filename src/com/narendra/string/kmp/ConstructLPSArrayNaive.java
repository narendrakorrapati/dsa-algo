package com.narendra.string.kmp;

import java.util.Arrays;

public class ConstructLPSArrayNaive {
    public static void main(String[] args) {
        String str = "abacaba";
        int[] lps = getLPSArray(str);
        System.out.println(Arrays.toString(lps));
    }

    private static int[] getLPSArray(String str) {

        int[] lps = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            lps[i] = FindLPSOfAStringNaive.findLPSNaive(str, i+1);
        }
        return lps;
    }
}
