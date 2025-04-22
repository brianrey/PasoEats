import java.util.Scanner;

public class UserInterface {
    private Manager manager;
    private Scanner scanner;

    public UserInterface(Manager manager) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        welcomeMessage();

        // Main loop for the user interface
        while (true) {
            
            mainMenu();

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manageStudents();
                    break;
                case 2:
                    manageAssignments();
                    break;
                case 3:
                    manageInstructors();
                    break;
                case 4:
                    manageCourses();
                    break;
                case 5:
                    exportData();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void welcomeMessage() {
        // Display the welcome message and version information
        System.out.println("--------------------------------------------");
        System.out.println("Welcome to the Student Management System.");
        System.out.println("Developed by: PasoEATS");
        System.out.println("Version: 0.0+dev");
        System.out.println("--------------------------------------------");
        System.out.println("");
    }

    private void mainMenu() {
        // Display the main menu options
        System.out.println("What action would you like to take?");
        System.out.println("   1: Manage Students");
        System.out.println("   2: Manage Assignments");
        System.out.println("   3: Manage Instructors");
        System.out.println("   4: Manage Courses");
        System.out.println("   5: Export Data");
        System.out.println("   6: Exit");
        System.out.print("Please select an option: ");
    }

    private void manageStudents() {
        System.out.println("");
        System.out.println("Managing students...");
        // Add logic for managing students
        // For example, adding a new student, removing a student, or displaying student details
        manager.printStudents();
        System.out.println("");
    }

    private void manageAssignments() {
        System.out.println("");
        System.out.println("Enter Student ID: ");
        // Add logic for managing assignments
        // For example, adding a new assignment, removing an assignment, or displaying assignment details by student ID
        String studentID = scanner.nextLine();

        int studentIndex = manager.getStudent(studentID);
        if (studentIndex == -1) {
            System.out.println("Student not found. No student with an ID of " + studentID + " exists.");
            System.out.println("");
            return;
        } //not sure if this can be reached`

        System.out.println("Student found: " + manager.getStudents().get(studentIndex).getName());
        Student student = manager.getStudents().get(studentIndex);
        System.out.println("");
        System.out.println("Assignment details:");
        for (int i = 0; i < student.getAssignments().size(); i++) {
            Assignment assignment = student.getAssignments().get(i);
            System.out.println((i + 1) + ": " + assignment.getAssignmentName() + ": " + assignment.getScore() + "/" + assignment.getMaxScore() + " pts");
        }

        System.out.println("");
        System.out.println("Select an assignment to modify:");
        int assignmentChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Validate the assignment choice
        if (assignmentChoice < 1 || assignmentChoice > student.getAssignments().size()) {
            System.out.println("Invalid assignment choice.");
            return;
        }

        Assignment selectedAssignment = student.getAssignments().get(assignmentChoice - 1);
        System.out.println("Would you like to change the grade? Y/N?");
        String changeGrade = scanner.nextLine();

        if (changeGrade.equalsIgnoreCase("Y")) {
            System.out.println("Please input new grade 0-100:");
            int newGrade = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            selectedAssignment.setScore(newGrade);
            System.out.println("Grade updated successfully. Grade is now: " + selectedAssignment.getScore() + "/" + selectedAssignment.getMaxScore());
        } else {
            System.out.println("No changes made. Grade remains: " + selectedAssignment.getScore() + "/" + selectedAssignment.getMaxScore());
        }
    }

    private void manageInstructors() {
        System.out.println("Managing instructors...");
        // Add logic for managing instructors
        // For example, adding a new instructor, removing an instructor, or displaying instructor details
    }

    private void manageCourses() {
        System.out.println("Managing courses...");
        // Add logic for managing courses
        // For example, adding a new course, removing a course, or displaying course details
    }

    private void exportData() {
        System.out.println("Exporting data...");
        // Add logic for exporting data
        // For example, exporting student data to a file or database

        while (true) {
            System.out.println("What would you like to export?");
            System.out.println("   1: Export Student Data");
            System.out.println("   2: Export Assignment Data");
            System.out.println("   3: Export Instructor Data");
            System.out.println("   4: Export Course Data");
            System.out.println("   5: Export All Data");
            System.out.println("   6: Back to Main Menu");
            System.out.print("Please select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    exportStudentData();
                    break;
                case 2:
                    exportAssignments();
                    break;
                case 3:
                    exportInstructors();
                    break;
                case 4: 
                    exportCourses();
                    break;
                case 5:
                    System.out.println("Exporting all data...");
                    // Add logic for exporting all data
                    break;
                case 6:
                    System.out.println("Returning to main menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}