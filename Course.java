import java.util.ArrayList;

public class Course {
    private String courseName;
    private String roomNum;
    private String meetTime;
    private String instructor;
    private String schedule;
    private ArrayList<Student> roster;

    public Course(String courseName, String roomNum, String meetTime, String instructor, String schedule) {
        this.courseName = courseName;
        this.roomNum = roomNum;
        this.meetTime = meetTime;
        this.instructor = instructor;
        this.schedule = schedule;
        roster = new ArrayList<>();
    }

    public void setCourseName(String courseName){
        this.courseName = courseName;
    }

    public void setRoomNum(String roomNum){
        this.roomNum = roomNum;
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

    public String getRoomNum(){
        return roomNum;
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

    public void addStudent(Student student) {
        roster.add(student);
    }

    public void printStudentRoster() {
        System.out.println("Student Roster for " + courseName + ":");
        for (Student s : roster) {
            System.out.println(s.getName() + " - " + s.getEmail());
        }
    }

    public void printDetails(){
        System.out.println("Course Details:");
        System.out.println("--------------");
        System.out.println("Course Name: " + courseName);
        System.out.println("Room Number: " + roomNum);
        System.out.println("Meeting Time: " + meetTime);
        System.out.println("Instructor: " + instructor);
        System.out.println("Schedule: " + schedule);
        System.out.println("--------------\n");
    }
}