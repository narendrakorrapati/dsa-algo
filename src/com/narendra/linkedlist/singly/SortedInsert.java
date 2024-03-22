package com.narendra.linkedlist.singly;

public class SortedInsert {

    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        Node temp3 = new Node(40);

        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;

        Node.print(head);
        System.out.println();
        head = sortedInsert(head, 25);
        Node.print(head);
        System.out.println();
        head = sortedInsert(head, 50);
        Node.print(head);

        System.out.println();
        head = sortedInsert(head, 5);
        Node.print(head);
    }

    private static Node sortedInsert(Node head, int value) {
        Node newNode = new Node(value);
        if(head == null) {
            return newNode;
        }

        if(value < head.value) {
            newNode.next = head;
            return newNode;
        }

        Node curr = head;
        while(curr.next !=null && curr.next.value < value) {
            curr = curr.next;
        }

        newNode.next = curr.next;
        curr.next = newNode;

        return head;
    }
}
