import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Manager class that handles students, instructors, and courses.
 */
public class Manager {
    private ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<Instructor> instructors = new ArrayList<Instructor>();
    private ArrayList<Course> courses = new ArrayList<Course>();
    private Random random = new Random();

    /**
     * Adds a new student to the system.
     * 
     * @param email The email address of the student
     * @param name The full name of the student
     * @param studentID The unique ID for the student
     */
    public void addStudent(String email, String name, String studentID) {
        Student student = new Student(name, email, studentID);
        students.add(student);
    }

    /**
     * Adds a new instructor to the system.
     * 
     * @param email The email address of the instructor
     * @param name The full name of the instructor
     * @param courseName The name of the course taught by the instructor
     */
    public void addInstructor(String email, String name, String courseName) {
        Instructor instructor = new Instructor(name, email, courseName);
        instructors.add(instructor);
    }

    /**
     * Adds a new course to the system.
     * 
     * @param courseName The name of the course
     * @param roomNumber The room number where the course is held
     * @param meetTime The meeting time for the course
     * @param instructor The name of the instructor teaching the course
     * @param schedule The schedule for the course (days of the week)
     */
    public void addCourse(String courseName, String roomNumber, String meetTime, String instructor, String schedule) {
        Course course = new Course(courseName, roomNumber, meetTime, instructor, schedule);
        courses.add(course);
    }

    /**
     * Adds an assignment with a max score to a specific course.
     * 
     * @param courseName The name of the course
     * @param assignmentName The name of the assignment
     * @param maxScore The maximum score for the assignment
     */
    public void addAssignment(String courseName, String assignmentName, int maxScore) {
        Course course = getCourse(courseName);
        if (course == null) {
            System.out.println("Course: " + courseName + " not found");
            return;
        }
        if (maxScore <= 0) {
            System.out.println("Max score must be positive for assignment: " + assignmentName);
            return;
        }

        ArrayList<Student> roster = course.getRoster();
        if (roster.isEmpty()) {
            System.out.println("No students are in " + courseName);
            return;
        }

        for (Student student : roster) {
            int randomScore = random.nextInt(maxScore + 1); // Random score between 0 and maxScore
            student.addAssignment(assignmentName, randomScore, maxScore);
        }
    }

    /**
     * Calculates and displays the letter grade for a student based on their assignments.
     * 
     * @param studentID The ID of the student whose grade is to be displayed
     */
    public void getStudentGrade(String studentID) {
        for (Student student : students) {
            if (student.getID().equals(studentID)) {
                ArrayList<Assignment> assignments = student.getAssignments();
                Grade grade = new Grade();
                String letterGrade = grade.getLetterGrade(assignments);
                System.out.println("Student: " + student.getName());
                System.out.println("Letter Grade: " + letterGrade);
                return;
            }
        }
    }

    /**
     * Retrieves all student IDs from the system.
     * 
     * @return An ArrayList of all student IDs
     */
    public ArrayList<String> getStudentIDs() {
        ArrayList<String> studentIDs = new ArrayList<String>();
        for (Student student : students) {
            studentIDs.add(student.getID());
        }
        System.out.println("Student IDs: " + studentIDs);
        return studentIDs;
    }

    /**
     * Enrolls a student in a specific course.
     * 
     * @param studentID The ID of the student to enroll
     * @param courseName The name of the course in which to enroll the student
     */
    public void enrollStudent(String studentID, String courseName) {
        Student studentToEnroll = getStudent(studentID); 
        Course courseToEnroll = getCourse(courseName);
    
        if (studentToEnroll != null && courseToEnroll != null) {
            courseToEnroll.addStudent(studentToEnroll);
        } 
        else {
            if (studentToEnroll == null) {
                System.out.println("Student not found");
            }
            else {
                System.out.println("Course not found");
            }
        }
    }

