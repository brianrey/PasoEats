import java.util.ArrayList;

/**
 * Handles grade calculation for students based on their assignments.
 */
public class Grade {
    private int grade;

    /**
     * Sets the grade value.
     * 
     * @param grade The grade value to set
     */
    public void setGrade(int grade){
        this.grade = grade;
    }

    /**
     * Gets the current grade value.
     * 
     * @return The current grade value
     */
    public int getGrade(){
        return grade;
    }

    /**
     * Calculates a letter grade based on a list of assignments.
     * Uses the percentage of total points earned to determine the letter grade.
     * 
     * @param assignments The list of assignments to calculate the grade from
     * @return The letter grade (A, B, C, D, F) or "No assignments" if the list is empty
     */
    public String getLetterGrade(ArrayList<Assignment> assignments){
        if (assignments == null || assignments.isEmpty()){
            return "No assignments";
        }
        
        int totalEarned = 0;
        int totalMax = 0;
        for (Assignment assignment : assignments) {
            totalEarned += assignment.getScore();
            totalMax += assignment.getMaxScore();
        }

        double average = ((double) totalEarned / totalMax) * 100.0;

        if (average >= 90){
            return "A";
        }
        else if (average >= 80){
            return "B";
        }
        else if (average >= 70){
            return "C";
        }
        else if (average >= 60){
            return "D";
        }
        else {
            return "F";
        }
    }
    
    /**
     * Displays the class grades.
     * Prints the current grade value to the console.
     */
    public void getClassGrades(){
        System.out.println("Class Grades: " + grade);
    }

}