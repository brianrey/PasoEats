import java.util.ArrayList;

public class Course {
    private String courseName;
    private String roomNumber;
    private String meetTime;
    private String instructor;
    private String schedule;
    private ArrayList<Student> roster;

    public Course(String courseName, String roomNumber, String meetTime, String instructor, String schedule) {
        this.courseName = courseName;
        this.roomNumber = roomNumber;
        this.meetTime = meetTime;
        this.instructor = instructor;
        this.schedule = schedule;
        roster = new ArrayList<>();
    }

    public void setCourseName(String courseName){
        this.courseName = courseName;
    }

    public void setRoomNumber(String roomNumber){
        this.roomNumber = roomNumber;
    }

    public void setMeetTime(String meetTime){
        this.meetTime = meetTime;
    }

    public void setInstructor(String instructor){
        this.instructor = instructor;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getCourseName(){
        return courseName;
    }

    public String getRoomNumber(){
        return roomNumber;
    }

    public String getMeetTime(){
        return meetTime;
    }

    public String getInstructor(){
        return instructor;
    }

    public String getSchedule() {
        return schedule;
    }

    public ArrayList<Student> getRoster() {
        return roster;
    }

    public void setRoster(ArrayList<Student> roster) {
        this.roster = roster;
    }

    public void addStudent(Student student) {
        roster.add(student);
    }

    public void printStudentRoster() {
        System.out.println("Student Roster for " + courseName + ":");
        for (Student student : roster) {
            System.out.println(student.getName() + " - " + student.getEmail());
        }
    }

    public void printDetails(){
        System.out.println("Course Name: " + courseName);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Meeting Time: " + meetTime);
        System.out.println("Instructor: " + instructor);
        System.out.println("Schedule: " + schedule);
    }
}