    /**
     * Retrieves a student by their ID.
     * 
     * @param studentID The ID of the student to retrieve
     * @return The Student object if found, null otherwise
     */
    public Student getStudent(String studentID) {
        for (Student student : students) {
            if (student.getID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }

    /**
     * Retrieves an instructor by their name.
     * 
     * @param name The name of the instructor to retrieve
     * @return The Instructor object if found, null otherwise
     */
    public Instructor getInstructor(String name) {
        for (Instructor instructor : instructors) {
            if (instructor.getName().equals(name)) {
                return instructor;
            }
        }
        return null;
    }

    /**
     * Retrieves a course by its name.
     * 
     * @param name The name of the course to retrieve
     * @return The Course object if found, null otherwise
     */
    public Course getCourse(String name) {
        for (Course course : courses) {
            if (course.getCourseName().equals(name)) {
                return course;
            }
        }
        return null;
    }

    /**
     * Prints details of all students in the system.
     */
    public void printStudents(){
        System.out.println("\nStudents: ");
        for (Student student : students) {
            student.printDetails();
        }
    }

    /**
     * Prints all student IDs in the student ArrayList.
     */
    public void printStudentIDs(){
        System.out.println();
        System.out.println("Student IDs: ");
        for (Student student : students) {
            System.out.println(student.getID());
        }
        System.out.println();
    }
    /**
     * Prints details of all instructors in the Instructor ArrayList.
     */
    public void printInstructors(){
        System.out.println("Instructors: ");
        for (Instructor instructor : instructors) {
            instructor.printDetails();
        }
    }

    /**
     * Prints all instructor names in the Instructor ArrayList.
     */
    public void printInstructorNames(){
        System.out.println("Instructors: ");
        for (Instructor instructor : instructors) {
            System.out.println(instructor.getName());
        }
    }

    /**
     * Prints details of all courses in the Course ArrayList.
     */
    public void printCourses(){
        System.out.println("Courses: ");
        for (Course course : courses) {
            course.printDetails();
        }
    }

    /**
     * Prints all course names in the Course ArrayList.
     */
    public void printCourseNames(){
        System.out.println();
        System.out.println("Courses: ");
        for (Course course : courses) {
            System.out.println(course.getCourseName());
        }
        System.out.println();
    }

    /**
     * Checks if the folder exists, if not creates it, and returns the export folder.
     * Any expor will be saved in the project folder under the export folder.
     * 
     * @return The export folder path
     */
    public String getExportFolder() {
        String exportFolder = "export/";
        File folder = new File(exportFolder);

        // Create the folder if it doesn't exist
        if (!folder.exists()) {
            boolean created = folder.mkdirs();
            if (created) {
                System.out.println("Export folder created: " + exportFolder);
            } else {
                System.out.println("Failed to create export folder: " + exportFolder);
            }
        }

        return exportFolder;
    }

    /**
     * Returns the export filename based on the current date and time.
     * 
     * @return The export filename
     */
    public String getExportFilename() {
        LocalDateTime currentTime = LocalDateTime.now();
    String date = currentTime.toLocalDate().toString(); // YYYY-MM-DD

    // Format time as HH:MM:SS
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH-mm-ss");
    String time = currentTime.toLocalTime().format(timeFormatter);

    String filename = "export_" + date + "_" + time + ".txt";

    return filename;
    }

    /**
     * Returns the full export file path within the project folder.
     * 
     * @return The full export file path
     */
    public String getExportFilePath() {
        return getExportFolder() + getExportFilename();
    }  

    public void exportInstructorData(Instructor instructor) {
        // TODO: create export to file

        String courseName = instructor.getCourseName();
        Course course = getCourse(courseName);
        if (course == null) {
            System.out.println("Acceptable course not found for instructor: " + instructor.getName());
            return;
        }

        ArrayList<Student> roster = course.getRoster();
        String filename = getExportFilePath();
        try (PrintWriter pWriter = new PrintWriter(new FileWriter(filename))) {
            // Write instructor and course details
            pWriter.printf("Instructor: %s%n", instructor.getName());
            pWriter.printf("Course: %s%n", courseName);
            pWriter.printf("Schedule: %s%n", course.getSchedule());
            pWriter.printf("Meeting Time: %s%n", course.getMeetTime());
            pWriter.printf("Room Number: %s%n%n", course.getRoomNumber());

            // Write student grades
            pWriter.println("Course Grades:");
            for (Student student : roster) {
                ArrayList<Assignment> assignments = student.getAssignments();
                Grade grade = new Grade();
                String letterGrade = grade.getLetterGrade(assignments);

                pWriter.printf(" Student: %s%n", student.getName());
                pWriter.printf("  Letter Grade: %s%n", letterGrade);
            }

            pWriter.print("\nExport Complete.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        System.out.println("Instructor: " + instructor.getName() + " data exported to: " + filename);
    }


    public void exportStudentData() {
        // Export student data to a file
        String exportFolder = getExportFolder();
        for (Student student : students) {
            student.exportData(exportFolder);
        }
    }
}