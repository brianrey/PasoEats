public class Assignment {
    private String assignmentName;
    private int maxGrade;

    public Assignment(String assignmentName, int maxGrade){
        this.assignmentName = assignmentName;
        this.maxGrade = maxGrade;
    }
    
    public void setAssignmentName(String assignmentName){
        this.assignmentName = assignmentName;
    }

    public void setMaxGrade(int maxGrade){
        this.maxGrade = maxGrade;
    }

    public String getAssignmentName(){
        return assignmentName;
    }

    public int getMaxGrade(){
        return maxGrade;
    }

    public void printDetails(){
        System.out.println("Assignment Name: " + assignmentName);
        System.out.println("Max Grade: " + maxGrade);
    }
}
