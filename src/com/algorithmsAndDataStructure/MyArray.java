package com.algorithmsAndDataStructure;

import java.util.*;

public class MyArray {

    private int[] array;
    int length = 0;

    private final int DEFAULT_CAPACITY = 5;

    MyArray() {
        array = new int[DEFAULT_CAPACITY];
    }

    void add(int number) {
        try {
            array[length++] = number;
        } catch (ArrayIndexOutOfBoundsException exc) {
            int[] copyArray;
            copyArray = array;
            array = new int[Math.max(DEFAULT_CAPACITY, length++)];
            for (int i = 0; i < copyArray.length; i++) {
                array[i] = copyArray[i];
                length = copyArray.length;
            }
            array[length++] = number;
        }
    }

    void bubbleSort() {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int j = 1; j < array.length; j++) {
                if (array[j] < array[j - 1]) {
                    swap(j, j - 1);
                    isSorted = false;
                }
            }
        }
    }

    /**
     * selectionSort:
     * The worst case: N^2
     * The average case: N^2
     * The best case: N^2
     */
    void selectionSort() {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] >= array[j]) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
    }

    /**
     * insertionSort:
     * The worst case: N^2
     * The average case: N^2
     * The best case: N
     */
    void insertionSort() {

        for (int i = 0; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j - 1] > array[j]) {
                swap(j, j - 1);
                j = j - 1;
            }
        }
    }

    void mergeSort() {
        int[] aux = new int[array.length];
        sortM(aux, 0, array.length - 1);
    }

    private void sortM(int[] aux, int lo, int hi) {
        if (hi <= lo)
            return;
        int mid = (hi + lo) / 2;
        sortM(aux, lo, mid);
        sortM(aux, mid + 1, hi);
        merge(aux, lo, mid, hi);
    }

    private void merge(int[] aux, int lo, int mid, int hi) {
        assert isSorted(array, lo, mid);
        assert isSorted(array, mid + 1, hi);

        if (hi + 1 - lo >= 0) System.arraycopy(array, lo, aux, lo, hi + 1 - lo);
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                array[k] = aux[j++];
            } else if (j > hi) {
                array[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                array[k] = aux[j++];
            } else {
                array[k] = aux[i++];
            }
        }
        assert isSorted(array, lo, hi);
    }

    void quickSort() {
        shuffleArray(); // This is for average case: n*log(n)
        sortQ(0, array.length - 1);
    }

    private void sortQ(int lo, int hi) {
        final int CUTOFF = 20; //if array is small - quickSort is not effective
        if (hi <= lo + CUTOFF) {
            insertionSort();
            return;
        }
        int j = partition(lo, hi);
        sortQ(lo, j - 1);
        sortQ(j + 1, hi);
    }

    private int partition(int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (less(array[++i], array[lo])) {
                if (i == hi) {
                    break;
                }
            }
            while (less(array[lo], array[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(j, i);
        }
        swap(lo, j);
        return j;
    }

    private void shuffleArray() {
        for (int i = 0; i < array.length; i++) {
            swap((int) (Math.random() * array.length), (int) (Math.random() * array.length));
        }
    }


    private boolean isSorted(int[] array, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++) {
            if (less(array[i], array[i - 1])) {
                return false;
            }
        }
        return true;
    }

    private boolean less(int auxj, int auxi) {
        return auxj <= auxi;
    }


    void swap(int index, int minIndex) {
        int temp = array[index];
        array[index] = array[minIndex];
        array[minIndex] = temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
