package it2b.paparon.purok;

import java.util.Scanner;

public class activities {

    public static void handleMenu(Scanner sc) {
        int choice;

        do {
            System.out.println("|---------------------------------------------|");
            System.out.println("|                  Activities                 |");
            System.out.println("|---------------------------------------------|");
            System.out.println("1. Add Activity");
            System.out.println("2. View Activities");
            System.out.println("3. Update Activity");
            System.out.println("4. Delete Activity");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1:
                    addActivity(sc);
                    break;
                case 2:
                    viewActivities(sc); 
                    break;
                case 3:
                    updateActivities(sc);
                    break;
                case 4:
                    deleteActivities(sc);
                    break;
                case 5:
                    System.out.println("Back to Main Menu.");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 5);
    }

    
     private static void addActivity(Scanner sc) {
        System.out.print("Enter Activity Name: ");
        String activityName = sc.nextLine();
        System.out.print("Enter Activity Date: ");
        String activityDate = sc.nextLine();
        System.out.print("Enter Activity Location: ");
        String activityLocation = sc.nextLine();
        
        config conf = new config();
        String sql = "INSERT INTO tbl_activities (s_name, s_date, s_loc) VALUES (?, ?, ?)";
        conf.addRecord(sql, activityName, activityDate, activityLocation);
    }


    private static void viewActivities(Scanner sc) {
        System.out.println("|---------------------------------------------|");
        System.out.println("1. View All Activities");
        System.out.println("2. View Activity by ID");
        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); 

        if (choice == 1) {
            viewAllActivities();
        } else if (choice == 2) {
            System.out.print("Enter Activity ID: ");
            int id = sc.nextInt();
            sc.nextLine();  
            viewActivityById(id);
        } else {
            System.out.println("Invalid choice. Returning to menu.");
        }
    }


    private static void viewAllActivities() {
        String sqlQuery = "SELECT * FROM tbl_activities";
        String[] columnHeaders = {"ID", "Activity Name", "Date", "Location"};
        String[] columnNames = {"s_id", "s_name", "s_date", "s_loc"};
        
        config conf = new config();
        conf.viewRecords(sqlQuery, columnHeaders, columnNames);
    }

 
    private static void viewActivityById(int id) {
        String sqlQuery = "SELECT * FROM tbl_activities WHERE s_id = ?";
        String[] columnHeaders = {"ID", "Activity Name", "Date", "Location"};
        String[] columnNames = {"s_id", "s_name", "s_date", "s_loc"};
        
        config conf = new config();
        conf.viewRecordsById(sqlQuery, columnHeaders, columnNames, id);
    }

    
    private static void updateActivities(Scanner sc) {
        System.out.print("Enter the Activity ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();  // Clear the buffer
        System.out.print("Enter new Activity Name: ");
        String newName = sc.nextLine();
        System.out.print("Enter new Activity Date: ");
        String newDate = sc.nextLine();
        System.out.print("Enter new Activity Location: ");
        String newLocation = sc.nextLine();

        String qry = "UPDATE tbl_activities SET s_name = ?, s_date = ?, s_loc = ? WHERE s_id = ?";
        config conf = new config();
        conf.updateRecord(qry, newName, newDate, newLocation, id);
    }

  
    private static void deleteActivities(Scanner sc) {
        System.out.print("Enter the Activity ID to Delete: ");
        int id = sc.nextInt();
        String qry = "DELETE FROM tbl_activities WHERE s_id = ?";
        config conf = new config();
        conf.deleteRecord(qry, id);
    }
}
