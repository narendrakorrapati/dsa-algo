package com.narendra.linkedlist.singly;

public class RemoveDuplicatesFromSLL {

    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(20);
        Node temp3 = new Node(30);
        Node temp4 = new Node(30);
        Node temp5 = new Node(30);

        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        temp4.next = temp5;

        Node.print(head);
        System.out.println();
        removeDuplicates(head);
        Node.print(head);

    }

    private static void removeDuplicates(Node head) {

        if(head == null) {
            return;
        }
        Node curr = head;
        while (curr.next!=null) {
            if(curr.value == curr.next.value) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
    }

}
