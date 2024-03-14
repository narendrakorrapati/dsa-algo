package com.narendra.string;

public class LongestSubstringWithDistinctCharsNaive {

    public static void main(String[] args) {
        String str = "abcdabc";
        System.out.println(getLongestSubstringNaive(str));
    }

    private static int getLongestSubstringNaive(String str) {

        //Time: O(N * N)
        //Space O(CHAR)
        int maxLen = 0;

        for (int i = 0; i < str.length(); i++) {
            int currLen = 0;
            int[] count = new int[256];
            int j;
            for (j = i; j < str.length(); j++) {
                if(count[str.charAt(j)] == 0) {
                    count[str.charAt(j)] = 1;
                    currLen++;
                } else {
                    break;
                }
            }

            if(currLen >= maxLen) {
                maxLen = currLen;
                System.out.println("Max length as of now:" + (i) + "," + (j-1));
            }
        }

        return maxLen;
    }
}
