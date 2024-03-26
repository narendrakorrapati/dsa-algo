package com.narendra.stack;

import java.util.Stack;

public class StackWithGetMinConstantSpaceOnlyPositiveSupported {

    public static void main(String[] args) {
        MyGetMinStackPositive stackPositive = new MyGetMinStackPositive();
        stackPositive.push(5);
        stackPositive.push(10);
        stackPositive.push(20);
        System.out.println(stackPositive.getMin());
        stackPositive.push(2);
        System.out.println(stackPositive.getMin());
        stackPositive.push(6);
        stackPositive.push(4);
        System.out.println(stackPositive.pop());
        System.out.println(stackPositive.pop());
        stackPositive.push(2);
        System.out.println(stackPositive.getMin());
        System.out.println(stackPositive.pop());
        stackPositive.push(1);
        System.out.println(stackPositive.getMin());
        System.out.println(stackPositive.pop());
        System.out.println(stackPositive.pop());
    }
}

class MyGetMinStackPositive {

    Stack<Integer> stack;
    Integer min = 0;

    MyGetMinStackPositive() {
        stack = new Stack<>();
    }

    void push(Integer x) {
        if(stack.isEmpty()) {
            min = x;
        }
        if(x > min) {
            stack.push(x);
        } else {
            stack.push(x - min);
            min = x;
        }
    }

    Integer pop() {
        int temp = min;
        Integer data = stack.pop();
        if(data <= 0) {
            min = min - data;
            return temp;
        }
        return data;
    }

    Integer peek() {
        int data = stack.peek();
        if(data < 0) {
            return min;
        }
        return data;
    }

    Integer getMin() {
        return min;
    }
}
