package com.narendra.linkedlist.circular;

public class DeleteKthNodeOfCircularSLL {

    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        Node temp3 = new Node(40);

        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = head;

        head = deleteKthNode(head, 1);
        Node.print(head);
    }

    private static Node deleteKthNode(Node head, int k) {
        if(head == null) {
            return null;
        }
        //delete head;
        if(k == 1) {
            if(head.next == head) {
                return null;
            } else {
                head.value = head.next.value;
                head.next = head.next.next;
                return head;
            }
        }

        Node curr = head;

        for(int i=1; i<=k-2; i++) {
            curr = curr.next;
        }

        curr.next = curr.next.next;

        return head;
    }
}
