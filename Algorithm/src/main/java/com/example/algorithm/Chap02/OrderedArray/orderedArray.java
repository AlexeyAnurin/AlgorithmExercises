package com.example.algorithm.Chap02.OrderedArray;

// orderedArray.java
// demonstrates ordered array class
// to run this program: C>java OrderedApp
////////////////////////////////////////////////////////////////
class OrdArray
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
   //-----------------------------------------------------------
   public OrdArray(int max)          // constructor
      {
      a = new long[max];             // create array
      nElems = 0;
      }
   //-----------------------------------------------------------
   public int size()
      { return nElems; }
   //-----------------------------------------------------------
   public int find(long searchKey) {
      int lowerBound = 0;
      int upperBound = nElems-1;
      int currentIndex;

      while(true)
         {
         currentIndex = (lowerBound + upperBound ) / 2;
         if(a[currentIndex]==searchKey)
            return currentIndex;              // found it
         else if(lowerBound > upperBound)
            return nElems;             // can't find it
         else                          // divide range
            {
            if(a[currentIndex] < searchKey)
               lowerBound = currentIndex + 1; // it's in upper half
            else
               upperBound = currentIndex - 1; // it's in lower half
            }  // end else divide range
         }  // end while
      }  // end find()
   //-----------------------------------------------------------
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
      }  // end insert()

     /* //! 2.4 РАСКОММЕНТИРУЙ! Это ДВОИЧНЫЙ ПОИСК
      public void insert(int value) {
         int lowerBound = 0;
         int upperBound = nElems - 1;
         int j = 0;

         while(true) {

            if(lowerBound > upperBound) break;
            j = (lowerBound + upperBound) / 2;

            if(value > a[j]) {
               lowerBound = j + 1;
               j++;
            }
            else upperBound = j - 1;
         }

         for(int k=nElems; k>j; k--)
            a[k] = a[k-1];

         a[j] = value;
         nElems++;
      }*/

      //-----------------------------------------------------------
   public boolean delete(long value)
      {
      int j = find(value);
      if(j==nElems)                  // can't find it
         return false;
      else                           // found it
         {
         for(int k=j; k<nElems; k++) // move bigger ones down
            a[k] = a[k+1];
         nElems--;                   // decrement size
         return true;
         }
      }  // end delete()
   //-----------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
   //-----------------------------------------------------------

      // 4.5
      public void merge(OrdArray arr1, OrdArray arr2) {

         int indexArr1=0;
         int indexArr2=0;

         long tempValArr1 = 0;
         long tempValArr2 = 0;

         int arr1Elements = arr1.nElems;
         int arr2Elements = arr2.nElems;


         for (int x=0; x<arr1.nElems+arr2.nElems; x++) {

               if (arr1Elements == 0) {
                  for (int y=indexArr2; y<arr2.nElems; y++) {
                     this.insert(arr2.a[y]);
                     arr2Elements--;
                  }

               }
               if (arr2Elements == 0) {
                  for (int y=indexArr1; y<arr1.nElems; y++) {
                     this.insert(arr1.a[y]);
                     arr1Elements--;
                  }
               }

            if(indexArr1 == indexArr2) {
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
            } else if(indexArr1 > indexArr2) {
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
            } else {
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
   }  // end class OrdArray

////////////////////////////////////////////////////////////////
class OrderedApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;             // array size
      OrdArray arr;                  // reference to array
      OrdArray arr1;                  // reference to array
      OrdArray arr2;                  // reference to array
      OrdArray sumArr;                  // reference to array
      arr = new OrdArray(maxSize);   // create the array

      arr1 = new OrdArray(maxSize);   // create the array
      arr2 = new OrdArray(maxSize);   // create the array
      sumArr = new OrdArray(maxSize);   // create the array

      arr.insert(77);                // insert 10 items
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);

      // merge
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



         sumArr.merge(arr1, arr2);

      int searchKey = 55;            // search for item
      if( arr.find(searchKey) != arr.size() )
         System.out.println("Found " + searchKey);
      else
         System.out.println("Can't find " + searchKey);

      arr.display();                 // display items

      arr.delete(00);                // delete 3 items
      arr.delete(55);
      arr.delete(99);

      arr.display();                 // display items again
      }  // end main()
   }  // end class OrderedApp
