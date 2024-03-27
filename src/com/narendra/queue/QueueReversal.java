package com.narendra.queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueReversal {

    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();

        q.add(10);
        q.add(20);
        q.add(30);

        System.out.println(rev(q));
    }

    public static Queue<Integer> rev(Queue<Integer> q){

        Stack<Integer> stack = new Stack<>();

        while(!q.isEmpty()) {
            stack.push(q.remove());
        }

        while(!stack.isEmpty()) {
            q.add(stack.pop());
        }

        return q;
    }
}
