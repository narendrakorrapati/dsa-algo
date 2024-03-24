package com.narendra.stack;

public class StackWithSimpleArray {

    public static void main(String[] args) {

        MyStackWithArray stack = new MyStackWithArray(5);
        stack.push(5);
        stack.push(15);
        stack.push(25);

        System.out.println(stack.peek());
        System.out.println(stack.pop());

        stack.push(35);
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
    }
}

class MyStackWithArray {
    int top = -1;
    int cap;
    int[] arr;

    MyStackWithArray(int cap) {
        this.cap = cap;
        arr = new int[cap];
    }

    void push(int data) {
        if(top+1 == cap) {
            System.out.println("Stack is full");
            return;
        }
        arr[top+1] = data;
        top++;
    }

    int pop() {
        if(top == -1) {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }
        int data = arr[top];
        top--;
        return data;
    }

    int peek() {
        if(top==-1) {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }
        return arr[top];
    }

    int size() {
        return top+1;
    }

    boolean isEmpty() {
        return top == -1;
    }

}
