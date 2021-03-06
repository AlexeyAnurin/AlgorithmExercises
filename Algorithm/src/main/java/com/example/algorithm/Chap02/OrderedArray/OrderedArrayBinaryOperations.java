package com.example.algorithm.Chap02.OrderedArray;

class OrdArrayBinary
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
   //-----------------------------------------------------------
   public OrdArrayBinary(int max)          // constructor
      {
      a = new long[max];             // create array
      nElems = 0;
      }
   //-----------------------------------------------------------
   public int size()
      { return nElems; }
   //-----------------------------------------------------------
   //  2.4 Binary search
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
            }
         }
      }
   //-----------------------------------------------------------

      //  2.4 Binary insert
      public void insertBinary(int value) {
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
      }

      //  2.4 Binary delete
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
      }
   //-----------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
   }

////////////////////////////////////////////////////////////////
class OrderedAppBinary
   {
   public static void main(String[] args)
      {
      int maxSize = 100;             // array size
      OrdArrayBinary arr;                  // reference to array
      arr = new OrdArrayBinary(maxSize);   // create the array

      arr.insertBinary(77);
      arr.insertBinary(99);
      arr.insertBinary(44);
      arr.insertBinary(55);
      arr.insertBinary(22);
      arr.insertBinary(88);
      arr.insertBinary(11);
      arr.insertBinary(00);
      arr.insertBinary(66);
      arr.insertBinary(33);

      int searchKey = 55;            // search for item
      if( arr.find(searchKey) != arr.size() )
         System.out.println("Found " + searchKey);
      else
         System.out.println("Can't find " + searchKey);

      arr.display();                 // display items

      arr.delete(00);                // delete 3 items
      arr.delete(55);
      arr.delete(99);

      arr.display();
      }
   }
