package com.algorithmsAndDataStructure;

public class MyQueue<T> {
    private Node first, last;

    private class Node {
        T item;
        Node next;
    }

    void enqueue(T number) {
        Node oldLast = last;
        last = new Node();
        last.item = number;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    T dequeue() {
        T value = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        return value;
    }

    boolean isEmpty() {
        return first == null;
    }
}
