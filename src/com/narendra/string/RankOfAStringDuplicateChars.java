package com.narendra.string;

/**
 * This implementation works for both distinct and duplicate chars in the string.
 * There is a trick to find out the rank of a string.
 * Video reference: https://www.youtube.com/watch?v=heIyggvmMAA&list=PL7rZUH8srnuOviOctDtTG3z8vhwwtajf3
 */

public class RankOfAStringDuplicateChars {

    public static void main(String[] args) {
        //String str = "DCAB";
        //String str = "STRING";
        String str = "SUCCESS";
        System.out.println(getRank(str));
    }

    private static int getRank(String str) {

        int n = str.length();
        int[] count = new int[256];
        int[] fact = new int[n];
        int rank = 0;

        for (int i = 0; i < n; i++) {
            count[str.charAt(i)]++;
        }

        fact[1] = 1;
        //Instead of saving all factorials of each number, we can compute factorial of n and find out the factorial of needed index using factorial/(n-i);
        //This needs a restructure of getCountAndDivisor method.
        for (int i = 2; i < n; i++) {
            fact[i] = fact[i-1] * i;
        }

        for (int i = 0; i < n; i++) {
            //For each char, get the count of smaller chars right to it and the duplicate chars permutations.
            int[] temp = getCountAndDivisor(count, fact, str.charAt(i));
            rank = rank + (temp[0] * (fact[n-i-1]/temp[1]));
        }

        return rank + 1;
    }

    /**
     * Return the count of smaller chars right to given char and also return the duplicate char permutations count to reduce from overall count.
     * For example: str = "SUCCESS". For letter at index 0 'S', this function returns
     * {3, (3! * 2!)}
     * index 0, count of smaller chars right to given char
     * index 1, factorial of repeated chars to divide with overall permutations.
     * 3 * (6!/(3! * 2!))
     * @param count
     * @param fact
     * @param c
     * @return
     */
    private static int[] getCountAndDivisor(int[] count, int[] fact, char c) {

        int lessThanCount = 0;
        int divisor = 1;
        for (int i = 0; i < c; i++) {
            lessThanCount = lessThanCount + count[i];
            divisor = divisor * fact[count[i] == 0? 1: count[i]];
        }
        divisor = divisor * fact[count[c]];
        count[c]--;//Reduce the count of already processed char.
        return new int[] {lessThanCount, divisor};
    }
}
