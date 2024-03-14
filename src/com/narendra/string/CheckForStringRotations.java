package com.narendra.string;

public class CheckForStringRotations {

    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "CDAB";

        System.out.println(isRotation(s1, s2));
    }

    private static boolean isRotation(String s1, String s2) {

        char[] s1Array = s1.toCharArray();

        for (int i = 0; i < s1.length()-1; i++) {
            rotate(s1Array);
            if(isEqual(s1Array, s2)) {
                System.out.println("Rotation: " + (i+1));
                return true;
            }
        }
        return false;
    }

    private static boolean isEqual(char[] s1Array, String s2) {

        for (int i = 0; i < s1Array.length; i++) {
            if(s1Array[i] != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private static void rotate(char[] s1Array) {

        char temp = s1Array[s1Array.length-1];
        for (int i = s1Array.length-1; i > 0; i--) {
            s1Array[i] = s1Array[i-1];
        }
        s1Array[0] = temp;
    }
}
