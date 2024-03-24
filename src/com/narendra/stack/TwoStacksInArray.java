package com.narendra.stack;

public class TwoStacksInArray {
    public static void main(String[] args) {
        TwoStacks stacks = new TwoStacks();
        stacks.push1(2);
        stacks.push1(3);
        stacks.push2(4);
        System.out.println(stacks.pop1());
        System.out.println(stacks.pop2());
        System.out.println(stacks.pop2());
    }
}

class TwoStacks
{
    int arr[] = new int[100];
    int top1 = -1;
    int top2 = arr.length;

    //Function to push an integer into the stack1.
    void push1(int x)
    {
        if(top1+1 == top2) {
            return;
        }
        arr[top1+1] = x;
        top1++;

    }
    //Function to push an integer into the stack2.
    void push2(int x)
    {
        if(top2-1 == top1) {
            return;
        }

        arr[top2-1] = x;
        top2--;
    }
    //Function to remove an element from top of the stack1.
    int pop1()
    {
        if(top1 == -1) {
            return -1;
        }
        int data = arr[top1];
        top1--;
        return data;
    }
    //Function to remove an element from top of the stack2.
    int pop2()
    {
        if(top2 == arr.length) {
            return -1;
        }
        int data = arr[top2];
        top2++;
        return data;
    }
}
