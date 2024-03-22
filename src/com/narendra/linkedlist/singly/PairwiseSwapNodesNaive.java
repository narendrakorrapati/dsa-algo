package com.narendra.linkedlist.singly;

public class PairwiseSwapNodesNaive {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node temp1 = new Node(2);
        Node temp2 = new Node(3);
        Node temp3 = new Node(4);
        Node temp4 = new Node(5);

        head.next = temp1;
        head.next.next = temp2;
        head.next.next.next = temp3;
        head.next.next.next.next = temp4;

        Node.print(head);
        System.out.println();
        pairwiseReverse(head);
        Node.print(head);
    }

    private static void pairwiseReverse(Node head) {

        Node curr = head;
        while(curr!=null && curr.next!=null) {
            int temp = curr.value;
            curr.value = curr.next.value;
            curr.next.value = temp;
            curr = curr.next.next;
        }
    }
}
