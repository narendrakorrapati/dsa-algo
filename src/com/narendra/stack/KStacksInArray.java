package com.narendra.stack;

public class KStacksInArray {

    public static void main(String[] args) {
        MyKStacksInArray stacks = new MyKStacksInArray(5, 2);
        stacks.push(0, 10);
        stacks.push(0, 11);
        stacks.push(1, 20);
        stacks.push(1, 21);
        stacks.push(0, 12);

        System.out.println(stacks.pop(1));
        stacks.push(0, 13);
        System.out.println(stacks.pop(1));
        stacks.push(0, 14);
        System.out.println(stacks.pop(0));
        System.out.println(stacks.pop(0));
        System.out.println(stacks.pop(0));
        System.out.println(stacks.pop(0));
        System.out.println(stacks.pop(0));

    }
}

class MyKStacksInArray {

    int freeSlot = 0;
    int[] top;
    int[] data;
    int[] next;

    int cap;
    MyKStacksInArray(int cap, int k) {
        this.cap = cap;
        data = new int[cap];
        top = new int[k];
        next = new int[cap];

        for (int i = 0; i < cap-1; i++) {
            next[i] = i+1;
        }
        next[cap-1] = -1;
    }

    void push(int sn, int x) {
        if(freeSlot == -1) {
            return;
        }
        int i = freeSlot; //Current free slot where we are going to insert the x
        freeSlot = next[i]; //New free slot, getting it from next array.
        next[i] = top[sn]; //We are going to set the data[i], so next[i] will be used to track the previous index of the current stack.
        top[sn] = i; //Updating the top of current stack to current free slot.
        data[i] = x; //Setting x at current free slot.
    }

    int pop(int sn) {
        if(top[sn] == -1) {
            return Integer.MIN_VALUE;//Stack is empty
        }

        int i = top[sn]; //Current top of the stack
        top[sn] = next[i]; //Update top of the stack to previous top/index of its elements.
        next[i] = freeSlot; //We are going to unset the element in the current position, so going to utilize the next[i] to get the next free slot when inserting at index i in data array. Updating next[i] with current free slot
        freeSlot = i; //Updating current free slot as top of current stack;
        return data[i]; //return the data from old/previous top of the stack.
    }
}
