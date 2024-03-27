package com.narendra.queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithTwoQueues {

    public static void main(String[] args) {

        StackWithTwoQueues stack = new StackWithTwoQueues();

        stack.push(78);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push(93);
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push(28);
        stack.push(60);
        System.out.println(stack.pop());
        stack.push(41);
        stack.push(73);
        stack.push(12);
        stack.push(68);
        System.out.println(stack.pop());
    }

    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    //Function to push an element into stack using two queues.
    void push(int a)
    {
        q1.add(a);
    }

    //Function to pop an element from stack using two queues.
    int pop()
    {
        if(q1.size() == 0) {
            return -1;
        }

        for(int i=0; i<q1.size()-1; i++) {
            q2.add(q1.remove());
        }

        int data = q1.remove();

        while(!q2.isEmpty()) {
            q1.add(q2.remove());
        }

        return data;

    }
}
