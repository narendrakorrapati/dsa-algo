package com.narendra.stack;

import java.util.ArrayList;

public class StackWithArrayList {

    public static void main(String[] args) {
        MyStackArrayList stack = new MyStackArrayList();

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

class MyStackArrayList {
    ArrayList<Integer> list = new ArrayList<>();

    void push(int data) {
        list.add(data);
    }

    int pop() {
        return list.remove(list.size()-1);
    }

    int peek() {
        return list.get(list.size()-1);
    }

    int size() {
        return list.size();
    }

    boolean isEmpty() {
        return list.isEmpty();
    }
}
