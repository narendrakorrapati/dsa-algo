package com.narendra.linkedlist.singly;

public class RemoveTheGivenNodeReference {

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
        temp4.next = null;

        Node.print(head);
        System.out.println();
        removeTheNode(temp3); //Assuming last node won't be asked to remove.

        Node.print(head);
    }

    private static void removeTheNode(Node ptr) {
        ptr.value = ptr.next.value;
        ptr.next =  ptr.next.next;
    }
}
