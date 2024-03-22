package com.narendra.linkedlist.singly;

public class PalindromeCheckEfficient {

    public static void main(String[] args) {

        int n1 = (int)57999855392987L;
        int n2 = 432567;

        System.out.println(n1 + n2);

        Node head = new Node("R");
        head.next = new Node("A");
        head.next.next = new Node("D");
        head.next.next.next = new Node("A");
        head.next.next.next.next = new Node("R");

        /*
        Node head = new Node("A");
        head.next = new Node("B");
        head.next.next = new Node("B");
        head.next.next.next = new Node("A");*/

        /*
        Node head = new Node("A");
        head.next = new Node("B");
        head.next.next = new Node("C");*/

        Node.printData(head);
        System.out.println();
        System.out.println(isPalindrome(head));
    }

    private static boolean isPalindrome(Node head) {

        if(head == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;
        //To get second middle while(fast!=null && fast.next!=null) in even nodes
        //To get first middle while(fast!=null && fast.next!=null) in even nodes
        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        Node curr = mid.next;
        Node prev = null;

        while (curr!=null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        mid.next = prev;

        System.out.println();
        Node.printData(head);
        System.out.println();

        curr = head;
        Node midNext = mid.next;

        while(midNext!=null) {
            if(!curr.data.equals(midNext.data)) {
                return false;
            }
            curr = curr.next;
            midNext = midNext.next;
        }
        return true;
    }
}
