package com.narendra.stack;

import java.util.ArrayDeque;

public class EvaluatePrefix {

    public static void main(String[] args) {
        System.out.println(evaluatePrefix("+ * 10 2 3"));
        System.out.println(evaluatePrefix("^ 10 ^ 2 3"));

        System.out.println(evaluatePrefix1("*+235"));
        System.out.println(evaluatePrefix1("^5^23"));

    }

    private static long evaluatePrefix(String postfix) {

        ArrayDeque<Long> stack = new ArrayDeque<>();
        String[] postfixArray = postfix.split(" ");

        for (int i = postfixArray.length-1; i >=0; i--) {
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
                    stack.push((long)Math.pow(stack.pop(), stack.pop()));
                    break;

                default:
                    stack.push(Long.valueOf(curr));
            }
        }
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public static int evaluatePrefix1(String S)
    {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = S.length()-1; i >=0 ; i--) {
            char curr = S.charAt(i);

            if (Character.isDigit(curr)) {
                stack.push(Integer.valueOf(String.valueOf(curr)));
            } else {

                int op1 = stack.pop();
                int op2 = stack.pop();
                int result = 0;

                switch (curr) {
                    case '*':
                        result = op1 * op2;
                        break;

                    case '/':
                        result = op1 / op2;
                        break;

                    case '+':
                        result = op1 + op2;;
                        break;

                    case '-':
                        result = op1 - op2;;
                        break;

                    case '^':
                        result = (int)Math.pow(op1,op2);
                        break;
                }

                stack.push(result);
            }

        }
        return stack.isEmpty() ? -1 : stack.peek();
    }
}
