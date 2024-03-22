package com.narendra.linkedlist.singly;

public class MiddleOfSLL {

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

        //Odd numbers;
        printMiddleNaive(head);
        printMiddleEfficient(head);

        //Even numbers;
        temp3.next = null;
        printMiddleNaive(head);
        printMiddleEfficient(head);
    }

    private static void printMiddleEfficient(Node head) {

        if(head == null) {
            return;
        }
        Node slow = head;
        Node fast = head;

        while(fast !=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.value);

    }

    private static void printMiddleNaive(Node head) {
        if(head == null) {
            return;
        }

        int size = 0;
        Node curr = head;
        while(curr != null) {
            size ++;
            curr = curr.next;
        }

        int mid = (int) (double) (size / 2);

        int count = 0;
        curr = head;
        while(count != mid) {
            count ++;
            curr = curr.next;
        }
        System.out.println(curr.value);
    }
}
