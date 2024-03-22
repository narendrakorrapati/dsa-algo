package com.narendra.linkedlist.singly;

public class DeleteLoopMethod2 {

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

        System.out.println(deleteLoop(head));
    }

    private static boolean deleteLoop(Node head) {

        if(head == null) {
            return false;
        }

        for (Node curr = head; curr!=null; curr = curr.next) {
            if(curr.visited) {
                return true;
            }
            curr.visited = true;
        }

        return false;
    }
}
