package com.narendra.linkedlist.singly;

public class SegregateEvenAndOddNodesMethod2OneTraversal {

    public static void main(String[] args) {

        /*
        Node head = new Node(17);
        Node temp1 = new Node(15);
        Node temp2 = new Node(8);
        Node temp3 = new Node(12);
        Node temp4 = new Node(5);

        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        temp4.next = null; */

        /*
        Node head = new Node(8);
        Node temp1 = new Node(12);
        Node temp2 = new Node(10);

        head.next = temp1;
        temp1.next = temp2;
        temp2.next = null;
        */

        /*
        Node head = new Node(5);
        Node temp1 = new Node(13);
        Node temp2 = new Node(17);

        head.next = temp1;
        temp1.next = temp2;
        temp2.next = null;
        */

        Node head = new Node(7);
        Node temp1 = new Node(6);
        head.next = temp1;
        temp1.next = null;

        Node.print(head);
        System.out.println();
        head = segregate(head);
        Node.print(head);
    }

    private static Node segregate(Node head) {

        Node curr = head;
        Node es = null, ee = null, os = null, oe = null;

        while(curr!=null) {
            if(curr.value %2 != 0) {
                if(os == null) {
                    os = curr;
                } else {
                    oe.next = curr;
                }
                oe = curr;
            } else {
                if(es == null) {
                    es = curr;
                } else {
                    ee.next = curr;
                }
                ee = curr;
            }
            curr = curr.next;
        }

        if(es == null || os == null) {
            return head;
        }

        ee.next = os;
        oe.next = null;
        return es;
    }
}
