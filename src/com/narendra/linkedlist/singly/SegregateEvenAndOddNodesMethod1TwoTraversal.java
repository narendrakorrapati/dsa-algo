package com.narendra.linkedlist.singly;

public class SegregateEvenAndOddNodesMethod1TwoTraversal {

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
        Node head = new Node(5);
        Node temp1 = new Node(13);
        Node temp2 = new Node(17);

        head.next = temp1;
        temp1.next = temp2;
        temp2.next = null;

        Node.print(head);
        System.out.println();
        head = segregate(head);
        Node.print(head);
    }

    private static Node segregate(Node head) {

        Node curr = head;
        Node last = null;
        int size = 0;
        while(curr!=null) {
            size++;
            last = curr;
            curr = curr.next;
        }

        int count = 0;
        curr = head;
        Node prevEvenNode = null;
        boolean isEvenFirst = false;
        while(count < size) {
            Node temp = curr.next;
            if(curr.value % 2 !=0) {
                last.next = curr;
                curr.next = null;
                last = curr;

                if(isEvenFirst) {
                    prevEvenNode.next = temp;
                }
            } else {
                if(!isEvenFirst) {
                    head = curr;
                    isEvenFirst = true;
                }
                prevEvenNode = curr;
            }
            curr = temp;
            count++;
        }

        if(!isEvenFirst) {
            return curr;
        }

        return head;
    }
}
