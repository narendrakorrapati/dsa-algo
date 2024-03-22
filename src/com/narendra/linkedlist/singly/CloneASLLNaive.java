package com.narendra.linkedlist.singly;

import java.util.HashMap;

public class CloneASLLNaive {

    public static void main(String[] args) {
        CloneNode head1 = new CloneNode(10);
        CloneNode temp1 = new CloneNode(5);
        CloneNode temp2 = new CloneNode(20);
        CloneNode temp3 = new CloneNode(15);
        CloneNode temp4 = new CloneNode(20);


        head1.next = temp1;
        head1.next.next = temp2;
        head1.next.next.next = temp3;
        head1.next.next.next.next = temp4;

        head1.random = temp2;
        temp1.random = temp3;
        temp2.random = head1;
        temp3.random = temp2;
        temp4.random = temp3;


        CloneNode.print(head1);
        System.out.println();
        CloneNode head2 = cloneSLL(head1);
        System.out.println("Printing the cloned head");

        head1.next = null;

        CloneNode.print(head2);
        System.out.println();
        CloneNode.print(head1);
    }

    private static CloneNode cloneSLL(CloneNode head) {

        HashMap<CloneNode, CloneNode> map = new HashMap<>();

        CloneNode curr = head;

        while(curr !=null) {
            map.put(curr, new CloneNode(curr.value));
            curr = curr.next;
        }

        curr = head;

        while(curr !=null) {
            CloneNode clone = map.get(curr);
            clone.next = map.get(curr.next);
            clone.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
}
