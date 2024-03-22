package com.narendra.linkedlist.circular;

public class DeleteHeadOfCircularSLL {

    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        Node temp3 = new Node(40);

        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = head;

        head = deleteHeadNaive(head);
        Node.print(head);

        System.out.println();

        Node head3 = new Node(10);
        Node temp13 = new Node(30);
        Node temp23 = new Node(20);
        head3.next = temp13;
        temp13.next = temp23;
        temp23.next = head3;

        head3 = deleteHeadEfficient(head3);
        Node.print(head3);
    }

    private static Node deleteHeadEfficient(Node head) {
        if(head == null || head.next == head) {
            return null;
        }

        head.value = head.next.value;
        head.next = head.next.next;
        return head;
    }

    private static Node deleteHeadNaive(Node head) {
        if(head == null || head.next == head) {
            return null;
        }

        Node curr = head;

        while(curr.next != head) {
            curr = curr.next;
        }

        curr.next = head.next;
        head.next = head.next.next;

        return head.next;
    }
}
