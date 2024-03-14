package com.narendra.string;

public class RabinKarpPatternSearchAlgorithm {

    public static void main(String[] args) {
        String txt = "abdabcbabc";
        String pat = "abc";
        printMatchesSimple(txt, pat);
        System.out.println();
        printMatchesWeightedSum(txt, pat);
        System.out.println();
        printMatchesWeightedSumModulo(txt, pat);
        System.out.println();
    }

    private static void printMatchesWeightedSumModulo(String txt, String pat) {
        int n=txt.length();
        int m=pat.length();
        int t=0;
        int p=0;
        int d=256;
        int q=101;
        int h=1;

        //This should run for m-1 times. m = 3, run for 2 times.
        //1. Compute pow(d, m-1) under modulo
        for (int i = 1; i < m; i++) {
            h = (h*d) % q;
        }

        //2. Compute p and (t0) under modulo using Horner's algorithm.
        for (int i = 0; i < m; i++) {

            t = (t*d + txt.charAt(i)) % q;
            p = (p*d + pat.charAt(i)) % q;
        }

        for (int i = 0; i < n-m+1; i++) {
            //3. Check for spurious hit
            if(t == p) {
                int j;
                for (j = 0; j < m; j++) {
                    if(pat.charAt(j) != txt.charAt(i+j)) {
                        break;
                    }
                }
                if(j == m) {
                    System.out.print(i + " ");
                }
            }
            if(i+m < n) {
                //4. Compute hash for next window under modulo
                t = ((d * (t - txt.charAt(i) * h)) + txt.charAt(i+m)) % q;
                //5. If t < 0, we need to get positive value as p is positive always.
                if(t<0) {
                    t = t + q;
                }
            }
        }
    }

    private static void printMatchesWeightedSum(String txt, String pat) {

        int n=txt.length();
        int m=pat.length();
        int t=0;
        int p=0;
        int d=5;

        for (int i = 0; i < m; i++) {
            t = t + txt.charAt(i) * (int)Math.pow(d, m-1-i);
            p = p + pat.charAt(i) * (int)Math.pow(d, m-1-i);
        }

        for (int i = 0; i < n-m+1; i++) {
            if(t == p) {
                int j;
                for (j = 0; j < m; j++) {
                    if(pat.charAt(j) != txt.charAt(i+j)) {
                        break;
                    }
                }
                if(j == m) {
                    System.out.print(i + " ");
                }
            }
            if(i+m < n) {
                t = d * (t - txt.charAt(i) * (int)Math.pow(d, m-1)) + txt.charAt(i+m);
            }
        }

    }

    private static void printMatchesSimple(String txt, String pat) {
        int n=txt.length();
        int m=pat.length();
        int t=0;
        int p=0;

        for (int i = 0; i < m; i++) {
            t = t + txt.charAt(i);
            p = p + pat.charAt(i);
        }

        for (int i = 0; i < n-m+1; i++) {
            if(t == p) {
                int j;
                for (j = 0; j < m; j++) {
                    if(pat.charAt(j) != txt.charAt(i+j)) {
                        break;
                    }
                }
                if(j == m) {
                    System.out.print(i + " ");
                }
            }
            if(i+m < n) {
                t = t - txt.charAt(i) + txt.charAt(i+m);
            }
        }
    }
}
