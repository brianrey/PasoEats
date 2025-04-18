import java.util.ArrayList;
public class Grade {
    private int grade;

    public void setGrade(int grade){
        this.grade = grade;
    }

    public int getGrade(){
        return grade;
    }

    public String getLetterGrade(ArrayList<Assignment> assignments){
        if (assignments.isEmpty()){
            return "No assignments";
        }

        int total = 0;
        for (Assignment assignment : assignments){
            total += assignment.getScore();
        }

        int average = total / assignments.size();

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
    
    public void getClassGrades(){
        System.out.println("Class Grades: " + grade);
    }

}
