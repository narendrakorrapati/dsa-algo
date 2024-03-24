package com.narendra.stack;

import java.util.ArrayDeque;

/*
https://www.geeksforgeeks.org/batch/dsa-self-paced/track/DSASP-Stack/problem/parenthesis-checker2744
 */
public class BalancedParenthesisChecker {

    public static void main(String[] args) {
        System.out.println(ispar("{([])}"));
        System.out.println(ispar("([]"));
    }

    static boolean ispar(String x)
    {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(int i=0; i<x.length(); i++) {
            char ch = x.charAt(i);

            if('[' == ch || '(' == ch || '{' == ch) {
                stack.push(ch);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                if((ch == ']' && stack.peek() == '[')
                        || (ch == ')' && stack.peek() == '(')
                        || (ch == '}' && stack.peek() == '{')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
