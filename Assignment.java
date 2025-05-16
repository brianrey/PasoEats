
/**
 * Holds information about assignments, including name, score, and maximum score.
 */
public class Assignment {
    private String assignmentName;
    private int score;
    private int maxScore;

    /**
     * Constructor for an Assignment.
     * 
     * @param assignmentName The name of the assignment
     * @param score The score achieved on the assignment
     * @param maxScore The maximum possible score for the assignment
     */
    // validating the score is more of a placeholder for now because we are using random scores that are between 0 and maxScore.
    public Assignment(String assignmentName, int score, int maxScore){
        this.setAssignmentName(assignmentName);
        this.setMaxScore(maxScore); 
        this.setScore(score);
    }
    
    /**
     * Sets the name of the assignment.
     * 
     * @param assignmentName The new name of the assignment
     */
    public void setAssignmentName(String assignmentName){
        this.assignmentName = assignmentName;
    }

    /**
     * Sets the score of the assignment.
     * 
     * @param score The new score of the assignment
     */
    public void setScore(int score){
        this.score = Math.max(0, Math.min(score, this.maxScore));
    }

    /**
     * Gets the name of the assignment.
     * 
     * @return The name of the assignment
     */
    public String getAssignmentName(){
        return assignmentName;
    }

    /**
     * Sets the maximum score of the assignment.
     * @return
     */
    public void setMaxScore(int maxScore){
        this.maxScore = (maxScore > 0) ? Math.min(maxScore, 100) : 100; // if maxScore is less than 0, set it to 100. If maxScore is greater than 100, set it to 100.
    }

    /**
     * Gets the maximum score of the assignment.
     * 
     * @return The maximum score of the assignment
     */
    public int getMaxScore(){
        return maxScore;
    }

    /**
     * Gets the score of the assignment.
     * 
     * @return The score of the assignment
     */
    public int getScore(){
        return score;
    }

    /**
     * Prints the details of the assignment & score.
     */
    public void printDetails(){
        System.out.println(assignmentName + ": " + score + "/" + maxScore);
    }
}