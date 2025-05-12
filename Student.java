import java.util.ArrayList;

/**
 * Extends the Person class and adds student-specific attributes e.g.: studentID 
 * Also handles assignment tracking.
 */
public class Student extends Person {
    private String studentID;
    private ArrayList<Assignment> assignments;

    /**
     * Constructs a new Student.
     * 
     * @param name The student's name
     * @param email The student's email address
     * @param studentID The unique identifier for the student
     */
    public Student(String name, String email, String studentID) {
        super(name, email);
        this.setID(studentID);
        //this.studentID = studentID;
        this.assignments = new ArrayList<>(); //TODO: Add a way to set and get the assignments list
    }

    /**
     * Gets the student's ID.
     * 
     * @return The student's ID
     */
    public String getID() {
        return studentID;
    }

    /**
     * Sets the student's ID.
     * 
     * @param studentID The new ID for the student
     */
    public void setID(String studentID) {
        this.studentID = studentID;
    }

    /**
     * Adds a new assignment to the student's record.
     * 
     * @param assignmentName The name of the assignment
     * @param score The score achieved on the assignment
     * @param maxScore The maximum possible score for the assignment
     */
    public void addAssignment(String assignmentName, int score, int maxScore){
        Assignment assignment = new Assignment(assignmentName, score, maxScore);
        assignments.add(assignment);
    }

    /**
     * Gets the list of assignments for this student.
     * 
     * @return An ArrayList containing all the student's assignments
     */
    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }
    
    /**
     * Prints the student's details.
     */
    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Student ID: " + studentID);
    }
    
}