package com.narendra.string.kmp;

public class AnagramSearchEfficient {

    public static void main(String[] args) {
        String txt = "geeksforgeeksforge";
        String pat = "frog";
        searchAnagram(txt, pat);
    }

    private static void searchAnagram(String txt, String pat) {

        int n = txt.length();
        int m = pat.length();

        int countT[] = new int[256];
        int countP[] = new int[256];

        for (int i = 0; i < m; i++) {
            countT[txt.charAt(i)]++;
            countP[pat.charAt(i)]++;
        }

        for (int i = m; i < n; i++) {

            if(equal(countP, countT)) {
                System.out.println("Match found: " + (i-m));
            }
            countT[txt.charAt(i-m)]--;
            countT[txt.charAt(i)]++;
        }
    }

    private static boolean equal(int[] countP, int[] countT) {

        for (int i = 0; i < countP.length; i++) {
            if(countP[i] != countT[i]) {
                return false;
            }
        }
        return true;
    }


}
