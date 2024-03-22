package com.narendra.linkedlist.singly;

import java.util.HashMap;

public class LRUCache {

    private static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = this.value;
        }
    }


    private int cap;
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;


    LRUCache(int cap)
    {
        this.cap = cap;
        map = new HashMap<>(cap);
    }

    //Function to return value corresponding to the key.
    public int get(int key)
    {
        Node curr = map.get(key);
        if(curr == null) {
            return -1;
        }

        moveFirst(curr);
        return curr.value;
    }

    //Function for storing key-value pair.
    public void set(int key, int value)
    {
        Node curr = map.get(key);

        if(curr == null) {
            curr = new Node(key, value);
            if(map.size() == cap) {
                int delKey = deleteTail();
                map.remove(delKey);
            }
            addFirst(curr);
            map.put(key, curr);
        } else {
            curr.value = value;
            moveFirst(curr);
        }
    }

    private void addFirst(Node curr) {
        if(head == null) {
            head = curr;
            tail = curr;
            return;
        }
        curr.next = head;
        head.prev = curr;
        head = curr;
    }

    private void moveFirst(Node curr) {
        if(curr == head) {
            return;
        }
        if(curr == tail) {
            tail = tail.prev;
        }
        curr.prev.next = curr.next;
        if(curr.next!=null) {
            curr.next.prev = curr.prev;
        }
        curr.next = head;
        head.prev = curr;
        curr.prev = null;
        head = curr;
    }

    private int deleteTail() {
        int key = tail.key;
        if(head == tail) {
            head = null;
            tail = null;
        }
        tail = tail.prev;
        tail.next = null;
        return key;
    }
}
