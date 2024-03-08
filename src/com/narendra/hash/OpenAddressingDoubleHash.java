package com.narendra.hash;

import java.util.Arrays;
import java.util.HashSet;

public class OpenAddressingDoubleHash {

    public static void main(String[] args) {
        DoubleHash hash = new DoubleHash(7);
        hash.insert(49);
        hash.insert(56);
        hash.insert(72);
        hash.insert(80);
        hash.insert(77);
        hash.insert(30);
        hash.insert(35);
        System.out.println("search(56):" + hash.search(56));
        hash.delete(56);
        hash.insert(15);
        System.out.println("search(56):" + hash.search(56));
        System.out.println(Arrays.toString(hash.hashtable));

    }
}

class DoubleHash {
    int bucket;
    int relativePrime;
    int [] hashtable;

    DoubleHash(int bucket) {
        this.bucket = bucket;
        this.relativePrime = bucket-1;
        hashtable = new int[bucket];
        Arrays.fill(hashtable, -1);
    }

    private int hash(int key, int probe) {
        return (h1(key) + (probe * h2(key))) % bucket;
    }

    private int h1(int key) {
        return key%bucket;
    }

    private int h2(int key) {
        return relativePrime - (key%relativePrime);
    }

    boolean insert(int key) {

        int probe = 0;
        int hashKey = hash(key, probe);

        while(hashtable[hashKey] != -1 && hashtable[hashKey] !=-2 && hashtable[hashKey] != key) {
            probe ++;
            hashKey = hash(key, probe);

            if(probe >= bucket) {
                throw new RuntimeException("table full");
            }
        }

        if(hashtable[hashKey] == key) {
            return false;
        }

        hashtable[hashKey] = key;

        return true;
    }

    boolean search(int key) {
        int probe = 0;
        int hashKey = hash(key, probe);

        while(hashtable[hashKey] != key ) {

            if(hashtable[hashKey] == -1) {
                return false;
            }
            probe ++;
            hashKey = hash(key, probe);
            if(probe >= bucket) {
                return false;
            }
        }
        return true;
    }

    void delete(int key) {
        int probe = 0;
        int hashKey = hash(key, probe);

        while(hashtable[hashKey] != key ) {

            if(hashtable[hashKey] == -1) {
                return;
            }
            probe ++;
            hashKey = hash(key, probe);
            if(probe >= bucket) {
                return;
            }
        }
        hashtable[hashKey] = -2;
    }

}
