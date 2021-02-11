package com.example.algorithm.Chap04.DequeStack;

public class StackDeque {
    private	int maxSize;
    private	int front;
    private	int rear;
    private	int nItems;
    private int[] queArray;

    public StackDeque(int size) {
        maxSize = size;
        queArray = new int[size];
        front = -1; // start condition
        rear = -1; // start condition
        nItems = 0; // start condition
    }
    //-----------------------

    //  insertRight in deque
    public void push(int val) {
        if (isFull()) {
            System.out.println("stack is full");

        } else {
            // start condition
            if (front == -1) {
                front = 0;
                rear = 0;
            } else {
                // common flow
                rear++;
            }
            // will be always executed
            queArray[rear] = val;
            nItems++;
        }
    }

    //  deleteRight in deque
    public void pop() {
        if (isEmpty()) {
            System.out.println("stack is empty");
        } else {
            //  only 1 item left condition
            if (front == rear) {
                // reset to start condition
                front = -1;
                rear = -1;
            }  else {
                // common flow
                rear = rear-1;
            }
            nItems--;
        }
    }
    //-----------------------
    public int peek() {
        if (isEmpty()) {
            System.out.println("stack is empty");
        }
        System.out.println("peek " + queArray[rear]);
        return queArray[rear];
    }
    //-----------------------
    public boolean isFull() {
        return (nItems == maxSize);
    }
    //-----------------------
    public boolean isEmpty () {
        return (nItems==0);
    }
    //-----------------------
    public void display() {
        int j = front;

        for(int i = 0; i< nItems; i++) {
            System.out.print(queArray[j] + " ");
            j++;

            if(j == maxSize) {
                j = 0;
            }
        }
        System.out.println();
    }
//-----------------------
}

class StackDeque1 {
    public static void main(String[] args) {
        StackDeque stackDeque = new StackDeque(5);

        stackDeque.push(1);
        stackDeque.push(2);
        stackDeque.push(3);
        stackDeque.display();           // 1 2 3
        stackDeque.peek();              // 3
        stackDeque.pop();
        stackDeque.display();           // 1 2
        stackDeque.pop();
        stackDeque.display();           // 1
        stackDeque.pop();
        stackDeque.pop();       // "stack is empty"

    }
}
