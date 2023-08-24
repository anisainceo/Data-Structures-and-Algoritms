import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Patient implements Comparable<Patient> {
    String name;
    int priority;
    int arrivalOrder;

    Patient(String name, int priority, int arrivalOrder) {
        this.name = name;
        this.priority = priority;
        this.arrivalOrder = arrivalOrder;
    }

    @Override
    public String toString() {
        return name + "(P=" + priority + " and #" + arrivalOrder + ")";
    }

    @Override
    public int compareTo(Patient o) {
        return o.priority - this.priority;
    }

}

class PatientComparator implements Comparator<Patient> {

    @Override
    public int compare(Patient o1, Patient o2) {
        return o2.priority - o1.priority;
    }

}

// Class for testing class implementations
class Lab9TestCode {
    public static void main(String[] args) {

        String[] names = { "Tom", "Mary", "George", "Peter", "Jean", "Kim", "Jack" };

        Patient[] patients = new Patient[names.length];

        for (int i = 0; i < patients.length; i++) {

            int priority = 1 + (int) (5 * Math.random());

            int arrivalOrder = i + 1;

            Patient patient = new Patient(names[i], priority, arrivalOrder);

            patients[i] = patient;
        }

        System.out.println("Patients before sorting:\n" + Arrays.toString(patients));


        PriorityQueue<Patient> priorityQueue1 = new PriorityQueue<>();

        for (int i = 0; i < patients.length; i++)
            priorityQueue1.add(patients[i]);
        System.out.println("\nPatients after sorting (Comparable):");

        System.out.print(priorityQueue1.poll());

        while (!priorityQueue1.isEmpty())

            System.out.print(" <- " + priorityQueue1.poll());

        PatientComparator comparator = new PatientComparator();

        PriorityQueue<Patient> priorityQueue2 = new PriorityQueue<>(comparator);

        for (int i = 0; i < patients.length; i++)
            priorityQueue2.add(patients[i]);
        System.out.println("\n\nPatients after sorting (Comparator):");

        System.out.print(priorityQueue2.poll());

        while (!priorityQueue2.isEmpty())

            System.out.print(" <- " + priorityQueue2.poll());
    }
}
