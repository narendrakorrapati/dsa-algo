package com.narendra.string;

public class BinaryString {

    public static void main(String[] args) {
        System.out.println(binarySubstring(3, "1111"));
    }

    public static int binarySubstring(int a, String str)
    {
        int count = -1;
        int res = 0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '1') {
                if(count == -1) {
                    count = 0;
                } else if(count == 0) {
                    count = 1;
                    res = count;
                } else {
                    count = count + 1;
                    res = res+count;
                }
            }
        }

        return res;
    }
}
