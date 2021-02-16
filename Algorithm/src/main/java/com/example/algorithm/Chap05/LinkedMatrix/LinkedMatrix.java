package com.example.algorithm.Chap05.LinkedMatrix;

class Link {
    int data;
    Link nextAxisX;
    Link nextAxisY;

    Link(int data) {
        this.data = data;
        this.nextAxisX = null;
        this.nextAxisY = null;
    }
}

class Row {
    private int column;
    private Link startRowLink;

    public Row(int column) {
        this.column = column;

        createRow();
    }

    private void createRow() {
        Link current = null;
        while (column > 1) {
            Link newLink = new Link(0);

            if (startRowLink == null) {
                startRowLink = newLink;
                current = startRowLink;
            } else {
                current.nextAxisX = newLink;
                current = newLink;
                column--;
            }
        }
    }

    public Link getStartRowLink() {
        return startRowLink;
    }
}

class LinkedMatrix {
    private final int rowQuantity;
    private final int columnQuantity;
    private final Row[] linkedRow;
    private Link startMainRowLink;

    public LinkedMatrix(int rowQuantity, int columnQuantity) {
        this.rowQuantity = rowQuantity;
        this.columnQuantity = columnQuantity;
        startMainRowLink = null;
        linkedRow = new Row[rowQuantity];

        buildVerticalMatrixReferences();
    }

    private void buildVerticalMatrixReferences() {

        for (int i = 0; i < rowQuantity; i++) {
            linkedRow[i] = new Row(columnQuantity);
        }

        for (int i = 0; i < rowQuantity - 1; i++) {
            Link linkRowAbove = linkedRow[i].getStartRowLink();
            Link linkRowBelow = linkedRow[i + 1].getStartRowLink();

            for (int j = 0; j < columnQuantity; j++) {
                linkRowAbove.nextAxisY = linkRowBelow;
            }
        }
        startMainRowLink = linkedRow[0].getStartRowLink();
    }

    public void insert(int data, int x, int y) {
        Link matrixSellLink = startMainRowLink;
        int column = y;

        for (int row = 1; row < x; row++) {
            matrixSellLink = matrixSellLink.nextAxisY;
        }

        while (column > 1) {
            matrixSellLink = matrixSellLink.nextAxisX;
            column--;
        }

        matrixSellLink.data = data;
    }

    public void display() {
        Link startRowLinkForDisplay = startMainRowLink;

        while (startRowLinkForDisplay != null) {
            Link matrixSellLink = startRowLinkForDisplay;
            while (matrixSellLink != null) {
                System.out.print(matrixSellLink.data + " ");
                matrixSellLink = matrixSellLink.nextAxisX;
            }
            System.out.println();
            startRowLinkForDisplay = startRowLinkForDisplay.nextAxisY;
        }
        System.out.println();
    }
}

class LinkedMatrixMain {
    public static void main(String[] args) {
        LinkedMatrix linkedMatrix = new LinkedMatrix(5, 5);
        linkedMatrix.display();

        linkedMatrix.insert(1, 1, 1);
        linkedMatrix.insert(2, 1, 2);
        linkedMatrix.insert(3, 2, 1);
        linkedMatrix.insert(4, 2, 2);
        linkedMatrix.insert(5, 3, 3);
        linkedMatrix.insert(9, 5, 5);
        linkedMatrix.display();
    }
}


