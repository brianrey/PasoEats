import java.util.ArrayList;

/**
 * Holds information about the course, including name, room number, meet time, instructor, and schedule.
 */
public class Course {
    private String courseName;
    private String roomNumber;
    private String meetTime;
    private String instructor;
    private String schedule;
    private ArrayList<Student> roster;

    /**
     * Constructor for a new course.
     * 
     * @param courseName The name of the course
     * @param roomNumber The room where the course is held
     * @param meetTime The time when the course meets
     * @param instructor The name of the instructor teaching the course
     * @param schedule The days of the week when the course meets
     */
    public Course(String courseName, String roomNumber, String meetTime, String instructor, String schedule) {
        this.courseName = courseName;
        this.roomNumber = roomNumber;
        this.meetTime = meetTime;
        this.instructor = instructor;
        this.schedule = schedule;
        roster = new ArrayList<>();
    }

    /**
     * Sets the name of the course.
     * 
     * @param courseName The new course name
     */
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }

    /**
     * Sets the room number for the course.
     * 
     * @param roomNumber The new room number
     */
    public void setRoomNumber(String roomNumber){
        this.roomNumber = roomNumber;
    }

    /**
     * Sets the meeting time for the course.
     * 
     * @param meetTime The new meeting time
     */
    public void setMeetTime(String meetTime){
        this.meetTime = meetTime;
    }

    /**
     * Sets the instructor for the course.
     * 
     * @param instructor The new instructor name
     */
    public void setInstructor(String instructor){
        this.instructor = instructor;
    }

    /**
     * Sets the schedule for the course.
     * 
     * @param schedule The new schedule (days of the week)
     */
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    /**
     * Gets the name of the course.
     * 
     * @return The course name
     */
    public String getCourseName(){
        return courseName;
    }

    /**
     * Gets the room number for the course.
     * 
     * @return The room number
     */
    public String getRoomNumber(){
        return roomNumber;
    }

    /**
     * Gets the meeting time for the course.
     * 
     * @return The meeting time
     */
    public String getMeetTime(){
        return meetTime;
    }

    /**
     * Gets the instructor for the course.
     * 
     * @return The instructor name
     */
    public String getInstructor(){
        return instructor;
    }

    /**
     * Gets the schedule for the course.
     * 
     * @return The schedule (days of the week)
     */
    public String getSchedule() {
        return schedule;
    }

    /**
     * Gets the roster of students enrolled in the course.
     * 
     * @return The ArrayList of enrolled students
     */
    public ArrayList<Student> getRoster() {
        return roster;
    }

    /**
     * Sets the roster of students enrolled in the course.
     * 
     * @param roster The new ArrayList of students
     */
    public void setRoster(ArrayList<Student> roster) {
        this.roster = roster;
    }

    /**
     * Adds a student to the course roster.
     * 
     * @param student The student to add to the course
     */
    public void addStudent(Student student) {
        roster.add(student);
    }

    /**
     * Prints the roster of students enrolled in the course.
     * Displays each student's name and email.
     */
    public void printStudentRoster() {
        System.out.println("Student Roster for " + courseName + ":");
        for (Student student : roster) {
            System.out.println(student.getName() + " - " + student.getEmail());
        }
    }

    /**
     * Prints the details of the course: name, room number, meet time, instructor, and schedule.
     */
    public void printDetails(){
        System.out.println("Course Name: " + courseName);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Meeting Time: " + meetTime);
        System.out.println("Instructor: " + instructor);
        System.out.println("Schedule: " + schedule);
    }
}