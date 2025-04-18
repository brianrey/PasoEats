import java.util.ArrayList;

public class Manager {
    private ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<Instructor> instructors = new ArrayList<Instructor>();
    private ArrayList<Course> courses = new ArrayList<Course>();

    public void addStudent(String email, String name, String studentID) {
        Student student = new Student(name, email, studentID);
        students.add(student);
    }

    public void addInstructor(String email, String name, String courseName) {
        Instructor instructor = new Instructor(name, email, courseName);
        instructors.add(instructor);
    }

    public void addCourse(String courseName, String roomNumber, String meetTime, String instructor, String schedule) {
        Course course = new Course(courseName, roomNumber, meetTime, instructor, schedule);
        courses.add(course);
    }

    public void addAssignment(String studentID, String assignmentName, int score){
        for (Student student : students){
            if (student.getID().equals(studentID)){
                student.addAssignment(assignmentName, score);
                return;
            }
        }
        System.out.println("Student not found");
    }

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

    public void printStudents(){
        System.out.println("Students: ");
        for (Student student : students) {
            student.printDetails();
        }
    }

    public void printInstructors(){
        System.out.println("Instructors: ");
        for (Instructor instructor : instructors) {
            instructor.printDetails();
        }
    }

    public void printCourses(){
        System.out.println("Courses: ");
        for (Course course : courses) {
            course.printDetails();
        }
    }
    // TODO: getCourse, getInstructor, getStudent
}