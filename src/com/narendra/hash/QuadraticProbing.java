package com.narendra.hash;

import java.util.Arrays;

public class QuadraticProbing {

    public static void main(String[] args) {
        int[] hash = new int[11];
        Arrays.fill(hash, -1);

        int arr[] = new int[]{21,10,32,43};

        quadraticProbing(hash, hash.length, arr, 1);
        System.out.println(Arrays.toString(hash));

    }

    static void quadraticProbing(int[] hash, int hash_size, int arr[], int N)
    {

        for(int i=0; i<N; i++) {
            insert(hash, hash_size, arr[i]);
        }

    }

    static void insert(int[] hash, int hash_size, int key) {

        int probe = 0;
        int h = getHash(key, probe, hash_size);

        while(hash[h] != -1) {

            if(hash[h] == key) { //For duplicates
                return;
            }

            probe ++;
            h = getHash(key, probe, hash_size);
        }

        hash[h] = key;

    }

    static int getHash(int key, int probe, int hash_size) {
        return (key + (probe * probe)) % hash_size;
    }
}
