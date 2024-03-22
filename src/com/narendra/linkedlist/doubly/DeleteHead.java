package com.narendra.linkedlist.doubly;

public class DeleteHead {

    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        head.next = temp1;
        temp1.prev = head;
        temp1.next = temp2;
        temp2.prev = temp1;

        Node.print(head);
        System.out.println();
        head = deleteHead(head);
        Node.print(head);

        Node.print(deleteHead(null));

        head = deleteHead(head);
        Node.print(head);
        Node.print(deleteHead(head));
    }

    private static Node deleteHead(Node head) {

        if(head == null || head.next == null) {
            return null;
        }

        Node temp = head.next;
        temp.prev = null;

        return temp;
    }
}
