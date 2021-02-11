package com.example.algorithm.Chap04.DequeCircuit;

class DequeCircuit {
    private	int maxSize;
    private	int front;
    private	int rear;
    private	int nItems;
    private int[] queArray;

    public DequeCircuit(int size) {
        maxSize = size;
        queArray = new int[size];
        front = -1; // start condition
        rear = -1; // start condition
        nItems = 0; // start condition
    }
//-----------------------
    // Reverte flow: insertLeft, deleteRight
    public void insertLeft(int item) {
        if (isFull()) {
            System.out.println("deque is full");
        } else {
            // start condition
            if (rear == -1) {
                front = 0;
                rear = 0;
                // end reached condition
            } else if (front == 0) {
                // rearrangement
                front = maxSize - 1;
            }
            else {
                // common flow
                front--;
            }
            // will always be executed
            queArray[front] = item;
            nItems++;
        }
    }
//-----------------------
    // Standart flow: insertRight, deleteLeft
    public void insertRight(int val) {
        if (isFull()) {
            System.out.println("deque is full");

        } else {
            // start condition
            if (front == -1) {
                front = 0;
                rear = 0;
            // end reached condition
            } else if (rear == maxSize -1) {
                // rearrangement
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
//-----------------------
    // Standart flow: insertRight, deleteLeft
    public void deleteLeft() {
        if (isEmpty()) {
            System.out.println("deque is empty");
        } else {
            //  only 1 item left condition
            if (front == rear) {
                // reset to start condition
                front = -1;
                rear = -1;
                // rearrange condition
            } else if (front == maxSize -1) {
                    front = 0;
                } else {
                    // common flow
                    front++;
                }
            // will be always executed
            nItems--;
        }
    }
//-----------------------
    // Reverte flow: insertLeft, deleteRight
    public void deleteRight() {
        if (isEmpty()) {
            System.out.println("deque is empty");
        } else {
            //  only 1 item left condition
            if (front == rear) {
                // reset to start condition
                front = -1;
                rear = -1;
                // rearrange condition
            } else if (rear == 0) {
                rear = maxSize -1;
            } else {
                // common flow
                rear = rear-1;
            }
            nItems--;
        }
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

class CircularDeque {
    public static void main(String[] args) {
        DequeCircuit dequeCircuit = new DequeCircuit(5);

        dequeCircuit.insertRight(1);
        dequeCircuit.insertRight(2);
        dequeCircuit.insertRight(3);
        dequeCircuit.display();             // 1 2 3
        dequeCircuit.insertLeft(4);
        dequeCircuit.insertLeft(5);
        dequeCircuit.display();             // 5 4 1 2 3
        dequeCircuit.deleteLeft();
        dequeCircuit.display();             // 4 1 2 3
        dequeCircuit.deleteRight();
        dequeCircuit.display();             // 4 1 2
    }
}
