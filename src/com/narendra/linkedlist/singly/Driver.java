package com.narendra.linkedlist.singly;

public class Driver {

    public static void main(String[] args) {
        //testInsertAtGivenPosition();
        //testRemoveFirst();
        //testRemoveLast();
        testSearch();
    }

    private static void testSearch() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        System.out.println(singleLinkedList.search(10));
        System.out.println(singleLinkedList.searchRecursive(10));

        singleLinkedList.add(10);
        singleLinkedList.add(20);
        singleLinkedList.add(30);
        singleLinkedList.add(40);
        System.out.println(singleLinkedList);

        System.out.println(singleLinkedList.search(10));
        System.out.println(singleLinkedList.search(30));
        System.out.println(singleLinkedList.search(40));
        System.out.println(singleLinkedList.search(60));

        System.out.println(singleLinkedList.searchRecursive(10));
        System.out.println(singleLinkedList.searchRecursive(30));
        System.out.println(singleLinkedList.searchRecursive(40));
        System.out.println(singleLinkedList.searchRecursive(60));

    }

    private static void testRemoveLast() {

        testRemoveLastEnd();
        testRemoveLastBeginning();
        testRemoveLastEmptyList();
    }

    private static void testRemoveLastEmptyList() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        System.out.println(singleLinkedList);
        singleLinkedList.removeLast();
        System.out.println(singleLinkedList);
    }

    private static void testRemoveLastBeginning() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        singleLinkedList.add(10);
        System.out.println(singleLinkedList);
        singleLinkedList.removeLast();
        System.out.println(singleLinkedList);
    }

    private static void testRemoveLastEnd() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        singleLinkedList.add(10);
        singleLinkedList.add(20);
        singleLinkedList.add(30);
        singleLinkedList.add(40);
        System.out.println(singleLinkedList);
        singleLinkedList.removeLast();
        System.out.println(singleLinkedList);
    }

    private static void testRemoveFirst() {

        SingleLinkedList singleLinkedList = new SingleLinkedList();

        singleLinkedList.add(5);
        System.out.println(singleLinkedList);
        singleLinkedList.removeFirst();
        System.out.println(singleLinkedList);
    }

    private static void testInsertAtGivenPosition() {
        testInsertAtGivenPositionMiddle();
        testInsertAtGivenPositionEnd();
        testInsertAtGivenPositionBegin();
        testInsertAtGivenPositionOutOfRange();
    }

    private static void testInsertAtGivenPositionOutOfRange() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        singleLinkedList.add(5);
        singleLinkedList.add(15);
        System.out.println(singleLinkedList);
        singleLinkedList.add(3, 1);

        System.out.println(singleLinkedList);
    }

    private static void testInsertAtGivenPositionBegin() {

        SingleLinkedList singleLinkedList = new SingleLinkedList();

        singleLinkedList.add(5);
        singleLinkedList.add(15);
        singleLinkedList.add(25);
        singleLinkedList.add(35);
        System.out.println(singleLinkedList);
        singleLinkedList.add(0, 1);

        System.out.println(singleLinkedList);
    }

    private static void testInsertAtGivenPositionEnd() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        singleLinkedList.add(5);
        singleLinkedList.add(15);
        singleLinkedList.add(25);
        singleLinkedList.add(35);
        System.out.println(singleLinkedList);
        singleLinkedList.add(4, 10);

        System.out.println(singleLinkedList);
    }

    private static void testInsertAtGivenPositionMiddle() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        singleLinkedList.add(10);
        singleLinkedList.add(30);
        singleLinkedList.add(50);
        singleLinkedList.add(70);
        System.out.println(singleLinkedList);

        singleLinkedList.add(1, 20);

        System.out.println(singleLinkedList);

    }
}
