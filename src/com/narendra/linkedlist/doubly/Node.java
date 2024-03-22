package com.narendra.linkedlist.doubly;

public class Node {
    int value;
    com.narendra.linkedlist.doubly.Node next;
    com.narendra.linkedlist.doubly.Node prev;

    public Node(int value) {
        this.value = value;
    }

    static public void print(Node head) {
        Node curr = head;
        System.out.println("Left to right");
        while (curr!=null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
        System.out.println();
    }

}
