package com.narendra.linkedlist.singly;

import java.util.HashSet;

public class DeleteLoopMethod4 {

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
        temp4.next = head;

        System.out.println(deleteLoop(head));
    }

    private static boolean deleteLoop(Node head) {

        if(head == null) {
            return false;
        }

        HashSet<Node> set = new HashSet<>();

        for (Node curr = head; curr!=null; curr = curr.next) {
            if(!set.add(curr)) {
                return true;
            }
        }
        return false;
    }
}
