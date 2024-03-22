package com.narendra.linkedlist.circular;

public class CircularNode {

    int value;
    CircularNode next;
    CircularNode prev;

    public CircularNode(int value) {
        this.value = value;
    }

    public static void print(CircularNode head) {
        if(head == null) {
            return;
        }
        CircularNode curr = head;
        do {
            System.out.print(curr.value + " ");
            curr = curr.next;
        } while(curr != head);

    }
}
