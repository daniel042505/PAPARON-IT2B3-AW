
package it2b.paparon.purok;
import java.util.Scanner;

public class IT2BPAPARONPUROK {

    public static void main(String[] args) {
    
        int cho;
        Scanner sc = new Scanner(System.in);

       
        do {
            System.out.println("  |---------------------------------------------|");
            System.out.println("1.|                   Members                   |");
            System.out.println("2.|                  Activities                 |");
            System.out.println("3.|                  Attendance                 |");
            System.out.println("4.|                    Exit                     |");
            System.out.println("  |---------------------------------------------|");
            System.out.print("Enter choice: ");
            cho = sc.nextInt();
            sc.nextLine();  

          
            if (cho == 1) {
                members.handleMenu(sc);
            }
          
            else if (cho == 2) {
                activities.handleMenu(sc);
            }
        
            else if (cho == 3) {
               attendance.handleMenu(sc);
            }
            else if  (cho == 4) {
                 System.out.println("Thank you! Exiting program.");
            }
            
            else{
                     System.out.println("Invalid choice, please try again.");
                    }
        } while (cho != 3);

        sc.close();
    }
}
