package com.narendra.linkedlist.doubly;

public class InsertAtBeginning {

    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        head.next = temp1;
        temp1.prev = head;
        temp1.next = temp2;
        temp2.prev = temp1;

        head = insertAtBeginning(head, 5);

        Node.print(head);
        Node.print(insertAtBeginning(null, 99));
    }

    static public Node insertAtBeginning(Node head, int data) {

        Node newNode = new Node(data);
        newNode.next = head;
        if(head !=null) {
            head.prev = newNode;
        }
        return newNode;
    }
}
