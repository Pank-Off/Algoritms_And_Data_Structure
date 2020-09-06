package com.algorithmsAndDataStructure;

public class BinTree {

    private int value;
    private BinTree left, right;

    public BinTree(int value, BinTree left, BinTree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    //Поиск в глубину
    int deepSumRecursive() {
        int sum = value;
        if (left != null) {
            sum += left.deepSumRecursive();
        }
        if (right != null) {
            sum += right.deepSumRecursive();
        }
        return sum;
    }

    int deepSum() {
        int sum = 0;
        MyStack<BinTree> stack = new MyStack<>();
        stack.push(this);
        while (!stack.isEmpty()) {
            BinTree node = stack.pop();
            // System.out.println(node.value);
            sum += node.value;
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return sum;
    }

    int wideSum() {
        int sum = 0;
        MyQueue<BinTree> queue = new MyQueue<>();
        queue.enqueue(this);
        while (!queue.isEmpty()) {
            BinTree node = queue.dequeue();
            // System.out.println(node.value);
            sum += node.value;
            if (node.left != null) {
                queue.enqueue(node.left);
            }
            if (node.right != null) {
                queue.enqueue(node.right);
            }
        }
        return sum;
    }
}
