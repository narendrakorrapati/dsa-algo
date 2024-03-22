package com.narendra.linkedlist.singly;

public class ReverseSLL {

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

        head = reverse(head);
        Node.print(head);

        System.out.println();

        head = reverseNaive(head);
        Node.print(head);

    }

    private static Node reverseNaive(Node head) {
        if(head == null) {
            return null;
        }

        int size = 1;
        Node curr = head;
        while(curr.next!=null) {
            size++;
            curr = curr.next;
        }

        int[] arr = new int[size];
        curr = head;
        for(int i=0; i<size; i++) {
            arr[i] = curr.value;
            curr = curr.next;
        }

        curr = head;
        for (int i = size-1; i >=0 ; i--) {
            curr.value = arr[i];
            curr = curr.next;
        }
        return head;
    }

    private static Node reverse(Node head) {

        if(head == null) {
            return null;
        }

        Node curr = head;
        Node prev = null;

        while(curr !=null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
