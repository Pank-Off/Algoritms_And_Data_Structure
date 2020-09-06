package com.algorithmsAndDataStructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first, last;
    private int count;

    private class Node {
        Item item;
        Node next;
        Node previous;
    }

    // construct an empty deque
    public Deque() {
        first = new Node();
        first.next = null;
        first.previous = null;
        last = first;

    }

    // is the deque empty?
    public boolean isEmpty() {
        return first == null;
    }

    // return the number of items on the deque
    public int size() {
        return count;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Can't add null");
        }
        Node oldFirst = first;
        first = new Node();
        first.next = oldFirst;
        first.item = item;
        first.previous = null;
        count++;
    }


    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Can't add null");
        }
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        last.previous = oldLast;
        // oldLast.next = last;
        System.out.println(first);
        //     first = oldLast;
        //      first.next = last;
        count++;
    }

    // remove and return the item from the front
    public Item removeFirst() {

        if (isEmpty()) {
            throw new NoSuchElementException("Dequeue is empty!");
        }
        Item value = last.item;


//        Node current = first;
//        count--;
//        if (current.next == null) {
//            first = null;
//            last = null;
//            return value;
//        }
//        while (iterator().hasNext()) {
//            if (current.next == last) {
//                last = current;
//                last.next = null;
//                break;
//            }
//            current = current.next;
//        }
        return value;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Dequeue is empty!");
        }
        Item value = first.item;
        first = first.next;
        count--;
        if (isEmpty()) {
            last = null;
        }
        return value;

    }


    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Method remove is not supported!");
        }

        @Override
        public Item next() {
            if (isEmpty()) {
                throw new NoSuchElementException("Dequeue is empty!");
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
