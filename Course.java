public class Course {
    private String courseName;
    private String roomNum;
    private String meetTime;
    private String instructor;
    private String schedule;

    public Course(String courseName, String roomNum, String meetTime, String instructor, String schedule) {
        this.courseName = courseName;
        this.roomNum = roomNum;
        this.meetTime = meetTime;
        this.instructor = instructor;
        this.schedule = schedule;
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

    public void displayDetails(){
        System.out.println(courseName);
        System.out.println(roomNum);
        System.out.println(meetTime);
        System.out.println(instructor);
        System.out.println(schedule);
    }
}
