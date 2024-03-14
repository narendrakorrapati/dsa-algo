package com.narendra.string.kmp;

import java.util.ArrayList;

public class FindLPSOfAStringNaive {

    public static void main(String[] args) {
        //String str = "abacaba";
        //String str = "aaaaad";
        String str = "abcabdabcabcabd";
        int lps = findLPSNaive(str, str.length());
        System.out.println(lps);

        lps = findLPSBruteForce(str);//Extra space
        System.out.println(lps);
    }

    private static int findLPSBruteForce(String str) {

        ArrayList<String> prefixes = new ArrayList<>();
        ArrayList<String> suffixes = new ArrayList<>();

        prefixes.add("");
        suffixes.add("");

        int lps = 0;

        for (int i = 0; i < str.length()-1; i++) {
            prefixes.add(prefixes.get(i) + str.charAt(i));
        }

        for (int i = str.length()-1; i >0 ; i--) {
            suffixes.add(str.charAt(i) + suffixes.get(str.length()-1-i));
        }

        for (int i = 0; i < prefixes.size(); i++) {
            if(prefixes.get(i).equals(suffixes.get(i))) {
                lps = i;
            }
        }

        return lps;
    }

    public static int findLPSNaive(String str, int n) {

        for (int i = 1; i < n; i++) {
            int prefix = 0;
            int suffix = i;
            int lps = 0;
            boolean flag = true;

            while(suffix < n) {
                if(str.charAt(prefix) != str.charAt(suffix)) {
                    flag = false;
                    break;
                } else {
                    prefix ++;
                    suffix ++;
                    lps++;
                }
            }
            if(flag) {
                return lps;
            }
        }
        return 0;
    }
}
