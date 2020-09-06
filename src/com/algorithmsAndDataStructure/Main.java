package com.algorithmsAndDataStructure;

public class Main {

    public static void main(String[] args) {

        MyArray myArray = new MyArray();
        MyStack<String> myStackString = new MyStack<>();
        MyQueue<Integer> myQueue = new MyQueue<>();

        Deque<Integer> myDequeue = new Deque<>();
        testForBinTree();

        //testForDequeue(myDequeue);
        // testForArray(myArray);
//        testForStack(myStackString);
//        testForQueue(myQueue);
    }

    private static void testForBinTree() {
        BinTree tree = new BinTree(20,
                new BinTree(7,
                        new BinTree(4, null, new BinTree(6, null, null)),
                        new BinTree(9, null, null)),
                new BinTree(35,
                        new BinTree(31,
                                new BinTree(28, null, null), null),
                        new BinTree(40,
                                new BinTree(38, null, null),
                                new BinTree(52, null, null))));

        System.out.println(tree.wideSum());
    }

    private static void testForDequeue(Deque<Integer> myDequeue) {
        System.out.println("Start testForDequeue");

        int count = 6;
        for (int i = 1; i < count; i++) {
            System.out.println(i + " addFirst in Dequeue");
            myDequeue.addFirst(i);
        }
        for (Integer integer : myDequeue) {
            System.out.print(integer + " ");
        }
        System.out.println();
        for (int i = 1; i < count; i++) {
            System.out.println(i + " addLast in Dequeue");
            myDequeue.addLast(i);
        }
        for (Integer integer : myDequeue) {
            System.out.print(integer + " ");
        }
        System.out.println();
//
//        for (int i = 1; i < count + 2; i++) {
//            System.out.println("removeLast " + myDequeue.removeLast());
//        }
//

//
//        System.out.println("removeLast " + myDequeue.removeFirst());
//        System.out.println("removeLast " + myDequeue.removeLast());
//        System.out.println("removeLast " + myDequeue.removeLast());
        // myDequeue.addFirst(null);
        //  myDequeue.addLast(null);
//        for (Integer integer : myDequeue) {
//            System.out.print(integer + " ");
//        }
//        System.out.println();
        //  myDequeue.iterator().next();
        //  myDequeue.iterator().remove();
        //System.out.println("removeLast " + myDequeue.removeLast());
        //  System.out.println("removeLast " + myDequeue.removeFirst());

        System.out.println("End testForDequeue");
        System.out.println("-------------------------------------------------------------------------------------------");
    }

    private static void testForArray(MyArray myArray) {
        for (int i = 0; i < 15; i++) {
            myArray.add((int) (Math.random() * 100));
        }

        //  long currentTime =  System.currentTimeMillis();
        System.out.println(myArray);

        // myArray.bubbleSort();
        //  myArray.selectionSort();
        // myArray.insertionSort();
        //    myArray.mergeSort();
        myArray.quickSort();

        // System.out.println("End Sort " + (System.currentTimeMillis() - currentTime));
        System.out.println(myArray);


    }

    private static void testForQueue(MyQueue<Integer> queue) {
        System.out.println("Start testForQueue");
        int count = 7;
        for (int i = 1; i < count; i++) {
            queue.enqueue(i);
        }
        for (int i = 1; i < count; i++) {
            System.out.println(queue.dequeue());
        }
        System.out.println("End testForQueue");
    }

    private static void testForStack(MyStack<String> stack) {
        System.out.println("Start testForStack");
        int count = 7;
        for (int i = 1; i < count; i++) {
            stack.push("A " + i);
        }
        for (int i = 1; i < count; i++) {
            System.out.println(stack.pop());
        }
        System.out.println("End testForQueue");
    }
}
