package com.narendra.string;

public class NaivePatternSearching {

    public static void main(String[] args) {
        //String txt = "ABABABCD";
        //String pat = "ABAB";
        String txt = "AAAAA";
        String pat = "AAA";
        printPatternMatches1(txt, pat);//Using sliding window, tracking the end position of window.
        System.out.println();
        printPatternMatches2(txt, pat);//Using sliding window, tracking the start position of window.
    }

    private static void printPatternMatches2(String txt, String pat) {

        int n=txt.length();
        int m=pat.length();

        for (int i = 0; i < n-m+1; i++) {
            if(compare(txt, pat, i)) {
                System.out.print(i + " ");
            }
        }
    }

    private static void printPatternMatches1(String txt, String pat) {

        int k = pat.length();
        if(compare(txt, pat, 0)) {
            System.out.print(0 + " ");
        }

        for (int i = k; i < txt.length(); i++) {
            int start = i-k+1;
            if(compare(txt, pat, start)) {
                System.out.print(start + " ");
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
