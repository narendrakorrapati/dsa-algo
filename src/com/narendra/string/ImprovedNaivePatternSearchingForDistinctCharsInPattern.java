package com.narendra.string;

public class ImprovedNaivePatternSearchingForDistinctCharsInPattern {

    public static void main(String[] args) {
//        String txt = "ABCABCDABCD";
//        String pat = "ABCD";
        String txt = "GEEKSFORGEEKS";
        String pat = "EKS";
        printPatternMatches(txt, pat);
    }

    private static void printPatternMatches(String txt, String pat) {

        int n=txt.length();
        int m=pat.length();

        for (int i = 0; i < n-m+1;) {

            int j;
            for (j = 0; j < m; j++) {
                if(pat.charAt(j) != txt.charAt(j + i)) {
                    break;
                }
            }
            if(j == m) {
                System.out.print(i + " ");
            }

            if(j == 0) {
                i++;
            } else {
                i = (i+j);
            }
        }
    }
    private static boolean compare(String txt, String pat, int start) {

        for (int j = 0; j < pat.length(); j++) {
            if(txt.charAt(start + j) != pat.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
