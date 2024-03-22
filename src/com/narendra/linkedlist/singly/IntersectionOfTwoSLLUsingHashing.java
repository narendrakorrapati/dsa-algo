package com.narendra.linkedlist.singly;

import java.util.HashSet;

public class IntersectionOfTwoSLLUsingHashing {

    public static void main(String[] args) {
        Node head1 = new Node(5);
        Node temp1 = new Node(8);
        Node temp2 = new Node(7);
        Node temp3 = new Node(10);
        Node temp4 = new Node(12);
        Node temp5 = new Node(15);

        temp3.next = temp4;
        temp3.next.next = temp5;

        head1.next = temp1;
        head1.next.next = temp2;
        head1.next.next.next = temp3;

        Node head2 = new Node(9);
        head2.next = temp3;

        Node.print(head1);
        System.out.println();
        Node.print(head2);
        System.out.println();
        Node intersect = findIntersect(head1, head2);
        System.out.println(intersect.value);
    }

    private static Node findIntersect(Node head1, Node head2) {

        HashSet<Node> set = new HashSet<>();

        Node curr = head1;
        while(curr!=null) {
            set.add(curr);
            curr = curr.next;
        }

        curr = head2;

        while(curr!=null) {
            if(set.contains(curr)) {
                return curr;
            }
            curr = curr.next;
        }
        return new Node(-1);
    }
}

