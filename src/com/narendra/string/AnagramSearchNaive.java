package com.narendra.string;

public class AnagramSearchNaive {

    public static void main(String[] args) {
        String txt = "geeksforgeeksforge";
        String pat = "frog";
        searchAnagram(txt, pat);
    }

    private static void searchAnagram(String txt, String pat) {

        int n = txt.length();
        int m = pat.length();

        for (int i = 0; i < n-m+1; i++) {
            if(isAnagram(txt, pat, i)) {
                System.out.println("Match found: " + i);
            }
        }
    }

    private static boolean isAnagram(String txt, String pat, int start) {

        int[] count = new int[256];

        for (int i = 0; i < pat.length(); i++) {
            count[pat.charAt(i)]++;
            count[txt.charAt(i + start)]--;
        }

        for (int i = 0; i < count.length; i++) {
            if(count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
