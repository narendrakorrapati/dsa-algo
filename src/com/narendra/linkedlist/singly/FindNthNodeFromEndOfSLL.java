package com.narendra.linkedlist.singly;

public class FindNthNodeFromEndOfSLL {

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

        printNthNodeMethod1(head, 5);
        printNthNodeMethod2(head, 5);
    }

    private static void printNthNodeMethod2(Node head, int n) {

        /*
        int count = 0;

        Node first = head;
        while(first!= null && count!=n) {
            first = first.next;
            count ++;
        }*/
        Node first = head;
        for(int count = 1; count<=n; count ++) {
            if(first == null) {
                return;
            }
            first = first.next;
        }

        Node second = head;
        while (first!=null) {
            first = first.next;
            second = second.next;
        }
        System.out.println(second.value);
    }

    private static void printNthNodeMethod1(Node head, int n) {

        if(head == null) {
            return;
        }

        int size = 1;
        Node curr = head;

        while(curr.next != null) {
            size ++;
            curr = curr.next;
        }

        int nodeNumFromBeginning = size - n + 1;

        if(nodeNumFromBeginning <= 0) {
            return;
        }

        int count = 1;
        curr = head;
        while(count != nodeNumFromBeginning) {
            count ++;
            curr = curr.next;
        }
        System.out.println(curr.value);

    }
}
