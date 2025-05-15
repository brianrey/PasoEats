/**
 * This class adds a console-ui to do some cool stuff 😎.
 */
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {
    private Manager manager;
    private Scanner scanner;

    /**
     * Constructs a new UserInterface with the specified Manager.
     *
     * @param manager The Manager object
     * @throws IllegalArgumentException if manager is null
     */
    public UserInterface(Manager manager) {
        if (manager == null) { // the UI needs a manager to work so if its null throw an error
            throw new IllegalArgumentException("Manager instance cannot be null.");
        }
        this.setManager(manager);
        //this.scanner = new Scanner(System.in);
        this.setScanner(new Scanner(System.in));
    }

    /**
     * Sets the manager for this UserInterface.
     *
     * @param manager The Manager object to set
     */
    public void setManager(Manager manager) {

        this.manager = manager;
    }

    /**
     * Gets the manager for this UserInterface.
     *
     * @return The Manager object
     */
    public Manager getManager() {
        return manager;
    }

    /**
     * Sets the scanner for this UserInterface.
     *
     * @param scanner The Scanner object to set
     */
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Gets the scanner for this UserInterface.
     *
     * @return The Scanner object
     */
    public Scanner getScanner() {
        return scanner;
    }   

    /**
     * Starts the ui and handles the main ui loop.
     * Displays the welcome message and login menu, then processes user selections.
     */
    public void startApp() {
        printWelcomeMessage();

        boolean running = true;
        while (running) {
            printLoginScreen();
            int userType = readIntInput("Please select an option (1-3): ");

            switch (userType) {
                case 1:
                    instructorMainMenuLoop();
                    break;
                case 2:
                    System.out.println("\n Student Login\n");
                    String studentID = readStringInput("Please enter your Student ID: ");
                    Manager manager = this.getManager();
                    Student student = manager.getStudent(studentID);

                    if (student != null) {
                        System.out.println("\nWelcome, " + student.getName() + "!");
                        studentMainMenuLoop(student);
                    } else {
                        System.out.println("\n\u001B[31mStudent ID: " + studentID + " not found.\u001B[0m");
                        waitForEnter();
                    }
                    break;
                case 3:
                    printGoodbyeMessage();
                    running = false;
                    break;
                default:
                    System.out.println("\n\u001B[31mInvalid choice. Please enter a number between 1 and 3.\u001B[0m");
                    waitForEnter();
            }
        }

        scanner.close();
    }

    /**
     * Prints the welcome message for the ui.
     */
    private void printWelcomeMessage() {
        System.out.println(" Welcome to the Student Management System");
        System.out.println(" Developed by: PasoEATS");
        System.out.println(" Version: 1.0");
    }

    /**
     * Prints the login screen with role selection options.
     */
    private void printLoginScreen() {
        System.out.println(" "); //add space so intelliJ doesn't provide warning
        System.out.println(" Login");
        System.out.println();
        System.out.println(" Please select your role:");
        System.out.println("   1: Instructor");
        System.out.println("   2: Student");
        System.out.println("   3: Shut Down");
        System.out.println();
    }

    /**
     * Prints the goodbye message when shutting down the ui.
     */
    private void printGoodbyeMessage() {
        System.out.println("\n");
        System.out.println(" Thank you");
        System.out.println(" Shutting Down...");
        System.out.println("\n");
    }

    /**
     * Prints the instructor main menu options.
     */
    private void printInstructorMenu() {
        System.out.println("\n");
        System.out.println(" Instructor Menu");
        System.out.println();
        System.out.println("   1: Manage Students");
        System.out.println("   2: Manage Assignments");
        System.out.println("   3: Manage Instructors");
        System.out.println("   4: Manage Courses");
        System.out.println("   5: Export Data");
        System.out.println("   6: Log Out");
        System.out.println();
    }

    /**
     * Handles the instructor main menu loop and processes instructor selections.
     */
    private void instructorMainMenuLoop() {
        boolean loggedIn = true;
        while (loggedIn) {
            printInstructorMenu();
            int choice = readIntInput("Please select an option (1-6): ");

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
                    exportInstructorData();
                    break;
                case 6:
                    System.out.println("\nLogging out...");
                    loggedIn = false;
                    break;
                default:
                    System.out.println("\n\u001B[31mInvalid choice. Please enter a number between 1 and 6.\u001B[0m");
                    waitForEnter();
            }
        }
    }

    /**
     * Prints the student main menu options.
     */
    private void printStudentMenu() {
        System.out.println(" "); //add space so intelliJ doesn't provide warning
        System.out.println(" Student Menu");
        System.out.println();
        System.out.println("   1: View Grade Summary");
        System.out.println("   2: Modify My Name");
        System.out.println("   3: Modify My Email");
        System.out.println("   4: Export Data");
        System.out.println("   5: Log Out");
        System.out.println();
    }

    /**
     * Handles the student main menu loop and processes student selections.
     *
     * @param student The student currently logged in
     */
    private void studentMainMenuLoop(Student student) {
         boolean loggedIn = true;
        while (loggedIn) {
            printStudentMenu();
            int choice = readIntInput("Please select an option (1-5): ");

            switch (choice) {
                case 1:
                    gradeSummary(student);
                    break;
                case 2:
                    changeStudentName(student);
                    break;
                case 3:
                    changeStudentEmail(student);
                    break;
                case 4:
                    exportStudentData(student);
                    break;
                case 5:
                    System.out.println("\nLogging out...");
                    loggedIn = false;
                    break;
                default:
                    System.out.println("\n\u001B[31mInvalid choice. Please enter a number between 1 and 5.\u001B[0m");
                    waitForEnter();
            }
        }
    }

    /**
     * Prints the manage students menu options.
     */
    private void manageStudentsMenu() {
        System.out.println("\n Manage Students Menu");
        System.out.println();
        System.out.println("   1: Add New Student");
        System.out.println("   2: Display All Students");
        System.out.println("   3: Back to Main Menu");
        System.out.println();
    }

    /**
     * Handles the student management menu loop and processes user selections.
     */
    private void manageStudents() {
        boolean managing = true;
        while(managing) {
            manageStudentsMenu();
            int choice = readIntInput("Please select an option (1-3): ");
            switch(choice) {
                case 1:
                    String studentID = readStringInput("Enter Student ID: ");
                    if (manager.getStudent(studentID) != null) {
                        System.out.println("\u001B[31mStudent ID " + studentID + " already exists.\u001B[0m");
                    } else {
                        String studentName = readStringInput("Enter Student Name: ");
                        String studentEmail = readStringInput("Enter Student Email: ");
                        if (!studentEmail.contains("@") || !studentEmail.contains(".")) {
                             System.out.println("\u001B[33mEmail format looks invalid.\u001B[0m");
                        }
                        manager.addStudent(studentEmail, studentName, studentID);
                        System.out.println("\n\u001B[32m" + studentName + " has enrolled!\u001B[0m");
                    }
                    waitForEnter();
                    break;
                case 2:
                    manager.printStudents();
                    waitForEnter();
                    break;
                case 3:
                    managing = false;
                    break;
                default:
                    System.out.println("\n\u001B[31mInvalid choice. Please enter 1, 2, or 3.\u001B[0m");
                    waitForEnter();
            }
        }
        System.out.println("\nReturning to Instructor Menu...");
    }

    /**
     * Prints the manage assignments menu options.
     */
    private void manageAssignmentsMenu() {
        System.out.println("\n Manage Assignments Menu");
        System.out.println();
        System.out.println("   1: Add Assignment to Course");
        System.out.println("   2: View Student's Grades");
        System.out.println("   3: Modify Assignment Grade");
        System.out.println("   4: Back to Main Menu");
        System.out.println();
    }

    /**
     * Handles the assignment management menu loop and processes user selections.
     */
    private void manageAssignments() {
        boolean managing = true;
        while(managing) {
            manageAssignmentsMenu();
            int choice = readIntInput("Please select an option (1-4): ");
            switch(choice) {
                case 1:
                    manager.printCourseNames();
                    String courseName = readStringInput("Enter Course Name to add assignment to: ");
                    Course course = manager.getCourse(courseName);
                    if (course == null) {
                        System.out.println("\u001B[31mCourse " + courseName + " not found.\u001B[0m");
                    } else {
                        String assignmentName = readStringInput("Enter Assignment Name: ");
                        int maxScore = readIntInput("Enter Max Score for Assignment: ");
                        if (maxScore <= 0) {
                             System.out.println("\u001B[31mMax score must be positive.\u001B[0m");
                        } else {
                            manager.addAssignment(courseName, assignmentName, maxScore);
                            System.out.println("\u001B[32mAssignment: " + assignmentName + " added to course " + courseName + ".\u001B[0m");
                        }
                    }
                    waitForEnter();
                    break;
                case 2:
                    manager.printStudentIDs();
                    String studentID = readStringInput("Enter Student ID to view grades: ");
                    Student studentToView = manager.getStudent(studentID);
                    if (studentToView == null) {
                        System.out.println("\u001B[31mStudent ID " + studentID + " not found.\u001B[0m");
                        waitForEnter();
                    } else {
                        gradeSummary(studentToView);
                    }
                    break;
                case 3:
                    manager.printStudentIDs();
                    String studentToModify = readStringInput("Enter Student ID ");
                    Student studentIDToModify = manager.getStudent(studentToModify);

                    if (studentIDToModify == null) {
                        System.out.println("\u001B[31mStudent ID " + studentToModify + " not found.\u001B[0m");
                        waitForEnter();
                        break;
                    }

                    List<Assignment> assignments = studentIDToModify.getAssignments();
                    if (assignments == null || assignments.isEmpty()) {
                        System.out.println("\u001B[31mStudent " + studentIDToModify.getName() + " has no assignments to modify.\u001B[0m");
                        waitForEnter();
                        break;
                    }

                    System.out.println("\nAssignments for " + studentIDToModify.getName() + ":");
                    for (int i = 0; i < assignments.size(); i++) {
                        Assignment currentAssignment = assignments.get(i);
                        System.out.printf("  %d: %s (%d / %d pts)%n", i + 1, currentAssignment.getAssignmentName(), currentAssignment.getScore(), currentAssignment.getMaxScore());
                    }

                    int assignmentNum = readIntInput("Enter the number of the assignment to modify (1-" + assignments.size() + "): ");

                    if (assignmentNum < 1 || assignmentNum > assignments.size()) {
                        System.out.println("\u001B[31mInvalid assignment number.\u001B[0m");
                    } else {
                        Assignment assignment = assignments.get(assignmentNum - 1);
                        System.out.println("Selected: " + assignment.getAssignmentName());
                        int newScore = readIntInput("Enter the new score (0-" + assignment.getMaxScore() + "): ");

                        assignment.setScore(newScore);
                        System.out.println("\u001B[32m\n" +assignment.getAssignmentName() + " updated to " + assignment.getScore() + "/" + assignment.getMaxScore() + " pts.\u001B[0m");
                    }
                    waitForEnter();
                    break;
                case 4:
                    managing = false;
                    break;
                default:
                    System.out.println("\n\u001B[31mInvalid choice. Please enter 1, 2, 3, or 4.\u001B[0m");
                    waitForEnter();
            }
        }
        System.out.println("\nReturning to Instructor Menu...");
    }

    /**
     * Prints the manage instructors menu options.
     */
    private void manageInstructorsMenu() {
        System.out.println("\n Manage Instructors Menu");
        System.out.println();
        System.out.println("   1: Add New Instructor");
        System.out.println("   2: Display All Instructors");
        System.out.println("   3: Back to Main Menu");
        System.out.println();
    }

    /**
     * Handles the instructor management menu loop and processes user selections.
     */
    private void manageInstructors() {
        boolean managing = true;
        while(managing) {
            manageInstructorsMenu();
            int choice = readIntInput("Please select an option (1-3): ");
            switch(choice) {
                case 1:
                    String instructorName = readStringInput("Enter Instructor name: ");
                    if (manager.getInstructor(instructorName) != null) {
                        System.out.println("\u001B[31mInstructor " + instructorName + " already exists.\u001B[0m");
                    } else {
                        String instructorEmail = readStringInput("Enter Instructor Email: ");
                        if (!instructorEmail.contains("@") || !instructorEmail.contains(".")) {
                            System.out.println("\u001B[33mEmail format appears invalid.\u001B[0m");
                       }
                        String courseName = readStringInput("Enter Course Name: ");
                        manager.addInstructor(instructorEmail, instructorName, courseName);
                        System.out.println("\n\u001B[32m" +instructorName + " assigned to " + courseName + ".\u001B[0m");
                    }
                    waitForEnter();
                    break;
                case 2:
                    manager.printInstructors();
                    waitForEnter();
                    break;
                case 3:
                    managing = false;
                    break;
                default:
                    System.out.println("\n\u001B[31mInvalid choice. Please enter 1, 2, or 3.\u001B[0m");
                    waitForEnter();
            }
        }
        System.out.println("\nReturning to Instructor Menu...");
    }

    /**
     * Prints the manage courses menu options.
     */
    private void manageCoursesMenu() {
        System.out.println("\n Manage Courses Menu");
        System.out.println();
        System.out.println("   1: Add New Course");
        System.out.println("   2: Display All Courses");
        System.out.println("   3: Enroll Student in Course");
        System.out.println("   4: Display Grades for Course");
        System.out.println("   5: Back to Main Menu");
        System.out.println();
    }

    /**
     * Handles the course management menu loop and processes user selections.
     */
    private void manageCourses() {
        boolean managing = true;
        while(managing) {
            manageCoursesMenu();
            String courseName;
            int choice = readIntInput("Please select an option (1-5): ");
            switch(choice) {
                case 1:
                    courseName = readStringInput("Enter Course Name: ");
                    if (manager.getCourse(courseName) != null) {
                        System.out.println("\u001B[31mCourse " + courseName + " already exists.\u001B[0m");
                    } else {
                        String roomNumber = readStringInput("Enter Room Number: ");
                        String meetTime = readStringInput("Enter Meeting Time: ");
                        manager.printInstructorNames();
                        String instructorName = readStringInput("Enter Instructor Name: ");
                        if (manager.getInstructor(instructorName) == null) {
                            System.out.println("\u001B[31mInstructor " + instructorName + " not found.\u001B[0m");
                            waitForEnter();
                            break;
                        }
                        String schedule = readStringInput("Enter Schedule: ");
                        manager.addCourse(courseName, roomNumber, meetTime, instructorName, schedule);
                        System.out.println("\n\u001B[32m" + courseName + " added.\u001B[0m");
                    }
                    waitForEnter();
                    break;
                case 2:
                    manager.printCourseNames();
                    waitForEnter();
                    break;
                case 3:
                    manager.printStudentIDs();
                    String studentID = readStringInput("Enter Student ID: ");
                    Student studentToEnroll = manager.getStudent(studentID);
                    if (studentToEnroll == null) {
                        System.out.println("\u001B[31mStudent ID " + studentID + " not found.\u001B[0m");
                    } else {
                        manager.printCourseNames();
                        courseName = readStringInput("Enter Course Name: ");
                        Course courseToEnroll = manager.getCourse(courseName);
                        if (courseToEnroll == null) {
                            System.out.println("\u001B[31mCourse " + courseName + " not found.\u001B[0m");
                        } else {
                            manager.enrollStudent(studentID, courseName);
                            System.out.println("\n\u001B[32m" + studentToEnroll.getName() + " enrolled in " + courseName + ".\u001B[0m");
                        }
                    }
                    waitForEnter();
                    break;
                case 4:
                    manager.printCourseNames();
                    String courseNameForGrades = readStringInput("Enter Course Name to view grades: ");
                    Course courseForGrades = manager.getCourse(courseNameForGrades);
                    if (courseForGrades == null) {
                        System.out.println("\u001B[31mCourse " + courseNameForGrades + " not found.\u001B[0m");
                    } else {
                        System.out.println("\nGrades for " + courseNameForGrades + ":");
                        for (Student student : courseForGrades.getRoster()) {
                            ArrayList<Assignment> assignments = student.getAssignments();
                            Grade grade = new Grade();
                            String letterGrade = grade.getLetterGrade(assignments);
                            System.out.printf("Student: %s, Letter Grade: %s%n", student.getName(), letterGrade);
                        }
                    }
                    waitForEnter();
                    break;                    
                case 5: // Back to Main Menu
                    managing = false;
                    break;
                default:
                    System.out.println("\n\u001B[31mInvalid choice. Please enter a number between 1 and 5.\u001B[0m");
                    waitForEnter();
            }
        }
        System.out.println("\nReturning to Instructor Menu...");
    }

    /**
     * Handles data export functionality for instructor.
     */
    private void exportInstructorData() {

        boolean exportManagement = true;
        while (exportManagement) {
            manager.printInstructorNames();

            String instructorName = readStringInput("Please enter an instructor name to export data for (or type \"Exit\"): ");
            if (instructorName.isEmpty()) {
                System.out.println("\u001B[31mInstructor name cannot be empty.\u001B[0m");
                continue;
            } else if (instructorName.equalsIgnoreCase("Exit")) {
                System.out.println("\nNo files exported.");
                break;
            }
    
            Instructor instructor = manager.getInstructor(instructorName);
            if (instructor == null) {
                System.out.println("\u001B[31mInstructor " + instructorName + " not found.\u001B[0m");
                waitForEnter();
            } else {
                System.out.println("\n\u001B[32m" + instructorName + " found.\u001B[0m");
                manager.exportInstructorData(instructor);
                exportManagement = false;
                waitForEnter();
            }
        }

        System.out.println("\nReturning to Instructor Menu...");
    }

    /**
     * Handles data export functionality for students.
     * Currently not implemented.
     */
    private void exportStudentData(Student student) {
        System.out.println("\nExport Student Data\n");
        try {
            System.out.println("Exporting data for " + student.getName() + "...");
            manager.exportStudentData(student);
        }
        catch (Exception e) {
            System.out.println("\u001B[31mError exporting student data: " + e.getMessage() + "\u001B[0m");
            waitForEnter();
            return;
        }
        System.out.println("\nStudent data exported successfully.");
        waitForEnter();
    }

    /**
     * Displays a summary of grades for the specified student.
     *
     * @param student The logged in student whose grades should be displayed
     */
    private void gradeSummary(Student student) {
        System.out.println("\nGrade Summary for " + student.getName());
        List<Assignment> assignments = student.getAssignments();

        if (assignments == null || assignments.isEmpty()) {
            System.out.println("No assignments found for this student.");
        } else {
            int totalEarned = 0;
            int totalMax = 0;
            System.out.println("\nAssignments:");
            for (Assignment assignment : assignments) {
                assignment.printDetails();
                totalEarned += assignment.getScore();
                totalMax += assignment.getMaxScore();
            }

            System.out.println("\nOverall:");
            if (totalMax > 0) {
                double percentage = ((double) totalEarned / totalMax) * 100.0;
                Grade grade = new Grade();
                String letterGrade = grade.getLetterGrade(new ArrayList<>(assignments));

                System.out.printf("Total Score: %d / %d%n", totalEarned, totalMax);
                System.out.printf("Percentage: %.2f%%%n", percentage);
                System.out.println("Letter Grade: " + letterGrade);
            }
        }
        waitForEnter();
    }

    /**
     * Allows a student to change their name.
     *
     * @param student The logged in student whose name should be changed
     */
    private void changeStudentName(Student student) {
        System.out.println("\nModify Name for " + student.getName());
        System.out.println("Current name: " + student.getName());
        String newName = readStringInput("Enter new name: ");
        student.setName(newName);
        System.out.println("\nName updated to: " + student.getName());
        waitForEnter();
    }

    /**
     * Allows a student to change their email.
     *
     * @param student The logged in student whose email should be changed
     */
    private void changeStudentEmail(Student student) {
        System.out.println("\nModify Email for " + student.getName());
        System.out.println("Current email: " + student.getEmail());
        String newEmail = readStringInput("Enter new email: ");
        if (!newEmail.contains("@") || !newEmail.contains(".")) {
            System.out.println("\u001B[33mEmail format looks invalid.\u001B[0m");
        } else {
            student.setEmail(newEmail);
            System.out.println("\nEmail updated to: " + student.getEmail());
        }
        waitForEnter();
    }

    /**
     * Reads an integer input from the user with validation.
     *
     * @param prompt The prompt to display to the user
     * @return The validated integer input
     */
    private int readIntInput(String prompt) {
        Scanner scanner = this.getScanner();
        int input;
        while (true) {
            System.out.print(prompt);
            try {
                input = scanner.nextInt();
                scanner.nextLine();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("\u001B[31mError: Invalid input. Please enter a whole number.\u001B[0m");
                scanner.nextLine();
            }
        }
    }

    /**
     * Reads a string input from the user with validation.
     *
     * @param prompt The prompt to display to the user
     * @return The validated string input
     */
    private String readStringInput(String prompt) {
        String input;
        while (true) {
             System.out.print(prompt);
             input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("\u001B[31mError: Input cannot be empty.\u001B[0m");
            }
        }
    }

    /**
     * Pauses execution until the user presses Enter.
     */
    private void waitForEnter() {
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }

}
