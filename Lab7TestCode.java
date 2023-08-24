import java.util.Arrays;

// Class for testing Patient and PatientComparator class implementations
public class Lab7TestCode {
   public static void main(String[] args) {
      // create and initialize an array of String objects for the patient names
      String[] names = { "Tom", "Mary", "George", "Peter", "Jean", "Kim", "Jack" };
      // create an array to store the Patient objects
      Patient[] patients = new Patient[names.length];
      // create the Patient objects and store them in the patients array
      for (int i = 0; i < patients.length; i++) {
         // priority is a randomly generated integer value in the range [1, 5]
         int priority = 1 + (int) (5 * Math.random());
         // the arrival order of the patient to the registration desk
         int arrivalOrder = i + 1;
         // create the patient
         Patient patient = new Patient(names[i], priority, arrivalOrder);
         // store the patient in the patients array
         patients[i] = patient;
      }
      // print the patients array on the console
      System.out.println("Patients before sorting:\n" + Arrays.toString(patients));

      // Testing the Comparable interface implemented in the Patient class
      // -----------------------------------------------------------------------
      // create a default priority queue of patients based on on the natural
      // ordering of the Patient objects determined by the compareTo method
      // implemented for the Comparator interface
      MyPriorityQueue<Patient> priorityQueue1 = new MyPriorityQueue<>();
      // add all the patients in the patients array to the priority queue
      for (int i = 0; i < patients.length; i++)
         priorityQueue1.enqueue(patients[i]);
      System.out.println("\nPatients after sorting (Comparable):");
      // dequeue and print the first patient in the priority queue
      System.out.print(priorityQueue1.dequeue());
      // dequeue and print the remaining patients in the priority queue
      while (!priorityQueue1.isEmpty())
         // printing an arrow to show the ordering in the priority queue
         System.out.print(" <- " + priorityQueue1.dequeue());

      // Testing the PatientComparator class that implements a Comparator
      // -----------------------------------------------------------------------
      // create a patient comparator
      PatientComparator comparator = new PatientComparator();
      // create a priority queue based on the PatientComparator comparator
      MyPriorityQueue<Patient> priorityQueue2 = new MyPriorityQueue<>(comparator);
      // add all the patients in the patients array to the priority queue
      for (int i = 0; i < patients.length; i++)
         priorityQueue2.enqueue(patients[i]);
      System.out.println("\n\nPatients after sorting (Comparator):");
      // dequeue and print the first patient in the priority queue
      System.out.print(priorityQueue2.dequeue());
      // dequeue and print the remaining patients in the priority queue
      while (!priorityQueue2.isEmpty())
         // printing an arrow to show the ordering in the priority queue
         System.out.print(" <- " + priorityQueue2.dequeue());
   }
}