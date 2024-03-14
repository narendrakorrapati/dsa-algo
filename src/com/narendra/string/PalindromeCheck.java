package com.narendra.string;

public class PalindromeCheck {

    public static void main(String[] args) {
        String str = "ABCDCBA";
        //String str = "ABBA";
        //String str = "ABCA";
        //String str = "A";
        System.out.println(isPalindrome(str));
    }

    private static boolean isPalindrome(String str) {

        int i = 0;
        int j = str.length() - 1;

        while (i<j) {

            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
