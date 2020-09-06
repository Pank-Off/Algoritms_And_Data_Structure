package com.algorithmsAndDataStructure;

public class MyStack<T> {

    /**
     * if we want guarantee that each operation is quickly completed - LinkedList
     * if we are interested in the total time - ArrayList
     */
    private T[] array = (T[]) new Object[1];
    /**
     * Sorry for this...
     */
    private int count = 0;

    boolean isEmpty() {
        return count == 0;
    }

    void push(T number) {
        if (count == array.length) {
            resize(array.length * 2);
        }
        array[count++] = number;
    }

    private void resize(int size) {
        T[] copyArray = (T[]) new Object[size];  /**...And this*/
        if (count >= 0) System.arraycopy(array, 0, copyArray, 0, count);
        array = copyArray;
    }

    T pop() {
        if (count > 0 && count == array.length / 4) {
            resize(array.length / 2);
        }
        return array[--count];
    }

}
