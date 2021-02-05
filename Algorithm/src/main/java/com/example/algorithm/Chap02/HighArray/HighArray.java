package com.example.algorithm.Chap02.HighArray;

////////////////////////////////////////////////////////////////
class HighArray
   {
   private long[] myArray;           // ref to array
   private int nElems;               // number of data items
   //-----------------------------------------------------------
      //! getMax()
      public long getMax(){
         long maxVal = 0;
         int x;

         if(nElems == 0) {
            return -1;
         }

         for(x=0; x<nElems; x++) {
            if(myArray[x] > maxVal)
               maxVal = myArray[x];
         }
         return maxVal;
      }

      //////////////////
      //! removeMax()
     public long removeMax(){
      long maxVal = getMax();
      delete(maxVal);
      return maxVal;
     }

      /////////////////
   public HighArray(int max)         // constructor
      {
      myArray = new long[max];                 // create the array
      nElems = 0;                        // no items yet
      }
   //-----------------------------------------------------------
   public boolean find(long searchKey)
      {                              // find specified value
      int j;
      for(j=0; j<nElems; j++)            // for each element,
         if(myArray[j] == searchKey)           // found item?
            break;                       // exit loop before end
      if(j == nElems)                    // gone to end?
         return false;                   // yes, can't find it
      else
         return true;                    // no, found it
      }  // end find()
   //-----------------------------------------------------------
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
        // if (j == nElems)
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
      }  // end deleteDuplicates()

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

   }  // end class HighArray

////////////////////////////////////////////////////////////////
class HighArrayApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;            // array size
      HighArray arr;                // reference to array
      arr = new HighArray(maxSize); // create the array

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


      arr.display();                // display items
//////////////////////
 /*        // 2.1
           System.out.println("Max: " + arr.getMax());

         // 2.2
           System.out.println("MaxRemove: " + arr.removeMax());

         // 2.3
         arr.display();
         HighArray choiseSortArray = new HighArray(maxSize);
         while (arr.getMax() != -1){
            choiseSortArray.insert(arr.removeMax());
            arr.display();
            choiseSortArray.display();
         }

//////////////////

      int searchKey = 35;           // search for item
      if( arr.find(searchKey) )
         System.out.println("Found " + searchKey);
      else
         System.out.println("Can't find " + searchKey);

      arr.delete(00);               // delete 3 items
      arr.delete(55);
      arr.delete(99);

      arr.display();                // display items again*/

         // 2.6
         arr.noDups();

      }  // end main()
   }  // end class HighArrayApp
