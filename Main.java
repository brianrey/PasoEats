public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        UserInterface ui = new UserInterface(manager);

        manager.addStudent("mike@example.com", "Mike", "1");
        manager.addStudent("bob@example.com", "Bob", "2");

        manager.addInstructor("dube@example.com", "Professor Dube", "CS1");
        manager.addInstructor("smith@example.com", "Professor Smith", "CS2");

        manager.addCourse("CS1", "810", "2:00pm", "Professor Dube", "Monday - Wednesday");
        manager.addCourse("CS2", "811", "2:00pm", "Professor Smith", "Monday - Wednesday");

        manager.enrollStudent("1", "CS1");
        manager.enrollStudent("2", "CS2");

        manager.printStudents();
        manager.printInstructors();
        manager.printCourses();

        manager.addAssignment("CS2", "Assignment 1", 100);
        manager.addAssignment("CS2", "Assignment 2", 102);
        manager.addAssignment("CS2", "Assignment 3", 100);
        manager.addAssignment("CS2", "Assignment 4", 100);
        
        manager.addAssignment("CS1", "Assignment 5", 80);
        manager.addAssignment("CS1", "Assignment 6", 80);
        manager.addAssignment("CS1", "Assignment 7", 80);

        manager.getStudentGrade("1");
        manager.getStudentGrade("2");
        
        ui.startApp();
    }
}