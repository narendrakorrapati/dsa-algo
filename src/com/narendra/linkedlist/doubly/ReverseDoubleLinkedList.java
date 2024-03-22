package com.narendra.linkedlist.doubly;

public class ReverseDoubleLinkedList {

    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        Node temp3 = new Node(40);
        head.next = temp1;
        temp1.prev = head;
        temp1.next = temp2;
        temp2.prev = temp1;
        temp2.next = temp3;
        temp3.prev=temp2;

        Node.print(head);
        /*
        Node newHead = reverseMyOwnAnalysis(head);
        Node.print(newHead);
        */
        Node newHead = reverseStandard(head);
        Node.print(newHead);

    }

    /**
     * Swap current.next with current.previous.
     * @param head
     * @return
     */
    private static Node reverseStandard(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node curr = head;
        Node temp = null;
        while(curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }
        return temp.prev;
    }

    private static Node reverseMyOwnAnalysis(Node head) {

        if(head == null || head.next == null) {
            return head;
        }

        Node curr = head;
        while(curr.next != null) {
            curr.prev = curr.next;

            Node temp = curr.next;
            curr.next = null;

            curr = temp;
        }
        curr.prev = null;

        curr = head;
        while(curr.prev!=null) {
            Node prev = curr.prev;
            prev.next = curr;
            curr = prev;
        }
        return curr;
    }
}
