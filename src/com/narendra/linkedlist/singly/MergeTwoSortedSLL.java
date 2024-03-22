package com.narendra.linkedlist.singly;

public class MergeTwoSortedSLL {

    public static void main(String[] args) {
        Node head1 = new Node(10);
        head1.next = new Node(15);
        head1.next.next = new Node(30);
        head1.next.next.next = new Node(60);
        head1.next.next.next.next = new Node(70);

        Node head2 = new Node(5);
        head2.next = new Node(10);
        head2.next.next = new Node(40);
        head2.next.next.next = new Node(60);
        head2.next.next.next.next = new Node(70);
        head2.next.next.next.next.next = new Node(75);

        System.out.println("Head1");
        Node.print(head1);

        System.out.println();
        System.out.println("Head2");
        Node.print(head2);

        System.out.println();
        System.out.println("Merged Head");

        Node head = merge(head1, head2);
        Node.print(head);

    }

    private static Node merge(Node head1, Node head2) {

        if(head1 == null) {
            return head2;
        }

        if(head2 == null) {
            return head1;
        }

        Node head;
        Node tail;
        Node a = head1;
        Node b = head2;

        if(a.value <= b.value) {
            head = head1;
            tail = head1;
            a = a.next;
        } else {
            head = head2;
            tail = head2;
            b = b.next;
        }

        while(a!=null && b!=null) {
            if(a.value <= b.value ) {
                tail.next = a;
                tail = a;
                a = a.next;
            } else {
                tail.next = b;
                tail = b;
                b = b.next;
            }
        }

        if(a == null) {
            tail.next = b;
        } else {
            tail.next = a;
        }

        return head;
    }
}
