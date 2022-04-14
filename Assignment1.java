//Name: Connor Noonan
//Student ID: 101316377

package assignment1;
import java.util.*;

public class Assignment1 {
    
    public static void main(String[] args) {
       Random rand = new Random();
       int arraySize = 1000000;
       int searchVal = 2500000;
       
       coreData ss = new coreData(arraySize);
       coreData is = new coreData(arraySize);
       coreData ms = new coreData(arraySize);
       coreData qs = new coreData(arraySize);
       
       coreData bs = new coreData(arraySize);
       coreData ls = new coreData(arraySize);
       
       for (int x=0; x<arraySize; x++) {
           int val = rand.nextInt(2000000);
           //ss.addLast(val);
           //is.addLast(val);
           //ms.addLast(val);
           //qs.addLast(val);
           
           bs.addInOrder(val);
           ls.addInOrder(val);
       }
       
        long start = System.nanoTime();
        ss.selectionSort();
        long end = System.nanoTime();
        long timeTaken = end-start;
        System.out.println("The selection sort took "+timeTaken+" nanoseconds.");

        start = System.nanoTime();
        is.insertionSort();
        end = System.nanoTime();
        timeTaken = end-start;
        System.out.println("The insertion sort took "+timeTaken+" nanoseconds.");
        
        start = System.nanoTime();
        ms.mergeSort();
        end = System.nanoTime();
        timeTaken = end-start;
        System.out.println("The merge sort took "+timeTaken+" nanoseconds.");
        
        start = System.nanoTime();
        qs.quickSort();
        end = System.nanoTime();
        timeTaken = end-start;
        System.out.println("The quick sort took "+timeTaken+" nanoseconds.");
        
        System.out.println("--------------------------------");
        
        start = System.nanoTime();
        bs.binarySearch(searchVal);
        end = System.nanoTime();
        timeTaken = end-start;
        System.out.println("The binary search took "+timeTaken+" nanoseconds.");
        
        start = System.nanoTime();
        ls.linearSearch(searchVal);
        end = System.nanoTime();
        timeTaken = end-start;
        System.out.println("The linear search took "+timeTaken+" nanoseconds.");
       
        
    }
    
}
