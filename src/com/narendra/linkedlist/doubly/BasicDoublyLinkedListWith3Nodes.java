package com.narendra.linkedlist.doubly;

import java.util.LinkedList;

public class BasicDoublyLinkedListWith3Nodes {

    public static void main(String[] args) {

        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        head.next = temp1;
        temp1.prev = head;
        temp1.next = temp2;
        temp2.prev = temp1;

        Node curr = head;
        System.out.println("Left to right");
        while (curr!=null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
        System.out.println();

        curr = temp2;
        System.out.println("Right to left");
        while (curr!=null) {
            System.out.print(curr.value + " ");
            curr = curr.prev;
        }

    }
}


