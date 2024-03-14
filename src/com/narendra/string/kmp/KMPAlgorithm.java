package com.narendra.string.kmp;

public class KMPAlgorithm {
    public static void main(String[] args) {
        String txt = "aaaaab";
        String pat = "aaab";
        printMatches(txt, pat);
    }

    private static void printMatches(String txt, String pat) {

        int i=0;
        int j=0;
        int n=txt.length();
        int m=pat.length();
        int lps[] = ConstructLPSArrayEfficient.getLPS(pat);

        while(i < n) {
            if(txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }

            if(j == m) {
                System.out.print(i-j + " ");
                j = lps[j-1];
            } else if(i<n && txt.charAt(i) != pat.charAt(j)){
                if(j == 0) {
                    i++;
                } else {
                    j = lps[j-1];
                }
            }
        }
    }
}
