public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        System.out.println("Starting developer sample data injection...");
        System.out.println("---------------------------------");
        System.out.println("");
        manager.addStudent("mike@example.com", "Mike", "1");
        manager.addStudent("bob@example.com", "Bob", "2");

        manager.addInstructor("dube@example.com", "Professor Dube", "CS1");
        manager.addInstructor("smith@example.com", "Professor Smith", "CS2");

        manager.addCourse("CS1", "810", "2:00pm", "Professor Dube", "Monday - Wednsday");
        manager.addCourse("CS2", "811", "2:00pm", "Professor Smith", "Monday - Wednsday");

        manager.enrollStudent("1", "CS1");
        manager.enrollStudent("2", "CS2");

        manager.printStudents();
        manager.printInstructors();
        manager.printCourses();

        manager.addAssignment("1", "Assignment 1", 100);
        
        manager.addAssignment("2", "Assignment 2", 85);
        manager.addAssignment("2", "Assignment 3", 82);
        manager.addAssignment("2", "Assignment 4", 83);

        manager.getStudentGrade("1");
        manager.getStudentGrade("2");

        System.out.println("End developer sample data injection.");
        System.out.println("---------------------------------");
        System.out.println("");

        System.out.println("Starting User Interface...");
        System.out.println("---------------------------------");
        System.out.println("");
        // Initialize the UserInterface with the Manager instance
        UserInterface ui = new UserInterface(manager);
        ui.startApp();
    }
}