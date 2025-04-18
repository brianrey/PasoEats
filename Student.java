import java.util.ArrayList;

public class Student extends Person {
    private String studentID;
    private ArrayList<Assignment> assignments;

    public Student(String name, String email, String studentID) {
        super(name, email);
        this.studentID = studentID;
        this.assignments = new ArrayList<>();
    }

    public String getID() {
        return studentID;
    }

    public void setID(String studentID) {
        this.studentID = studentID;
    }

    public void addAssignment(String assignmentName, int score){
        Assignment assignment = new Assignment(assignmentName, score);
        assignments.add(assignment);
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }
    
    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Student ID: " + studentID);
    }
    
}