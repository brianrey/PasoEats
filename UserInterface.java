import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserInterface {
    private Manager manager;
    private Scanner scanner;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM-dd-yyyy_HH-mm");

    public UserInterface(Manager manager) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
    }


    public void startApp() {
        welcomeMessage();
        
        while (true) {
            System.out.println("Are you an Instructor or a Student?");
            System.out.println("   1: Instructor");
            System.out.println("   2: Student");
            System.out.println("   3: Shut Down");
            System.out.print("Please select an option: ");
    
            int userType = scanner.nextInt();
            scanner.nextLine(); // Consume newline
    
            switch (userType) {
                case 1: // Instructor Main Menu
                    // Loop for the instructor menu until they choose to go back to the main menu
                    while (true) {
                        instructorMainMenu();
    
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
                                System.out.println("Returning to main menu...\n");
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.\n");
                        }
    
                        if (choice == 6) {
                            break; // Return to the initial user type selection
                        }
                    }
                    break;
    
                case 2: // Student Main Menu
                    // Loop for the student menu until they choose to go back to the main menu
                    while (true) {
                        studentMainMenu();
    
                        int choice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
    
                        switch (choice) {
                            case 1:
                                viewGradeSummaryForStu();
                                break;
                            case 2:
                                modifyNameForStu();
                                break;
                            case 3:
                                modifyEmailForStu();
                                break;
                            case 4:
                                exportStuGradeSummary();
                                break;
                            case 5:
                                System.out.println("Returning to main menu...\n");
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.\n");
                        }
    
                        if (choice == 2) {
                            break; // Return to the initial user type selection
                        }
                    }
                    break;
    
                case 3: // Shut Down Application
                    System.out.println("\nThank you.");
                    System.out.println("Shutting Down...\n");
                    return;
    
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }
    }

    public void welcomeMessage() {
        // Display the welcome message and version information
        System.out.println("\n---------------------------------------------");
        System.out.println("Welcome to the Student Management System.");
        System.out.println("Developed by: PasoEATS");
        System.out.println("Version: 0.0+dev");
        System.out.println("---------------------------------------------\n\n");
    }


    /**
     * Displays the main menu options for instructors.
     * Prompts the user to select an action from the available options.
     */
    // This method is called when the user selects the instructor option in the main menu.
    public void instructorMainMenu() {
        // Display the main menu options
        System.out.println("\nInstructor Main Menu");
        System.out.println("What action would you like to take?");
        System.out.println("   1: Manage Students");
        System.out.println("   2: Manage Assignments");
        System.out.println("   3: Manage Instructors");
        System.out.println("   4: Manage Courses");
        System.out.println("   5: Export Data");
        System.out.println("   6: Back to Main Menu");
        System.out.print("Please select an option: ");
    }

    /**
     * Displays the main menu options for students.
     * Prompts the user to select an action from the available options.
     */
    // This method is called when the user selects the student option in the main menu.
    public void studentMainMenu() {
        // Display the main menu options for students
        System.out.println("\nStudent Main Menu");
        System.out.println("What action would you like to take?");
        System.out.println("   1: View Grade Summary");
        System.out.println("   2: Modify Name");
        System.out.println("   3: Modify Email");
        System.out.println("   4: Export Grade Summary");
        System.out.println("   5: Back to Main Menu");
        System.out.print("Please type an option: ");
    }

    // Instructor Menuing

    /**
     * Displays the menu for managing students.
     * Prompts the user to select an action from the available options.
     */
    public void manageStudents() {
        while (true) {
            System.out.println("\nManaging Students Menu");
            System.out.println("What action would you like to take?");
            System.out.println("   1: Add New Student");
            System.out.println("   2: Display All Students");
            System.out.println("   3: Return to Previous Menu");
            System.out.print("Please select an option: ");
    
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
    
            switch (choice) {
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    manager.printStudents();
                    break;
                case 3:
                    System.out.println("Returning to previous menu...");
                    return; // Return to Instructor Main Menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Adds a new student to the system.
     * Prompts the user for the student's name, email, and ID, and adds the student to the manager.
     * If the student is added successfully, a confirmation message is displayed.
     * If the student already exists, an error message is displayed.
     */
    public void addNewStudent() {
        System.out.println("\nAdding New Student");
        System.out.print("Enter Student ID: ");
        String studentID = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter Student Email: ");
        String studentEmail = scanner.nextLine();

        // Add the new student to the manager
        manager.addStudent(studentEmail, studentName, studentID);
        System.out.println("Student added successfully.");
    }

    /**
     * Displays the menu for managing assignments.
     * Prompts the user to select an action from the available options.
     */
    public void manageAssignments() {
        System.out.println("\nManaging Assignments Menu");
        System.out.println("What action would you like to take?");
        System.out.println("   1: Add New Assignment");
        System.out.println("   2: Display All Assignments");
        System.out.println("   3: Modify Assignment Grade");
        System.out.println("   4: Return to Previous Menu");
        System.out.print("Please select an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                addNewAssignment();
                break;
            case 2:
                displayAllAssignments();
                break;
            case 3:
                modifyAssignmentGrade();
                break;
            case 4:
                System.out.println("Returning to previous menu...");
                return; // Return to Instructor Main Menu
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    /**
     * Adds a new assignment to a specific student.
     * Prompts the user for the student ID, assignment name, and score,
     * and adds the assignment to the student's list of assignments.
     * If the student is not found, an error message is displayed.
     */
    public void addNewAssignment() {
        System.out.println("\nAdding New Assignment");
        System.out.print("Enter Student ID: ");
        String studentID = scanner.nextLine();
        System.out.print("Enter Assignment Name: ");
        String assignmentName = scanner.nextLine();
        System.out.print("Enter Score: ");
        int score = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Add the new assignment to the student
        manager.addAssignment(studentID, assignmentName, score);
        System.out.println("Assignment added successfully.");
    }

    /**
     * Displays all assignments for a specific student.
     * Prompts the user for the student ID and retrieves the student's assignments.
     * If the student is not found, an error message is displayed.
     */
    public void displayAllAssignments() {
        manager.getStudentIDs();
        System.out.print("Enter Student ID: ");
        String studentID = scanner.nextLine();

        // Retrieve the student and their assignments
        Student student = manager.getStudent(studentID);
        if (student == null) {
            System.out.println("Student not found. No student with an ID of " + studentID + " exists.\n");
            return;
        } 

        System.out.println("\nAssignments for " + student.getName() + ":");
        for (Assignment assignment : student.getAssignments()) {
            System.out.println("  " + assignment.getAssignmentName() + ": " + assignment.getScore() + "/" + assignment.getMaxScore() + " pts");
        }
    }

    /**
     * Modifies the grade of a specific assignment for a student.
     * Prompts the user for the student ID, retrieves the student's assignments,
     * and allows the user to change the grade of a selected assignment.
     * If the student is not found, an error message is displayed.
     */
    public void modifyAssignmentGrade() {
        System.out.println("\nModifying Assignment Grade");
        System.out.print("Enter Student ID: ");
        String studentID = scanner.nextLine();

        // Retrieve the student and their assignments
        Student student = manager.getStudent(studentID);
        if (student == null) {
            System.out.println("Student not found. No student with an ID of " + studentID + " exists.\n");
            return;
        } 

        System.out.println("\nAssignments for " + student.getName() + ":");
        for (Assignment assignment : student.getAssignments()) {
            System.out.println("  " + assignment.getAssignmentName() + ": " + assignment.getScore() + "/" + assignment.getMaxScore() + " pts");
        }

        System.out.print("Enter the assignment number to modify: ");
        int assignmentNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Validate the assignment number
        if (assignmentNumber < 1 || assignmentNumber > student.getAssignments().size()) {
            System.out.println("Invalid assignment number.");
            return;
        }

        Assignment selectedAssignment = student.getAssignments().get(assignmentNumber - 1); // adjust for the 0-based index
        System.out.println("Selected assignment: " + selectedAssignment.getAssignmentName() + ": " + selectedAssignment.getScore() + "/" + selectedAssignment.getMaxScore() + " pts");
        System.out.print("Would you like to change the grade? Y/N? ");
        String changeGrade = scanner.nextLine();

        if (changeGrade.equalsIgnoreCase("Y")) {
            System.out.print("Please input new grade 0-100: ");
            int newGrade = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            selectedAssignment.setScore(newGrade);
            System.out.println("Grade updated successfully. Grade is now: " + selectedAssignment.getScore() + "/" + selectedAssignment.getMaxScore());
        } else {
            System.out.println("No changes made. Grade remains: " + selectedAssignment.getScore() + "/" + selectedAssignment.getMaxScore());
        }
    }

    //this is a placeholder for the modifyAssignmentGrade method needs to be validated and implemented
    public void DEVmodifyAssignmentGrade() {
        System.out.println("\nEnter Student ID: ");
        // Add logic for managing assignments
        // For example, adding a new assignment, removing an assignment, or displaying assignment details by student ID
        String studentID = scanner.nextLine();

        Student stu = manager.getStudent(studentID);
        if (stu == null) {
            System.out.println("Student not found. No student with an ID of " + studentID + " exists.\n");
            return;
        } 

        System.out.println("\nStudent found: " + stu.getName());
        System.out.println("\nAssignment details:");
        for (int i = 0; i < stu.getAssignments().size(); i++) {
            Assignment assignment = stu.getAssignments().get(i);
            System.out.println((i + 1) + ": " + assignment.getAssignmentName() + ": " + assignment.getScore() + "/" + assignment.getMaxScore() + " pts");
        }

        System.out.print("\nType an assignment to modify: ");
        int assignmentChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Validate the assignment choice
        if (assignmentChoice < 1 || assignmentChoice > stu.getAssignments().size()) {
            System.out.println("Invalid assignment choice.");
            return;
        }

        Assignment selectedAssignment = stu.getAssignments().get(assignmentChoice - 1); // adjust for the 0-based index
        System.out.println("Selected assignment: " + selectedAssignment.getAssignmentName() + ": " + selectedAssignment.getScore() + "/" + selectedAssignment.getMaxScore() + " pts");
        System.out.print("Would you like to change the grade? Y/N? ");
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

    /**
     * Displays the menu for managing instructors.
     * Prompts the user to select an action from the available options.
     */
    public void manageInstructors() {
        while (true) {
            System.out.println("\nManaging Instructors Menu");
            System.out.println("What action would you like to take?");
            System.out.println("   1: Add New Instructor");
            System.out.println("   2: Display All Instructors");
            System.out.println("   3: Return to Previous Menu");
            System.out.print("Please select an option: ");
    
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
    
            switch (choice) {
                case 1:
                    addNewInstructor();
                    break;
                case 2:
                    displayAllInstructors();
                    break;
                case 3:
                    System.out.println("Returning to previous menu...");
                    return; // Exit the manageInstructors menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Adds a new instructor to the system.
     * Prompts the user for the instructor's name, email, and ID, and adds the instructor to the manager.
     * If the instructor is added successfully, a confirmation message is displayed.
     * If the instructor already exists, an error message is displayed.
     */
    public void addNewInstructor() {
        System.out.println("\nAdding New Instructor");
        System.out.print("Enter Instructor Name: ");
        String instructorName = scanner.nextLine();
        System.out.print("Enter Instructor Email: ");
        String instructorEmail = scanner.nextLine();
        System.out.print("Enter Instructor ID: ");
        String instructorID = scanner.nextLine();

        // Add the new instructor to the manager
        manager.addInstructor(instructorEmail, instructorName, instructorID);
        System.out.println("Instructor added successfully.");
    }

    /**
     * Displays all instructors in the system.
     * Retrieves the list of instructors from the manager and prints their details to the console.
     * If no instructors are found, an appropriate message is displayed.
     */
    public void displayAllInstructors() {
        System.out.println("\nDisplaying All Instructors");
        // Display all instructors in the system
        manager.printInstructors();
        System.out.println("End of instructor list.\n");
    }

    /**
     * Displays the menu for managing courses.
     * Prompts the user to select an action from the available options.
     */
    public void manageCourses() {
        while (true) {
            System.out.println("\nManaging Courses Menu");
            System.out.println("What action would you like to take?");
            System.out.println("   1: Add New Course");
            System.out.println("   2: Display All Courses");
            System.out.println("   3: Return to Previous Menu");
            System.out.print("Please select an option: ");
    
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
    
            switch (choice) {
                case 1:
                    addNewCourse();
                    break;
                case 2:
                    displayAllCourses();
                    break;
                case 3:
                    System.out.println("Returning to previous menu...");
                    return; // Exit the manageCourses menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Adds a new course to the system.
     * Prompts the user for the course name, room number, meeting time, instructor, and schedule,
     * and adds the course to the manager.
     * If the course is added successfully, a confirmation message is displayed.
     * If the course already exists, an error message is displayed.
     */
    public void addNewCourse() {
        System.out.println("\nAdding New Course");
        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter Room Number: ");
        String roomNumber = scanner.nextLine();
        System.out.print("Enter Meeting Time: ");
        String meetTime = scanner.nextLine();
        System.out.print("Enter Instructor Name: ");
        String instructorName = scanner.nextLine();
        System.out.print("Enter Schedule: ");
        String schedule = scanner.nextLine();

        // Add the new course to the manager
        manager.addCourse(courseName, roomNumber, meetTime, instructorName, schedule);
        System.out.println("Course added successfully.");
    }

    /**
     * Displays all courses in the system.
     * Retrieves the list of courses from the manager and prints their details to the console.
     * If no courses are found, an appropriate message is displayed.
     */
    public void displayAllCourses() {
        System.out.println("\nDisplaying All Courses");
        // Display all courses in the system
        manager.printCourses();
        System.out.println("End of course list.\n");
    }

    /**
     * Displays the menu for exporting data.
     * Prompts the user to select an action from the available options.
     */
    public void exportData() {
        System.out.println("\nExporting Data Menu");
        while (true) {
            System.out.println("What would you like to export?");
            System.out.println("   1: Export Student Summary By StudentID");
            System.out.println("   2: Export All Course Summary");
            System.out.println("   3: Back to Main Menu");
            System.out.print("Please select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    exportStuGradeSummary();
                    break;
                case 2:
                    exportCourses();
                    break;
                case 3:
                    System.out.println("Returning to main menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void exportCourses() {
        System.out.println("Exporting course data...");
        // Add logic for exporting course data
    }
    // End of Instructor Menuing

    
    // Student Menuing

    /**
     * * Exports the grade summary for a specific student to a text file.
     * Prompts the user for the student ID, retrieves the student's information
     * and assignments, and writes the grade summary to a file.
     * The file is named "<ID>_grade_summary_<name>_<datetime>.txt" and contains the student's
     * ID, name, and a list of assignments with their scores.
     * If the student is not found, an error message is displayed.  
     * * @param studentID The ID of the student whose grade summary is to be exported.
     * @throws IOException If an error occurs while writing to the file.
     */
    public void exportStuGradeSummary() {
        System.out.println("Enter your Student ID: ");
        String studentID = scanner.nextLine();

        Student student = manager.getStudent(studentID);
        if (student == null) {
            System.out.println("Student not found. No student with an ID of " + studentID + " exists.\n");
            return;
        }

        String studentName = student.getName();
        System.out.println("\nExporting grade summary for " + studentName + "...");

        // Generate the file name with a timestamp
        String timestamp = FORMATTER.format(LocalDateTime.now());
        String fileName = studentID + "_grade_summary_" + studentName + "_" + timestamp + ".txt";

        int totalMaxScore = 0;
        int totalScore = 0;

        // File writing logic
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Student Grade Summary\n");
            writer.write("  Student ID: " + student.getID() + "\n");
            writer.write("  Student Name: " + student.getName() + "\n");
            writer.write("  Assignments:\n");
            for (Assignment assignment : student.getAssignments()) {
                writer.write("    " + assignment.getAssignmentName() + ": " + assignment.getScore() + "/" + assignment.getMaxScore() + " pts\n");
                totalMaxScore += assignment.getMaxScore();
                totalScore += assignment.getScore();
            }
            writer.write("Overall Score: " + totalScore + "/" + totalMaxScore + " pts\n");
            writer.write("Overall Percentage: " + (totalScore * 100 / totalMaxScore) + "%\n");
            writer.write("Overall Letter Grade: " + convertPercentToLetter(totalScore * 100 / totalMaxScore) + "\n");
            // Add the grading scale
            writer.write("\nGrading Scale:\n");
            writer.write("  A: 90% and above\n");
            writer.write("  B: 80% - 89%\n");
            writer.write("  C: 70% - 79%\n");
            writer.write("  D: 60% - 69%\n");
            writer.write("  F: Below 60%\n");
            writer.write("End of grade summary.");
            System.out.println("Grade summary successfully written to file: " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing the grade summary to a file.");
            e.printStackTrace();
        }
    }

    /**
     * Displays the grade summary for a specific student.
     * Prompts the user for the student ID, retrieves the student's information
     * and assignments, and prints the grade summary to the console.
     * If the student is not found, an error message is displayed.
     * @param studentID The ID of the student whose grade summary is to be displayed.
     * @throws IOException If an error occurs while writing to the file.
     * @throws NumberFormatException If the input cannot be parsed as an integer.
     */    
    public void viewGradeSummaryForStu() {
        System.out.println("Enter your Student ID: ");
        String studentID = scanner.nextLine();

        Student student = manager.getStudent(studentID);
        if (student == null) {
            System.out.println("Student not found. No student with an ID of " + studentID + " exists.\n");
            return;
        } 

        int totalMaxScore = 0;
        int totalScore = 0;
        System.out.println("\nGrade Summary for " + student.getName() + ":");
        System.out.println("Student ID: " + student.getID());        
        System.out.println("\nAssignment details: ");
        for (int i = 0; i < student.getAssignments().size(); i++) {
            Assignment assignment = student.getAssignments().get(i);
            System.out.println("  " + (i + 1) + ": " + assignment.getAssignmentName() + ": " + assignment.getScore() + "/" + assignment.getMaxScore() + " pts");
            totalMaxScore += assignment.getMaxScore();
            totalScore += assignment.getScore();
        }
        
        System.out.println("Overall Score: " + totalScore + "/" + totalMaxScore + " pts");
        System.out.println("Overall Percentage: " + (totalScore * 100 / totalMaxScore) + "%");
        System.out.println("Overall Letter Grade: " + convertPercentToLetter(totalScore * 100 / totalMaxScore));
        System.out.println("End of Grade Summary.");        
    }

    /**
     * Modifies the name of a specific student.
     * Prompts the user for the student ID, retrieves the student's information,
     * and allows the user to change the student's name.
     * If the student is not found, an error message is displayed.
     * @param studentID The ID of the student whose name is to be modified.
     */
    public void modifyNameForStu() {
        System.out.println("Enter your Student ID: ");
        String studentID = scanner.nextLine();

        Student student = manager.getStudent(studentID);
        if (student == null) {
            System.out.println("Student not found. No student with an ID of " + studentID + " exists.\n");
            return;
        } 

        System.out.println("Current name: " + student.getName());
        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        student.setName(newName);
        System.out.println("Name updated successfully. New name: " + student.getName());
    }

    /**
     * Modifies the email of a specific student.
     * Prompts the user for the student ID, retrieves the student's information,
     * and allows the user to change the student's email.
     * If the student is not found, an error message is displayed.
     * @param studentID The ID of the student whose email is to be modified.
     */
    public void modifyEmailForStu() {
        System.out.println("Enter your Student ID: ");
        String studentID = scanner.nextLine();

        Student student = manager.getStudent(studentID);
        if (student == null) {
            System.out.println("Student not found. No student with an ID of " + studentID + " exists.\n");
            return;
        } 

        System.out.println("Current email: " + student.getEmail());
        System.out.print("Enter new email: ");
        String newEmail = scanner.nextLine();
        student.setEmail(newEmail);
        System.out.println("Email updated successfully. New email: " + student.getEmail());
    }

    public char convertPercentToLetter(int percent) {
        if (percent >= 90) {
            return 'A';
        } else if (percent >= 80) {
            return 'B';
        } else if (percent >= 70) {
            return 'C';
        } else if (percent >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

}