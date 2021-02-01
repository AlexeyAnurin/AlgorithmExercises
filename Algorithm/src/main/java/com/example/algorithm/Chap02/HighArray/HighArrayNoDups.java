package com.example.algorithm.Chap02.HighArray;

////////////////////////////////////////////////////////////////
class HighArrayNoDups
   {
   private long[] myArray;           // ref to array
   private int nElems;               // number of data items

   public HighArrayNoDups(int max)         // constructor
      {
      myArray = new long[max];                 // create the array
      nElems = 0;                        // no items yet
      }

   public void insert(long value)    // put element into array
      {
      myArray[nElems] = value;             // insert it
      nElems++;                      // increment size
      }
   //-----------------------------------------------------------
   public boolean delete(long value)
      {
      int j;
      for(j=0; j<nElems; j++)        // look for it
         if( value == myArray[j] )
            break;
      if(j==nElems)                  // can't find it
         return false;
      else                           // found it
         {
         for(int k=j; k<nElems; k++) // move higher ones down
            myArray[k] = myArray[k+1];
         nElems--;                   // decrement size
         return true;
         }
      }  // end delete()
   //-----------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(myArray[j] + " ");  // display it
      System.out.println("");
      }
   //-----------------------------------------------------------

      // 2.6
      public int findFirstEncounter(long searchKey) {   // find specified value
         int j;
         for(j=0; j<nElems; j++) {          // for each element,
            if (myArray[j] == searchKey) {
               return j+1;
            }
         }
            return 0;
      }

      // 2.6
      public boolean deleteDuplicates(long searchKey,int startIndex) {                              // find specified value
         int j;
         for(j=startIndex; j<nElems; j++){            // for each element,
            if(myArray[j] == searchKey)           // found item?
            delete(myArray[j]);
         }

         if(j == nElems)                    // gone to end?
            return false;                   // yes, can't find it
         else
            return true;                    // no, found it
      }

      // 2.6
      public void noDups(){
         int j;
         for (j = 0; j<nElems; j++) {
            int fistEncounterIndex = this.findFirstEncounter(this.myArray[j]);
            if (fistEncounterIndex != 0) {
               deleteDuplicates(this.myArray[j], fistEncounterIndex);
            }
            this.display();
         }
      }
   }

////////////////////////////////////////////////////////////////
class HighArrayAppNoDups
   {
   public static void main(String[] args)
      {
      int maxSize = 100;            // array size
      HighArrayNoDups arr;                // reference to array
      arr = new HighArrayNoDups(maxSize); // create the array

      arr.insert(11);
      arr.insert(22);
      arr.insert(55);
      arr.insert(33);
      arr.insert(55);
      arr.insert(55);
      arr.insert(11);
      arr.insert(55);
      arr.insert(22);
      arr.insert(44);
      arr.insert(33);

         arr.display(); // display items
         // 2.6
         arr.noDups();

      }
   }
