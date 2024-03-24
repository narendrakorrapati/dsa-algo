package com.narendra.stack;

public class StackWithSinglyLL {
    public static void main(String[] args) {
        MyStackSLL stack = new MyStackSLL();

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

class MyStackSLL {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;
    int size = 0;
    void push(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        size ++;
    }

    int pop() {
        if(head == null) {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }
        int data = head.data;
        head = head.next;
        size--;
        return data;
    }

    int peek() {
        if(head == null) {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }

        return head.data;
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return size != 0;
    }
}
