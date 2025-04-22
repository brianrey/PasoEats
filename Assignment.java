public class Assignment {
    private String assignmentName;
    private int score;
    private static final int MAX_SCORE = 100;

    public Assignment(String assignmentName, int score){
        this.assignmentName = assignmentName;
        this.score = Math.min(score, MAX_SCORE);
    }
    
    public void setAssignmentName(String assignmentName){
        this.assignmentName = assignmentName;
    }

    public void setScore(int score){
        this.score = Math.min(score, MAX_SCORE);
    }

    public String getAssignmentName(){
        return assignmentName;
    }

    public int getMaxScore(){
        return MAX_SCORE;
    }

    public int getScore(){
        return score;
    }

    public void printDetails(){
        System.out.println("Assignment Name: " + assignmentName);
        System.out.println("Score: " + score + "/" + MAX_SCORE);
    }
}