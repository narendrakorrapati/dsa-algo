package com.narendra.linkedlist.doubly;

public class InsertAtEnd {

    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        head.next = temp1;
        temp1.prev = head;
        temp1.next = temp2;
        temp2.prev = temp1;

        head = insertAtEnd(head, 40);

        Node.print(head);
        Node.print(insertAtEnd(null, 99));
    }

    public static Node insertAtEnd(Node head, int data) {
        Node newNode = new Node(data);

        if(head == null) {
            return newNode;
        }
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;

        return head;
    }
}
