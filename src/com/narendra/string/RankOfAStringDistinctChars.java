package com.narendra.string;

public class RankOfAStringDistinctChars {

    public static void main(String[] args) {
        //String str = "DCAB";
        String str = "STRING";
        System.out.println(getRank(str));
    }

    private static int getRank(String str) {

        int n = str.length();
        int[] count = new int[256];
        int[] fact = new int[n];
        int rank = 0;

        for (int i = 0; i < n; i++) {
            count[str.charAt(i)] = 1;
        }

        fact[1] = 1;

        for (int i = 2; i < n; i++) {
            fact[i] = fact[i-1] * i;
        }

        for (int i = 0; i < n; i++) {
            rank = rank + (fact[n-i-1] * getCount(count, str.charAt(i)));
        }

        return rank + 1;
    }

    private static int getCount(int[] count, char c) {

        int lessThanCount = 0;

        for (int i = 0; i < c; i++) {
            lessThanCount = lessThanCount + count[i];
        }
        count[c] = 0;
        return lessThanCount;
    }
}
