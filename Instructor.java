public class Instructor extends Person {
    private String courseName;
    
    public Instructor(String name, String email, String courseName) {
        super(name, email);
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Course Name: " + courseName);
    }
}