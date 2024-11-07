
package it2b.paparon.purok;
import java.util.Scanner;
public class members {
    


    public static void handleMenu(Scanner sc) {
       
        int choice;

        do {
            System.out.println("|---------------------------------------------|");
            System.out.println("|                   Members                   |");
            System.out.println("|---------------------------------------------|");
            System.out.println("1. Add Members");
            System.out.println("2. View Members");
            System.out.println("3. Update Members");
            System.out.println("4. Delete Members");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1:
                    addMembers(sc);
                    break;
                case 2:
                    viewMembers();
                    break;
                case 3:
                    updateMembers(sc);
                    break;
                case 4:
                    deleteMembers(sc);
                    break;
                case 5:
                    System.out.println("Back to Main Menu.");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 5);
    }

   
    private static void addMembers(Scanner sc) {
        
        System.out.print("How many members would you like to add?:  ");
        int numberOfMembers = sc.nextInt();
        sc.nextLine();  

        for (int i = 1; i <= numberOfMembers; i++) {
            System.out.println("Enter details for member " + i + ":");

            System.out.print("Enter First Name: ");
            String fname = sc.nextLine();
            System.out.print("Enter Last Name: ");
            String lname = sc.nextLine();
            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine();  // Clear the buffer
            System.out.print("Enter Gender: ");
            String gender = sc.nextLine();
            System.out.print("Enter Status: ");
            String status = sc.nextLine();
            
            
            config conf = new config();
            String sql = "INSERT INTO tbl_members (s_fname, s_lastname, s_age, s_gender, s_Status) VALUES (?, ?, ?, ?, ?)";
            conf.addRecord(sql, fname, lname, age, gender, status);
        }

        System.out.println(numberOfMembers + " members have been added.");
    }

   
    private static void viewMembers() {
        String sqlQuery = "SELECT * FROM tbl_members";
        String[] columnHeaders = {"ID", "FirstName", "Lastname", "Age", "Gender", "Status"};
        String[] columnNames = {"s_hid", "s_fname", "s_lastname", "s_age", "s_gender", "s_Status"};
        
        config conf = new config();
        conf.viewRecords(sqlQuery, columnHeaders, columnNames);
    }


    private static void updateMembers(Scanner sc) {
        System.out.print("Enter the ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();  
        System.out.print("Enter new First Name: ");
        String nfname = sc.nextLine();
        System.out.print("Enter new Last Name: ");
        String nlname = sc.nextLine();
        System.out.print("Enter new Age: ");
        int age = sc.nextInt();
        sc.nextLine();  
        System.out.print("Enter Gender: ");
        String gend = sc.nextLine();
        System.out.print("Enter new Status: ");
        String nstatus = sc.nextLine();
        
        String qry = "UPDATE tbl_members SET s_fname = ?, s_lastname = ?, s_age = ?, s_gender = ?, s_Status = ? WHERE s_hid = ?";
        
        config conf = new config();
        conf.updateRecord(qry, nfname, nlname, age, gend, nstatus, id);
    }


    private static void deleteMembers(Scanner sc) {
        System.out.print("Enter the ID to Delete: ");
        int id = sc.nextInt();
        
        String qry = "DELETE FROM tbl_members WHERE s_hid = ?";
        
        config conf = new config();
        conf.deleteRecord(qry, id);
    }
}

