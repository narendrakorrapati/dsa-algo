package com.narendra.stack;

import java.util.ArrayDeque;

public class EvaluatePostfix {

    public static void main(String[] args) {
        System.out.println(evaluatePostfix("10 2 * 3 +"));
        System.out.println(evaluatePostfix("10 2 + 3 *"));
        System.out.println(evaluatePostfix("10 2 3 ^ ^"));

        System.out.println(evaluatePostFix1("231*+9-"));

    }

    private static long evaluatePostfix(String postfix) {

        ArrayDeque<Long> stack = new ArrayDeque<>();
        String[] postfixArray = postfix.split(" ");

        for (int i = 0; i < postfixArray.length; i++) {
            String curr = postfixArray[i];

            switch (curr) {
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;

                case "/":
                    stack.push(stack.pop() / stack.pop());
                    break;

                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;

                case "-":
                    stack.push(stack.pop() - stack.pop());
                    break;

                case "^":
                    long op1 = stack.pop();
                    long op2 = stack.pop();
                    stack.push((long)Math.pow(op2, op1));
                    break;

                default:
                    stack.push(Long.valueOf(curr));
            }
        }
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public static int evaluatePostFix1(String S)
    {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < S.length(); i++) {
            char curr = S.charAt(i);

            if (Character.isDigit(curr)) {
                stack.push(Integer.valueOf(String.valueOf(curr)));
            } else {

                int op1 = stack.pop();
                int op2 = stack.pop();
                int result = 0;

                switch (curr) {
                    case '*':
                        result = op2 * op1;
                        break;

                    case '/':
                        result = op2 / op1;
                        break;

                    case '+':
                        result = op2 + op1;
                        break;

                    case '-':
                        result = op2 - op1;
                        break;
                }

                stack.push(result);
            }

        }
        return stack.isEmpty() ? -1 : stack.peek();
    }
}
