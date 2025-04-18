public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        manager.addStudent("mike@example.com", "Mike", "1");
        manager.addStudent("bob@example.com", "Bob", "2");

        manager.addInstructor("dube@example.com", "Professor Dube", "CS1");
        manager.addInstructor("smith@example.com", "Professor Smith", "CS2");

        manager.addCourse("CS1", "810", "2:00pm", "Professor Dube", "Monday - Wednsday");
        manager.addCourse("CS2", "811", "2:00pm", "Professor Smith", "Monday - Wednsday");

        manager.printStudents();
        manager.printInstructors();
        manager.printCourses();

        manager.addAssignment("1", "Assignment 1", 100);
        
        manager.addAssignment("2", "Assignment 2", 85);
        manager.addAssignment("2", "Assignment 3", 82);
        manager.addAssignment("2", "Assignment 4", 83);

        manager.getStudentGrade("1");
        manager.getStudentGrade("2");
    }
}