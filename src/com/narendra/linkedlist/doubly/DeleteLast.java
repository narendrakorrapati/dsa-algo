package com.narendra.linkedlist.doubly;

public class DeleteLast {

    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        head.next = temp1;
        temp1.prev = head;
        temp1.next = temp2;
        temp2.prev = temp1;

        Node.print(head);

        head = deleteLast(head);
        Node.print(head);
    }

    private static Node deleteLast(Node head) {

        if(head == null || head.next == null) {
            return null;
        }
        Node temp = head;
        while(temp.next.next!=null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }
}
