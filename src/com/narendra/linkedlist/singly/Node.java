package com.narendra.linkedlist.singly;

public class Node {

    int value;

    String data;
    Node next;

    boolean visited;
    public Node(String data) {
        this.data = data;
    }
    public Node(int value) {
        this.value = value;
    }
    static public void print(Node head) {
        if(head != null) {
            Node temp = head;
            while(temp != null) {
                System.out.print(temp.value + " ");
                temp = temp.next;
            }
        }
    }

    static public void printData(Node head) {
        if(head != null) {
            Node temp = head;
            while(temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }
    }
}
