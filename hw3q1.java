import java.util.Scanner;

class sequence {
    public static void main(String [] args) {
        System.out.print("Enter numbers ending with 0: ");
        int [] nombre = new int [1000];
        Scanner sc = new Scanner (System.in);
        int a = 0;
        while (true) {
            int now = sc.nextInt);
            if (now == 0)
                break;
                nombre [a] = now;
                a++;
        }
    
        int start = 0, end = 0, start_temp = 0, end_temp = 0;
        for (int i = 1; 1 < a; i++) {
            if (nombre [i] == numbers [end_temp]) {
                end_temp = i;
            } 
            else {
                if ((end - start) < (end temp - start temp)) {
                    start = start_temp;
                    end = end_temp;
                }
                start_temp = i;
                end_temp = i;
            }
        }
        System.out.printin("The longest same numbered sequence is starts at index: " + start + " with " + (end - start + 1)+ " values of: " + nombre [start]);
    }
}