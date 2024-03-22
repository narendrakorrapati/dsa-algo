package com.narendra.linkedlist.singly;


public class CloneASLLEfficient {

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

        //Insert cloned nodes in between original nodes.
        for (CloneNode curr = head; curr!=null; curr = curr.next.next) {
            CloneNode clone = new CloneNode(curr.value);
            clone.next = curr.next;
            curr.next = clone;
        }

        //Set random links to cloned nodes using the original nodes random links.
        for (CloneNode curr = head; curr!=null; curr = curr.next.next) {
            curr.next.random = curr.random == null? null : curr.random.next;
        }

        CloneNode cloneHead = head.next;

        CloneNode curr = head;
        CloneNode cloneCurr = cloneHead;

        while(curr!=null) {
            curr.next = cloneCurr.next;
            if(curr.next!=null) {
                cloneCurr.next = curr.next.next;
            }
            curr = curr.next;
            cloneCurr = cloneCurr.next;
        }

        return cloneHead;
    }
}
