package com.narendra.string;

public class CheckAStringIsSubsequenceOfOther {

    public static void main(String[] args) {
        String str1 = "ABCD";
        String str2 = "AD";
        //String str1 = "ABCDE";
        //String str2 = "AED";
        System.out.println(isSubsequence(str1, str2));
        System.out.println(isSubsequenceRecursive(str1, str2, 0, 0));

    }

    private static boolean isSubsequenceRecursive(String str1, String str2, int i, int j) {

        if(str2.length() == j) {
            return true;
        }
        if(str1.length() == i) {
            return false;
        }
        if(str1.charAt(i) == str2.charAt(j)) {
            return isSubsequenceRecursive(str1, str2, i+1, j+1);
        } else {
            return isSubsequenceRecursive(str1, str2, i+1, j);
        }
    }

    private static boolean isSubsequence(String str1, String str2) {

        int i = 0;
        int j = 0;

        while(i < str1.length() && j < str2.length()) {

            if(str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }

        return j == str2.length();

    }
}
