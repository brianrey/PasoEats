public class Grade {
    private int grade;

    public Grade(int grade){
        this.grade = grade;
    }

    public void setGrade(int grade){
        this.grade = grade;
    }

    public int getGrade(){
        return grade;
    }

    public String getLetterGrade(int grade){
        if (grade >= 90){
            return "A";
        }
        else if (grade >= 80){
            return "B";
        }
        else if (grade >= 70){
            return "C";
        }
        else if (grade >= 60){
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
