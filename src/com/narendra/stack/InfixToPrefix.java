package com.narendra.stack;

import java.util.*;

public class InfixToPrefix {

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
        //String infix = "a+b*(c^d-e)^(f+g*h)-i";
        //System.out.println(getPrefix(infix));
        //System.out.println(getPrefix("A*(B+C)/D"));
        System.out.println(getPrefix("x+y*z"));
        System.out.println(getPrefix("x+y*(z-w)"));
        System.out.println(getPrefix("x^y^z"));
    }

    private static String getPrefix(String infix) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder prefix = new StringBuilder(infix.length());

        for (int i = infix.length()-1; i >=0; i--) {
            char curr = infix.charAt(i);

            if((curr >= 97 && curr <= 122) || (curr >= 65 && curr <= 90)) {
                prefix.append(curr);
            } else if(curr == ')') {
                stack.push(curr);
            } else if(curr == '(') {
                while(stack.peek()!=')') {
                    prefix.append(stack.pop());
                }
                stack.pop();
            } else if(stack.isEmpty() || stack.peek() == ')'
                    || PRECEDENCE.get(curr) > PRECEDENCE.get(stack.peek())) {
                stack.push(curr);
            } else { //curr <= top.
                while(!stack.isEmpty() && stack.peek()!= ')'
                        && PRECEDENCE.get(curr) < PRECEDENCE.get(stack.peek())) { //curr < top
                    prefix.append(stack.pop());
                }

                if(!stack.isEmpty() &&
                        PRECEDENCE.get(curr) == PRECEDENCE.get(stack.peek())) { //curr == new top/current top
                    if(!LEFT_TO_RIGHT.contains(curr)) {
                        prefix.append(stack.pop());
                    }
                }
                stack.push(curr);
            }
        }

        while(!stack.isEmpty()) {
            prefix.append(stack.pop());
        }

        return prefix.reverse().toString();
    }
}
