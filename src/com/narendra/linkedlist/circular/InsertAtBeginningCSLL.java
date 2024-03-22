package com.narendra.linkedlist.circular;

public class InsertAtBeginningCSLL {

    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);

        head.next = temp1;
        temp1.next = temp2;
        temp2.next = head;

        head = insertAtBeginning(head, 15);
        Node.print(head);

        System.out.println();

        Node head2 = new Node(10);
        head2.next = head2;
        head2 = insertAtBeginning(head2, 3);
        Node.print(head2);

        Node head3 = new Node(10);
        Node temp13 = new Node(30);
        Node temp23 = new Node(20);
        head3.next = temp13;
        temp13.next = temp23;
        temp23.next = head3;
        System.out.println();
        head3 = insertAtBeginningEfficient(head3, 15);
        Node.print(head3);
    }

    private static Node insertAtBeginningEfficient(Node head, int value) {
        Node newNode = new Node(value);
        if(head == null) {
            newNode.next = newNode;
            return newNode;
        }
        newNode.next = head.next;
        head.next = newNode;

        int temp = head.value;
        head.value = head.next.value;
        head.next.value = temp;

        return head;
    }

    private static Node insertAtBeginning(Node head, int value) {
        Node newNode = new Node(value);
        if(head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }

        curr.next = newNode;
        newNode.next = head;
        return newNode;
    }
}
