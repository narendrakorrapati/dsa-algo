package com.narendra.linkedlist.singly;

public class RotateSLL {

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next.next = new Node(8);

        Node.print(head1);
        System.out.println();
        head1 = rotate(head1, 4);
        Node.print(head1);
        System.out.println();
    }

    public static Node rotate(Node head, int k) {

        Node curr = head;

        while(curr.next!=null) {
            curr = curr.next;
        }

        Node tail = curr;
        curr = head;

        while(k!=0) {
            tail.next = curr;
            curr = curr.next;
            tail = tail.next;
            tail.next = null;
            k--;
        }

        return curr;
    }
}
