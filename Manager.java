import java.util.ArrayList;
import java.util.Random;

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
     * Prints details of all instructors in the system.
     */
    public void printInstructors(){
        System.out.println("Instructors: ");
        for (Instructor instructor : instructors) {
            instructor.printDetails();
        }
    }

    /**
     * Prints details of all courses in the system.
     */
    public void printCourses(){
        System.out.println("Courses: ");
        for (Course course : courses) {
            course.printDetails();
        }
    }
}