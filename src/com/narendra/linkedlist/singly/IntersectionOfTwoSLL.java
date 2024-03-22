package com.narendra.linkedlist.singly;

public class IntersectionOfTwoSLL {

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

        int size1 = getSize(head1);
        int size2 = getSize(head2);

        if(size1 > size2) {
            return findIntersect(head1, head2, size1-size2);
        }
        return findIntersect(head2, head1, size2-size1);
    }

    /**
     * Assuming Head 1 is greater than or equal to Head 2 size.
     * @param head1
     * @param head2
     * @param diff
     * @return
     */
    private static Node findIntersect(Node head1, Node head2, int diff) {

        Node curr = head1;
        while(diff !=0) {
            curr = curr.next;
            diff--;
        }

        Node h1 = curr;
        Node h2 = head2;

        while(h1!=null && h2!=null) {
            if(h1 == h2) {
                return h1;
            }
            h1 = h1.next;
            h2 = h2.next;
        }

        return new Node(-1);
    }

    private static int getSize(Node head) {
        int size = 0;
        Node curr = head;

        while(curr!=null) {
            size ++;
            curr = curr.next;
        }

        return size;
    }
}

