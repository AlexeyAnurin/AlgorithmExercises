package com.example.algorithm.Chap06;

class BinaryTreeBranchBuilder {
    private final int leftBound;
    private final int rightBounds;
    private final char[] arrayOfValues;
    private int nextRowShift = 0;
    private final Double rowSize;
    private int rowQuantity;

    public BinaryTreeBranchBuilder(int rowQuantity) {
        this.rowQuantity = rowQuantity;
        this.rowSize = Math.pow(2.0, rowQuantity - 1);
        this.leftBound = 0;
        this.rightBounds = (int) (rowSize - 1);
        this.arrayOfValues = new char[(int) (rowQuantity * rowSize)];
    }

    public BinaryTreeBranchBuilder buildBranches() {
        createBranches(leftBound, rightBounds);
        return this;
    }

    private void createBranches(int leftBound, int rightBound) {
        int n = rightBound - leftBound;

        if (n == 0) {
            arrayOfValues[nextRowShift + leftBound] = 'I';
        } else {
            int middleIndex = (leftBound + rightBound + 1) / 2;

            for (int i = leftBound; i < rightBound + 1; i++) {
                if (i == middleIndex) {
                    arrayOfValues[nextRowShift + i] = 'I';
                } else {
                    arrayOfValues[nextRowShift + i] = '-';
                }
            }

            int previousRowShift = nextRowShift;
            nextRowShift = (int) (rowSize + nextRowShift);

            createBranches(leftBound, middleIndex - 1);
            nextRowShift = (int) (previousRowShift + rowSize);
            createBranches(middleIndex, rightBound);
        }
    }

    public void display() {
        for (int i = 0; i < arrayOfValues.length; i++) {
            if (i > 0 && i % (rightBounds + 1) == 0) {
                System.out.println("");
            }
            System.out.print(arrayOfValues[i]);
        }
    }

    public static void main(String[] args) {
        BinaryTreeBranchBuilder branchBuilder = new BinaryTreeBranchBuilder(4);
        branchBuilder.buildBranches().display();
    }
}
