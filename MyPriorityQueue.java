import java.util.Comparator;

// A class that implements the priority queue data structure by using a heap.
// E is a generic type.
public class MyPriorityQueue<E> {
   // data field
   private Heap<E> heap; // for storing the elements based on their priorities

   // constructor that creates a default priority queue
   public MyPriorityQueue() {
      // using the default constructor of the Heap class to create a default heap
      // based on the natural ordering of the elements assuming that the type E
      // implements the Comparable interface
      heap = new Heap<E>();
   }

   // constructor that creates a priority queue based on a given comparator
   public MyPriorityQueue(Comparator<E> c) {
      // using the parameterized constructor of the Heap class to create a heap
      // based on the given comparator for ordering the elements
      heap = new Heap<E>(c);
   }

   // method that adds a given element to the queue based on its priority
   public void enqueue(E newElement) {
      // the element is added to the heap and the heap is rebuild (upheap)
      heap.add(newElement);
   }

   // method that returns the element with the highest priority
   public E peek() {
      // the root element is obtained by using the peek method of the Heap class
      return heap.peek();
   }

   // method that removes the element with the highest priority from the queue
   // and returns the removed element
   public E dequeue() {
      // the root element is removed from the heap, the heap is rebuild (downheap)
      // and the removed root element is returned
      return heap.remove();
   }

   // method that returns the number of the elements in the queue
   public int getSize() {
      return heap.getSize();
   }

   // method that returns true if the queue is empty and false otherwise
   public boolean isEmpty() {
      return heap.isEmpty();
   }
}