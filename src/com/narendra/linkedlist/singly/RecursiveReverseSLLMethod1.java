package com.narendra.linkedlist.singly;

public class RecursiveReverseSLLMethod1 {

    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        Node temp3 = new Node(40);
        Node temp4 = new Node(50);

        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;

        head = recursiveReverse(null, head);
        Node.print(head);
    }

    private static Node recursiveReverse(Node prev, Node curr) {

        if(curr == null) {
            return prev;
        }

        Node next = curr.next;
        curr.next = prev;
        return recursiveReverse(curr, next);
    }
}
