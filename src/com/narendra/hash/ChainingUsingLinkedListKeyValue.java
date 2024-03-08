package com.narendra.hash;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class ChainingUsingLinkedListKeyValue {

    public static void main(String[] args) {

        MyHashKeyValue myHash = new MyHashKeyValue(7);

        System.out.println("insert(70, 100):" + myHash.insert(new Pair(70, 100)));
        System.out.println("insert(71, 200):" + myHash.insert(new Pair(71, 200)));
        System.out.println("insert(9, 300):" + myHash.insert(new Pair(9, 300)));
        System.out.println("insert(56, 100):" + myHash.insert(new Pair(56, 100)));
        System.out.println("insert(72, 150):" + myHash.insert(new Pair(72, 150)));
        System.out.println("search(56):" + myHash.search(56));
        System.out.println("search(57):" + myHash.search(57));
        System.out.println("delete(56):" + myHash.delete(56));
        System.out.println("delete(57):" + myHash.delete(57));

        System.out.println(myHash.hashtable);

    }
}

class MyHashKeyValue {

    int bucket;
    ArrayList<LinkedList<Pair>> hashtable;

    MyHashKeyValue(int bucket) {
        this.bucket = bucket;
        hashtable = new ArrayList<>();

        for (int i = 0; i < bucket; i++) {
            hashtable.add(new LinkedList<>());
        }
    }
    private int computeHash(int key) {
        return key % bucket;
    }

    boolean insert(Pair pair) {
        int index = computeHash(pair.key);

        LinkedList<Pair> head = hashtable.get(index);
        return head.add(pair);
    }

    boolean search(int key) {
        int index = computeHash(key);

        LinkedList<Pair> head = hashtable.get(index);

        ListIterator<Pair> pairListIterator = head.listIterator();

        while(pairListIterator.hasNext()) {
            Pair pair = pairListIterator.next();
            if(pair.key == key) {
                return true;
            }
        }
        return false;
    }

    boolean delete(int key) {
        int index = computeHash(key);

        LinkedList<Pair> head = hashtable.get(index);

        ListIterator<Pair> pairListIterator = head.listIterator();

        while (pairListIterator.hasNext()) {
            Pair pair = pairListIterator.next();
            if(pair.key == key) {
                pairListIterator.remove();
                return true;
            }
        }
        return false;
    }

}

class Pair {
    int key;
    int value;

    Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "["+key+","+value+"]";
    }
}
