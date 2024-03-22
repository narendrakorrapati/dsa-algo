package com.narendra.linkedlist.circular;

public class Node {

    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
    static public void print(Node head) {
        if(head == null) {
            return;
        }
        Node curr = head;

        do {
            System.out.print(curr.value + " ");
            curr = curr.next;
        } while (curr != head);
    }
}
