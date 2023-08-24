// A program that demonstrates the capabilities of the MyStack<E> class.
public class MyStackDemo {
   public static void main(String[] args) {
      // create a stack that can store 3 integer elements
      // by giving 3 as the capacity input argument of the constructor
      MyStack<Integer> stack = new MyStack<>(3);

      // push each number from 0 until 10 to the stack and print the stack
      for (int num = 0; num < 10; num++) {
         stack.push(num);
         System.out.println(num + " is pushed. Stack: top -> " + stack);
      }
      System.out.println(); // adding a new line

      // pop each number in the stack and print the stack
      while (!stack.isEmpty()) { // loop until the stack becomes empty
         System.out.println(stack.peek() + " is the top element in the stack.");
         System.out.println(stack.pop() + " is popped. Stack: top -> " + stack);
      }
   }
}

