package com.narendra.linkedlist.singly;

public class SingleLinkedList {

    Node head;
    Node tail;
    private class Node {
        private int value;
        private Node next;
        public Node(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            if(next != null) {
                return value + ", " + next;
            }
            return String.valueOf(value);
        }
    }

    public void add(int value) {
        Node node = new Node(value);
        if(head == null) {
            head = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
    }

    public void addLast(int value) {
        Node node = new Node(value);
        if(head == null) {
            head = node;
        } else {
            //Find the node whose next is null and then add new node reference to it.
            Node temp = head;
            while(temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(node);
        }
        tail = node;
    }

    public void addFirst(int value) {
        Node node = new Node(value);
        node.setNext(head);
        head = node;
    }

    public void add(int index, int value) {
        //Without using the help of other functions.
        /*
        Node temp = new Node(value);
        if(index == 0) {
            temp.setNext(head);
            head = temp;
        }
        Node curr = head;
        for(int i=1; i<index && curr!=null; i++) {
            curr = curr.getNext();
        }

        if(curr == null) {
            return;
        }

        temp.setNext(curr.getNext());
        curr.setNext(temp);
        */

        //Using the help of existing functions.
        int size = size();

        if(index > size) {
            return;
        }
        if(index == size) {
            addLast(value);
        } else {
            if(index == 0) {
                addFirst(value);
            } else {
                int count = 0;
                Node temp = head;
                while (count != index-1) {
                    count ++;
                    temp = temp.getNext();
                }
                Node toInsert = new Node(value);
                toInsert.setNext(temp.getNext());
                temp.setNext(toInsert);
            }
        }
    }

    public void removeFirst() {
        if(head != null)
            head = head.getNext();
    }

    public void removeLast() {
        if(head == null) {
            return;
        }

        if(head.getNext() == null) {
            head = null;
            tail = null;
            return;
        }

        Node temp = head;
        while(temp.getNext().getNext()!=null) {
            temp = temp.getNext();
        }
        temp.setNext(null);
        tail = temp;
    }

    public int search(int value) {
        Node temp = head;

        int index = 0;

        while(temp!=null) {
            if(temp.getValue() == value) {
                return index;
            } else {
                index++;
                temp = temp.getNext();
            }
        }

        return -1;
    }

    public int searchRecursive(int value) {
        return search(head, value, 0);
    }

    private int search(Node node, int value, int index) {
        if(node == null) {
            return -1;
        }
        if(node.getValue() == value) {
            return index;
        }
        return search(node.getNext(), value, index+1);
    }

    public int size() {
        if(head == null) {
            return 0;
        }
        int size = 1;
        Node temp = head;
        while(temp.getNext() != null) {
            size ++;
            temp = temp.getNext();
        }

        return size;
    }
    public void print() {
        if(head != null) {
            Node temp = head;
            while(temp != null) {
                System.out.print(temp.getValue() + " ");
                temp = temp.getNext();
            }
        }
    }

    public void printRecursively() {
        printRecursively(head);
    }

    private void printRecursively(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.getValue() + " ");
        printRecursively(node.getNext());
    }

    @Override
    public String toString() {
        return head == null? "[]": "[" + head.toString() + "]";
    }
}
