package com.narendra.queue;

import java.util.Stack;

public class QueueWithTwoStacks {


    public static void main(String[] args) {
        QueueWithTwoStacks queue = new QueueWithTwoStacks();
        queue.push(20);
        queue.push(25);

        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }

    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    //Function to push an element in queue by using 2 stacks.
    void push(int x)
    {
        s1.push(x);
    }


    //Function to pop an element from queue by using 2 stacks.
    int pop()
    {
        if(s1.isEmpty()) {
            return -1;
        }

        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        int data = s2.pop();

        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return data;

    }
}
