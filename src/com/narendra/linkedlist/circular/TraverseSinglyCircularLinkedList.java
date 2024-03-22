package com.narendra.linkedlist.circular;

public class TraverseSinglyCircularLinkedList {

    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        Node temp3 = new Node(40);

        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = head;

        Node curr = head;
        printSCLL(head);

    }

    private static void printSCLL(Node head) {

        if(head == null) {
            return;
        }
        //Using do while loop, Method 1
        Node curr = head;
        do {
            System.out.print(curr.value + " ");
            curr = curr.next;
        } while(curr != head);


        //Using for loop Method 2
        System.out.println();
        System.out.print(head.value + " ");
        for (Node c = head.next; c !=head ; c= c.next) {
            System.out.print(c.value + " ");
        }
    }
}
