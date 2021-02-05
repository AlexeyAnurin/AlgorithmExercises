package com.example.algorithm.Chap03.InsertSort;


class ArrayIns {
    private long[] a;
    private int nElems;

    //--------------------------------------------------------------
    public ArrayIns(int max) {
        a = new long[max];
        nElems = 0;
    }

    //--------------------------------------------------------------
    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    //--------------------------------------------------------------
    public void display() {
        for (int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println("");
    }
    //--------------------------------------------------------------

    // 3.5
    public void insertionSortCount() {
        int in, out;
        int copiesQuantity = 0;
        int comparisonsQuantity = 0;

        for (out = 1; out < nElems; out++) {
            long temp = a[out];
            in = out;

            while (in > 0 && a[in - 1] >= temp) {
                comparisonsQuantity++;
                a[in] = a[in - 1];
                copiesQuantity++;
                --in;
            }
            if (in > 0) {
                comparisonsQuantity++;
            }
            a[in] = temp;
        }
        System.out.println("copiesQuantity: " + copiesQuantity);
        System.out.println("comparisonsQuantity: " + comparisonsQuantity);
    }

    //--------------------------------------------------------------

    // 3.6
    public void insertSortNoDups() {

        int in, out;
        for (out = 1; out < nElems; out++) {

            long temp = a[out];
            in = out;

            while (in > 0 && a[in - 1] >= temp) {
                if (temp == a[in - 1]) {
                    temp = -1;
                }
                a[in] = a[in - 1];
                in--;
            }
            a[in] = temp;
        }

        int i = 0;
        while (a[i] < 0) {
            delete(-1);
        }
    }

    //--------------------------------------------------------------
    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++)
            if (value == a[j])
                break;
        if (j == nElems)
            return false;
        else
        {
            for (int k = j; k < nElems; k++)
                a[k] = a[k + 1];
            nElems--;
            return true;
        }
    }
}

////////////////////////////////////////////////////////////////
class InsertSortApp {
    public static void main(String[] args) {
        int maxSize = 50;

        ArrayIns arrDups;
        ArrayIns arrCount;
        arrDups = new ArrayIns(maxSize);
        arrCount = new ArrayIns(maxSize);

        // 3.6
        arrDups.insert(15);
        arrDups.insert(13);
        arrDups.insert(14);
        arrDups.insert(14);
        arrDups.insert(135);
        arrDups.insert(155);
        arrDups.insert(66);
        arrDups.insert(14);
        arrDups.insert(135);
        arrDups.insert(23);
        arrDups.insert(144);
        arrDups.insert(14);
        arrDups.insert(23);
        arrDups.insert(21);
        arrDups.insert(66);
        arrDups.insert(144);
        arrDups.insert(13);

        arrDups.display();
        arrDups.insertSortNoDups();
        arrDups.display();
        // 15 13 14 14 135 155 66 14 135 23 144 14 23 21 66 144 13
        // 13 14 15 21 23 66 135 144 155

        // 3.5
        arrCount.insert(11);
        arrCount.insert(13);
        arrCount.insert(15);
        arrCount.insert(17);
        arrCount.insert(19);
        arrCount.insert(21);
        arrCount.insert(23);
        arrCount.insert(25);
        arrCount.insert(16);
        arrCount.insert(12);
        arrCount.insert(20);
        arrCount.insert(18);
        arrCount.insert(24);
        arrCount.insert(27);
        arrCount.insert(31);
        arrCount.insert(9);
        arrCount.insert(7);
        arrCount.insert(8);
        arrCount.insert(5);
        arrCount.insert(6);

        arrCount.display();
        arrCount.insertionSortCount();
        arrCount.display();
        // copiesQuantity: 105
        // comparisonsQuantity: 121
        // 5 6 7 8 9 11 12 13 15 16 17 18 19 20 21 23 24 25 27 31
    }
}