import java.util.*;

// A class that demonstrates the heap sort approach (sorting objects using a heap).
public class HeapSort {
   // sorts a given array of objects of the generic type E using a given comparator
   // in increasing or decreasing order based on the given value for ascending
   public static <E> void heapSort(E[] list, Comparator<E> c, boolean ascending) {
      // create a heap
      Heap<E> heap;
      // if the given comparator c is null
      if (c == null)
         // create a default heap to sort the given array of objects by using
         // a natural order for comparisons (assuming that the generic type E
         // implements the Comparable interface)
         heap = new Heap<>();
      // otherwise
      else
         // create a heap with the given comparator to sort the given array of
         // objects by using this comparator
         heap = new Heap<>(c);
      // switch the heap from max heap (default) to min heap if ascending is true
      if (ascending)
         heap.switchHeapType();
      // add all the elements in the given array to the heap
      for (int i = 0; i < list.length; i++)
         // the element is added to the heap and the heap is rebuild (upheap)
         heap.add(list[i]);
      // remove all the elements from the heap into the given array
      for (int i = 0; i < list.length; i++)
         // removing the root node which is the largest heap node (max heap) or
         // the smallest heap node (min heap), rebuilding the heap (downheap) and
         // placing the removed root node into the given array
         list[i] = heap.remove();
   }

   // main method that demonstrates heap sort both using comparable objects and
   // a comparator for sorting
   public static void main(String[] args) {
      // Heap sort using comparable objects
      // Example 1: The Integer class implements the Comparable interface
      // -----------------------------------------------------------------------
      System.out.println("Heap Sort Using Comparable Objects (Example 1)");
      // create an array of 10 random integers in the range [-99, 99] for sorting
      Integer[] array1 = new Integer[10];
      for (int i = 0; i < 10; i++)
         array1[i] = -99 + (int) (Math.random() * 199);
      // print the array on the console
      System.out.println("Array before sorting: " + Arrays.toString(array1));
      // sort the array in ascending (increasing) order
      boolean ascending = true;
      heapSort(array1, null, ascending);
      // print the sorted array on the console
      System.out.println("Array in ascending order: " + Arrays.toString(array1));
      // sort the array in descending (decreasing) order
      ascending = false;
      heapSort(array1, null, ascending);
      // print the sorted array on the console
      System.out.println("Array in descending order: " + Arrays.toString(array1));

      // Example 2: The GeometricObject1 class implements the Comparable interface
      // -----------------------------------------------------------------------
      System.out.println("\nHeap Sort Using Comparable Objects (Example 2)");
      // create an array of 10 random geometric objects for sorting
      GeometricObject1[] array2 = new GeometricObject1[10];
      for (int i = 0; i < 10; i++) {
         // the random object is a circle with 0.5 probability
         if (Math.random() < 0.5) {
            // the radius of the circle is created randomly in the range [1, 5)
            double radius = 1 + Math.random() * 4;
            array2[i] = new Circle1(radius);
         }
         // the random object is a rectangle with 0.5 probability
         else {
            // the width and the height are created randomly in the range [1, 9)
            double width = 1 + Math.random() * 8, height = 1 + Math.random() * 8;
            array2[i] = new Rectangle1(width, height);
         }
      }
      // print the array on the console
      System.out.println("Array before sorting: " + Arrays.toString(array2));
      // sort the array in ascending (increasing) order
      ascending = true;
      heapSort(array2, null, ascending);
      // print the sorted array on the console
      System.out.println("Array in ascending order: " + Arrays.toString(array2));
      // sort the array in descending (decreasing) order
      ascending = false;
      heapSort(array2, null, ascending);
      // print the sorted array on the console
      System.out.println("Array in descending order: " + Arrays.toString(array2));

      // Heap sort using a comparator
      // The GeometricObjectComparator class implements the Comparator interface
      // for the objects derived from the GeometricObject2 class
      // -----------------------------------------------------------------------
      System.out.println("\nHeap Sort Using a Comparator");
      // create an array of 10 random geometric objects for sorting
      GeometricObject2[] array3 = new GeometricObject2[10];
      for (int i = 0; i < 10; i++) {
         // the random object is a circle with 0.5 probability
         if (Math.random() < 0.5) {
            // the radius of the circle is created randomly in the range [1, 5)
            double radius = 1 + Math.random() * 4;
            array3[i] = new Circle2(radius);
         }
         // the random object is a rectangle with 0.5 probability
         else {
            // the width and the height are created randomly in the range [1, 9)
            double width = 1 + Math.random() * 8, height = 1 + Math.random() * 8;
            array3[i] = new Rectangle2(width, height);
         }
      }
      // print the array on the console
      System.out.println("Array before sorting: " + Arrays.toString(array3));
      // sort the array in ascending (increasing) order
      ascending = true;
      heapSort(array3, new GeometricObjectComparator(), ascending);
      // print the sorted array on the console
      System.out.println("Array in ascending order: " + Arrays.toString(array3));
      // sort the array in descending (decreasing) order
      ascending = false;
      heapSort(array3, new GeometricObjectComparator(), ascending);
      // print the sorted array on the console
      System.out.println("Array in descending order: " + Arrays.toString(array3));
   }
}