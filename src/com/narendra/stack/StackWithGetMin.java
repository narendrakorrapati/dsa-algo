package com.narendra.stack;

import java.util.ArrayDeque;

public class StackWithGetMin {
    public static void main(String[] args) {

        GetMinStack stack = new GetMinStack();
        stack.push(5);
        stack.push(10);
        stack.push(4);
        System.out.println(stack.getMin());
        stack.push(2);
        stack.push(6);
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
    }
}

class GetMinStack {
    ArrayDeque<Integer> stack;

    ArrayDeque<Integer> minStack;

    GetMinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    void push(Integer x) {
        stack.push(x);
        if(minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    Integer pop() {
        Integer data = stack.pop();
        if(data.equals(minStack.peek())) {
            minStack.pop();
        }
        return data;
    }

    Integer getMin() {
        return minStack.peek();
    }
}
