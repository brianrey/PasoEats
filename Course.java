public class Course {
    private String courseName;
    private String roomNum;
    private String meetTime;
    private String instructor;

    public Course(String courseName, String roomNum, String meetTime, String instructor) {
        this.courseName = courseName;
        this.roomNum = roomNum;
        this.meetTime = meetTime;
        this.instructor = instructor;
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

    public String getCourseName(String courseName){
        return courseName;
    }

    public String getRoomNum(String roomNum){
        return roomNum;
    }

    public String getMeetTime(String meetTime){
        return meetTime;
    }

    public String getInstructor(String instructor){
        return instructor;
    }
}
