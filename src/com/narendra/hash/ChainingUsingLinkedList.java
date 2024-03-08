package com.narendra.hash;

import java.util.ArrayList;
import java.util.LinkedList;

public class ChainingUsingLinkedList {

    public static void main(String[] args) {

        MyHash myHash = new MyHash(7);

        System.out.println("insert(70):" + myHash.insert(70));
        System.out.println("insert(71):" + myHash.insert(71));
        System.out.println("insert(9):" + myHash.insert(9));
        System.out.println("insert(56):" + myHash.insert(56));
        System.out.println("insert(72):" + myHash.insert(72));
        System.out.println("search(56):" + myHash.search(56));
        System.out.println("search(57):" + myHash.search(57));
        System.out.println("delete(56):" + myHash.delete(56));
        System.out.println("delete(57):" + myHash.delete(57));

        System.out.println(myHash.hashtable);

    }
}

class MyHash {

    int bucket;
    ArrayList<LinkedList<Integer>> hashtable;

    MyHash(int bucket) {
        this.bucket = bucket;
        hashtable = new ArrayList<>();

        for (int i = 0; i < bucket; i++) {
            hashtable.add(new LinkedList<>());
        }
    }
    private int computeHash(int key) {
        return key % bucket;
    }

    boolean insert(int key) {
        int index = computeHash(key);

        LinkedList<Integer> head = hashtable.get(index);
        return head.add(key);
    }

    boolean search(int key) {
        int index = computeHash(key);

        LinkedList<Integer> head = hashtable.get(index);
        return head.contains(key);
    }

    boolean delete(int key) {
        int index = computeHash(key);

        LinkedList<Integer> head = hashtable.get(index);
        return head.remove(Integer.valueOf(key));
    }

}
