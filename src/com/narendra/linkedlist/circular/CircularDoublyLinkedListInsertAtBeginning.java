package com.narendra.linkedlist.circular;

public class CircularDoublyLinkedListInsertAtBeginning {

    public static void main(String[] args) {
        CircularNode head = new CircularNode(10);
        CircularNode temp1 = new CircularNode(20);
        CircularNode temp2 = new CircularNode(30);

        head.next = temp1;
        temp1.next = temp2;
        temp2.next = head;

        head.prev = temp2;
        temp1.prev = head;
        temp2.prev = temp1;

        CircularNode.print(head);

        System.out.println();
        head = insertAtBeginning(head, 5);
        CircularNode.print(head);
    }

    private static CircularNode insertAtBeginning(CircularNode head, int value) {
        CircularNode newNode = new CircularNode(value);
        if(head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
        }

        newNode.next = head;
        newNode.prev = head.prev;
        head.prev = newNode;
        newNode.prev.next = newNode;

        return newNode;
    }
}
