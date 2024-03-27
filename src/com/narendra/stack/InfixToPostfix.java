package com.narendra.stack;

import java.util.*;

public class InfixToPostfix {

    private static final Map<Character, Integer> PRECEDENCE = new HashMap<>();
    private static final Set<Character> LEFT_TO_RIGHT = new HashSet<>();

    static {

        PRECEDENCE.put('+', 1);
        PRECEDENCE.put('-', 1);
        PRECEDENCE.put('*', 2);
        PRECEDENCE.put('/', 2);
        PRECEDENCE.put('^', 3);

        LEFT_TO_RIGHT.add('+');
        LEFT_TO_RIGHT.add('-');
        LEFT_TO_RIGHT.add('*');
        LEFT_TO_RIGHT.add('/');
    }
    public static void main(String[] args) {
        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(getPostfix(infix));
        System.out.println(getPostfix("A*(B+C)/D"));
    }

    private static String getPostfix(String infix) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder postfix = new StringBuilder(infix.length());

        for (int i = 0; i < infix.length(); i++) {
            char curr = infix.charAt(i);

            if((curr >= 97 && curr <= 122) || (curr >= 65 && curr <= 90)) {
                postfix.append(curr);
            } else if(curr == '(') {
                stack.push(curr);
            } else if(curr == ')') {
                while(stack.peek()!='(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            } else if(stack.isEmpty() || stack.peek() == '('
                    || PRECEDENCE.get(curr) > PRECEDENCE.get(stack.peek())) {
                stack.push(curr);
            } else { //curr <= top.
                while(!stack.isEmpty() && stack.peek()!= '('
                        && PRECEDENCE.get(curr) < PRECEDENCE.get(stack.peek())) { //curr < top
                    postfix.append(stack.pop());
                }

                if(!stack.isEmpty() &&
                        PRECEDENCE.get(curr) == PRECEDENCE.get(stack.peek())) { //curr == new top/current top
                    if(LEFT_TO_RIGHT.contains(curr)) {
                        postfix.append(stack.pop());
                    }
                }
                stack.push(curr);
            }
        }

        while(!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }
}
