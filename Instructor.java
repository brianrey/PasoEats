
/**
 * Extends the Person class and adds instructor-specific attributes e.g.: courseName
 */
public class Instructor extends Person {
    private String courseName;
    
    /**
     * Constructor for an Instructor.
     * 
     * @param name The instructor's name
     * @param email The instructor's email address
     * @param courseName The name of the course the instructor teaches
     */
    public Instructor(String name, String email, String courseName) {
        super(name, email);
        this.courseName = courseName;
    }

    /**
     * Gets the name of the course the instructor teaches.
     * 
     * @return The name of the course
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets the name of the course the instructor teaches.
     * 
     * @param courseName The new name of the course
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Prints the instructor's details.
     */
    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Course Name: " + courseName);
    }
}