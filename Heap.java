import java.util.*;

// A class that implements the heap data structure for the generic type E.
public class Heap<E> {
   // data fields
   // --------------------------------------------------------------------------
   private ArrayList<E> list = new ArrayList<>(); // to store the elements
   private Comparator<E> c; // to compare the elements
   private boolean maxHeap = true; // heap type (max or min, default: max)

   // constructors
   // --------------------------------------------------------------------------
   // creates a default heap using a natural order for comparisons assuming that
   // the type E implements the Comparable interface
   public Heap() {
      c = new DefaultComparator<E>();
   }

   // creates a heap with a given comparator
   public Heap(Comparator<E> c) {
      this.c = c;
   }

   // methods that are used inside the class
   // --------------------------------------------------------------------------
   // returns the index of the parent node of the node at the given index i
   private int parent(int i) {
      return (i - 1) / 2;
   }

   // returns the index of the left child node of the node at the given index i
   private int leftChild(int i) {
      return 2 * i + 1;
   }

   // returns the index of the right child node of the node at the given index i
   private int rightChild(int i) {
      return 2 * i + 2;
   }

   // returns true if the node at the index i has a left child; false otherwise
   private boolean hasLeftChild(int i) {
      return leftChild(i) < list.size();
   }

   // returns true if the node at the index i has a right child; false otherwise
   private boolean hasRightChild(int i) {
      return rightChild(i) < list.size();
   }

   // swaps the two nodes specified by the given two indexes
   private void swap(int i, int j) {
      E temp = list.get(i);
      list.set(i, list.get(j));
      list.set(j, temp);
   }

   // methods that are accessible from outside the class
   // --------------------------------------------------------------------------
   // returns the number of the elements in the heap
   public int getSize() {
      return list.size();
   }

   // returns true if the heap is empty and false otherwise
   public boolean isEmpty() {
      return list.size() == 0;
   }

   // switches the type of the heap between the max heap and the min heap
   public void switchHeapType() {
      maxHeap = !maxHeap;
   }

   // adds a new object to the heap
   public void add(E newObject) {
      // add the given object to the heap as the last heap node
      list.add(newObject); // appending newObject to the internal array list
      // upheap: rebuild the tree by continuously swapping the newly added node
      // with its parent as needed (current (the index of the current node) is
      // initialized as the index of the last node which is the newly added node)
      int current = list.size() - 1;
      while (current > 0) {
         int parent = parent(current);
         // max heap -> swap if the current object is greater than its parent
         if (maxHeap && c.compare(list.get(current), list.get(parent)) > 0)
            swap(current, parent);
         // min heap -> swap if the current object is smaller than its parent
         else if (!maxHeap && c.compare(list.get(current), list.get(parent)) < 0)
            swap(current, parent);
         else
            break; // the tree is a heap now (no more swap is necessary)
         // update the index of the current node after each swap
         current = parent;
      }
   }

   // returns the root node of the heap without removing it
   public E peek() {
      // return null if the heap is empty
      if (list.size() == 0)
         return null;
      return list.get(0);
   }

   // removes and returns the root node of the heap
   public E remove() {
      // return null if the heap is empty
      if (list.size() == 0)
         return null;
      // store the root node to be able to return it after it is removed
      E removedObject = list.get(0);
      // replace the root node with the last node
      list.set(0, list.get(list.size() - 1));
      // remove the last node from the heap
      list.remove(list.size() - 1);
      // downheap: rebuild the tree by continuously swapping the current node
      // with its larger (max heap) or smaller (min heap) child as needed
      int current = 0; // starting from the root node
      while (true) {
         // to store the index of the larger (max heap) / smaller (min heap) child
         int selected;
         // if no child node exists for the current node
         if (!hasLeftChild(current))
            break; // the tree is a heap now (no more swap is necessary)
         // if only the left child node exists for the current node
         else if (!hasRightChild(current))
            // the left child will be compared with the current node
            selected = leftChild(current);
         // if both child nodes exist for the current node
         else {
            // select the larger child (max heap) or the smaller child (min heap)
            // for comparing with the current node
            int left = leftChild(current);
            int right = rightChild(current);
            // max heap -> select the larger child node
            if (maxHeap) {
               if (c.compare(list.get(right), list.get(left)) > 0)
                  selected = right;
               else
                  selected = left;
            }
            // min heap -> select the smaller child node
            else {
               if (c.compare(list.get(right), list.get(left)) < 0)
                  selected = right;
               else
                  selected = left;
            }
         }
         // swap if the current node is smaller (max heap) or larger (min heap)
         // than the selected child node
         if (maxHeap && c.compare(list.get(current), list.get(selected)) < 0
            || !maxHeap && c.compare(list.get(current), list.get(selected)) > 0) {
            swap(current, selected);
            current = selected; // update the index of the current node
         } else
            break; // the tree is a heap now (no more swap is necessary)
      }
      // return the removed root node that was stored in the variable removedObject
      return removedObject;
   }
}