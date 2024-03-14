package com.narendra.string;

import java.util.Arrays;

public class ReverseWordsInaString {

    public static void main(String[] args) {
        String str = "Welcome to gfg";
        //String str = "abc";
        str = reverseWordsNaive(str);
        System.out.println(str);

        char[] array = "Welcome to gfg".toCharArray();
        reverseWordsEfficient(array);
        System.out.println(new String(array));
    }

    private static void reverseWordsEfficient(char[] str) {

        int start = 0;
        int end = 0;

        while(end < str.length) {
            if(str[end] == ' ') {
                reverse(str, start, end-1);
                start = end + 1;
            }
            end ++;
        }
        reverse(str, start, str.length-1);
        reverse(str, 0, str.length-1);
    }

    private static void reverse(char[] str, int start, int end) {

        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start ++;
            end --;
        }
    }

    private static String reverseWordsNaive(String str) {

        int start = str.length()-1;
        int end = str.length()-1;
        StringBuilder result = new StringBuilder(str.length());

        while(start >=0) {
            if(str.charAt(start) == ' ') {
                append(str, result, start + 1, end);
                result.append(" ");
                start--;
                end = start;
            } else {
                start --;
            }
            if(start == 0) {
                append(str, result, start, end);
                break;
            }
        }

        return result.toString();
    }

    private static void append(String str, StringBuilder result, int start, int end) {

        for (int i = start; i <= end; i++) {
            result.append(str.charAt(i));
        }
    }
}
