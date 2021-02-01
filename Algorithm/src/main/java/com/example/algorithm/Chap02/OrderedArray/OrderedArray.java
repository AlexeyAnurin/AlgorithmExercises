package com.example.algorithm.Chap02.OrderedArray;

class OrdArray
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items

   public OrdArray(int max)          // constructor
      {
      a = new long[max];             // create array
      nElems = 0;
      }

   public void insert(long value)    // put element into array
      {

      int j;
      for(j=0; j<nElems; j++)        // find where it goes
         if(a[j] > value)            // (linear search)
            break;

            for(int k=nElems; k>j; k--)    // move bigger ones up
         a[k] = a[k-1];
      a[j] = value;                  // insert it
      nElems++;                      // increment size
      }

   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }

      // 4.5 merging of two arranged arrays
      public void merge(OrdArray arr1, OrdArray arr2) {

         int indexArr1=0;
         int indexArr2=0;

         long tempValArr1 = 0;
         long tempValArr2 = 0;

         int arr1Elements = arr1.nElems;
         int arr2Elements = arr2.nElems;

         for (int x=0; x<arr1.nElems+arr2.nElems; x++) {

            // Allow to continue merging by different quantity of elements in Arrays.
            if (arr1Elements == 0) {
               for (int y=indexArr2; y<arr2.nElems; y++) {
                  this.insert(arr2.a[y]);
                  arr2Elements--;
                  x++;
               }
            }
            if (arr2Elements == 0) {
               for (int y=indexArr1; y<arr1.nElems; y++) {
                  this.insert(arr1.a[y]);
                  arr1Elements--;
                  x++;
               }
            }

            if(indexArr1 == indexArr2) {  // equality index
               if (arr1.a[indexArr1] < arr2.a[indexArr2]) {
                  this.insert(arr1.a[indexArr1]);
                  arr1Elements--;
                  tempValArr2 = arr2.a[indexArr2];
                  indexArr1++;
               } else {
                  this.insert(arr2.a[indexArr2]);
                  arr2Elements--;
                  tempValArr1 = arr1.a[indexArr1];
                  indexArr2++;
               }
            } else if(indexArr1 > indexArr2 && arr1Elements>0) { // Index Arr1 > Index Arr2
               if (arr1.a[indexArr1] < tempValArr2) {
                  this.insert(arr1.a[indexArr1]);
                  arr1Elements--;
                  indexArr1++;
               } else {
                  this.insert(tempValArr2);
                  arr2Elements--;
                  indexArr2++;
                  tempValArr2 = arr2.a[indexArr2];
               }
            } else if (indexArr1 < indexArr2 && arr2Elements>0) { // Index Arr1 < Index Arr2
               if (arr2.a[indexArr2] < tempValArr1) {
                  this.insert(arr2.a[indexArr2]);
                  arr2Elements--;
                  indexArr2++;
               } else {
                  this.insert(tempValArr1);
                  arr1Elements--;
                  indexArr1++;
                  tempValArr1 = arr1.a[indexArr1];
               }
            }
         }
         this.display();
      }
   }

////////////////////////////////////////////////////////////////
class OrderedApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;             // array size
      OrdArray arr1;                  // reference to array
      OrdArray arr2;
      OrdArray sumArr;

      arr1 = new OrdArray(maxSize);   // create the array
      arr2 = new OrdArray(maxSize);
      sumArr = new OrdArray(maxSize);

      // 2.6 create arrays for merge
         arr1.insert(21);
         arr1.insert(23);
         arr1.insert(45);
         arr1.insert(100);
         arr1.insert(101);
         arr1.insert(300);
         arr1.insert(301);

         arr2.insert(22);
         arr2.insert(44);
         arr2.insert(441);
         arr2.insert(445);
         arr2.insert(447);
         arr2.insert(448);
         arr2.insert(449);
         // merging of arrays
         sumArr.merge(arr1, arr2); //  21 22 23 44 45 100 101 300 301 441 445 447 448 449

      }
   }
