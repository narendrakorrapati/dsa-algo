package com.narendra.linkedlist.singly;

public class RecursiveReverseInGroupsSLL {

    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        Node temp3 = new Node(40);

        Node temp4 = new Node(50);
        Node temp5 = new Node(60);
        Node temp6 = new Node(70);

        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;


        temp3.next = temp4;
        temp4.next = temp5;
        temp5.next = temp6;


        Node.print(head);
        System.out.println();
        head = reverseInGroups(head, 3);
        Node.print(head);
    }

    private static Node reverseInGroups(Node head, int k) {

        if(head == null) {
            return null;
        }

        Node curr = head;
        Node prev = null; //This is our new head of current group being reverse.
        Node next;
        int count = 0;
        while(curr !=null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count ++;
        }

        Node restHead = reverseInGroups(curr, k); //Head of next group;
        head.next = restHead; //Sect current group old head.next = next groups new head.

        return prev; //Current reversed group's new head.
    }
}
