package com.narendra.linkedlist.singly;

public class CloneNode {

    int value;
    CloneNode next;
    CloneNode random;

    public CloneNode(int value) {
        this.value = value;
    }
    static public void print(CloneNode head) {
        if(head != null) {
            System.out.println("Printing next");
            CloneNode temp = head;
            while(temp != null) {
                System.out.print(temp.value + " ");
                temp = temp.next;
            }
            System.out.println();
            System.out.println("Printing random");
            temp = head;
            while(temp != null) {
                System.out.print(temp.random.value + " ");
                temp = temp.next;

            }
        }
    }
}
