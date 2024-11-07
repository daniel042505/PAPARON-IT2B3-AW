package it2b.paparon.purok;

import java.sql.SQLException;
import java.util.Scanner;

public class attendance {

    public static void handleMenu(Scanner sc) {
        int choice;

        do {
            System.out.println("|---------------------------------------------|");
            System.out.println("|                  Attendance                 |");
            System.out.println("|---------------------------------------------|");
            System.out.println("1. Record Attendance");
            System.out.println("2. View Attendance");
            System.out.println("3. Update Attendance");
            System.out.println("4. Delete Attendance");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1:
                    recordAttendance(sc);
                    break;
                case 2:
                    viewAttendance(sc);
                    break;
                case 3:
                    updateAttendance(sc);
                    break;
                case 4:
                    deleteAttendance(sc);
                    break;
                case 5:
                    System.out.println("Back to Main Menu.");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 5);
    }

    private static void recordAttendance(Scanner sc) {
        System.out.print("Enter Member ID: ");
        int memberId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Activity ID: ");
        int activityId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Attendanc   e Status: ");
        String status = sc.nextLine();

        config conf = new config();
        String sql = "INSERT INTO tbl_attendance (m_id, a_id,  s_status) VALUES (?, ?, ?)";
        conf.addRecord(sql, memberId, activityId, status);
        
        System.out.println("Attendance recorded successfully.");
    }

    private static void viewAttendance(Scanner sc) {

        
            viewAllAttendance();
         
        }
    

 private static void viewAllAttendance() {
    String sqlQuery = "SELECT * FROM tbl_attendance "
            + "JOIN tbl_members ON tbl_attendance.s_hid = tbl_members.s_hid "
            + "JOIN tbl_activities ON tbl_attendance.s_id = tbl_activities.s_id";
    
    String[] attendanceHeaders = {"Attendance ID", "First Name", "Last Name", "Date", "Status"};
    String[] attendanceColumns = {"a_id", "s_fname", "s_lastname", "s_date", "status"};

    config conf = new config();
    conf.viewRecords(sqlQuery, attendanceHeaders, attendanceColumns);
}
    

   

    private static void updateAttendance(Scanner sc) {
        System.out.print("Enter the Attendance ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new Member ID: ");
        int memberId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new Activity ID: ");
        int activityId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new Date: ");
        String date = sc.nextLine();
        System.out.print("Enter new Status: ");
        String status = sc.nextLine();

        String qry = "UPDATE tbl_attendance SET m_id = ?, a_id = ?, s_date = ?, s_status = ? WHERE s_id = ?";
        config conf = new config();
        conf.updateRecord(qry, memberId, activityId, date, status, id);
        
        System.out.println("Attendance updated successfully.");
    }

    private static void deleteAttendance(Scanner sc) {
        System.out.print("Enter the Attendance ID to Delete: ");
        int id = sc.nextInt();

        String qry = "DELETE FROM tbl_attendance WHERE s_id = ?";
        config conf = new config();
        conf.deleteRecord(qry, id);
        
        System.out.println("Attendance record deleted successfully.");
    }
}
