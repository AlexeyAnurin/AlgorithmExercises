package com.example.algorithm.Chap05;

class Link {
    int data;
    Link next;

    Link(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkList {
    private Link current;

    public CircularLinkList() {
        current = null;
    }

    public void insert(int data) {
        Link newLink = new Link(data);

        if (current == null) {
            current = newLink;
            newLink.next = current;
        } else {
            newLink.next = current.next;
            current.next = newLink;
            current = newLink;
        }
    }

    public void find(int dataToFind) {
        boolean found = false;
        Link currentStart = current;
        System.out.println("Searching for " + dataToFind);

        do {
            if (dataToFind == currentStart.data) {
                found = true;
                break;
            }
            currentStart = currentStart.next;
        } while (currentStart != current);
        if (found) {
            System.out.println(dataToFind + " Found");
        } else {
            System.out.println(dataToFind + " not found");
        }
    }

    public void delete() {
        Link currentStart = current;

        if (currentStart.next == current) {
            current = null;
        } else {
            step();
            currentStart.next = current.next;
            current = currentStart;
        }
    }

    public void display() {
        Link currentStart = current;

        if (current != null) {
            do {
                step();
                System.out.print(current.data + " ");
            } while (currentStart != current);
            System.out.println();
        } else {
            System.out.println("List is empty");
        }
    }

    void step() {
        current = current.next;
    }
}

class CircularList {
    public static void main(String[] args) {
        CircularLinkList circularLinkList = new CircularLinkList();

        circularLinkList.insert(10);
        circularLinkList.insert(20);
        circularLinkList.insert(30);
        circularLinkList.insert(40);
        circularLinkList.insert(50);
        circularLinkList.display();
        circularLinkList.find(40);
        circularLinkList.delete();
        circularLinkList.display();
    }
}
