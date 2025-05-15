/*
 * Uncomment lines 9 & 14 to use the GUI. This section is unfinished, so sections may still be in development or cause unexpected errors. 
 */

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        UserInterface ui = new UserInterface(manager);
        //GUI gui = new GUI(manager);

        loadSampleData(manager);

        ui.startApp();
        //gui.startApp();
    }

    public static void loadSampleData(Manager manager) {
        // Sample data loading logic here
        manager.addStudent("mike@example.com", "Mike", "1");
        manager.addStudent("bob@example.com", "Bob", "2");
        manager.addStudent("jane@example.com", "Jane", "3");
        manager.addStudent("alice@example.com", "Alice", "4");
        manager.addStudent("john@example.com", "John", "5");
        manager.addStudent("emma@example.com", "Emma", "6");
        manager.addStudent("oliver@example.com", "Oliver", "7");
        manager.addStudent("ava@example.com", "Ava", "8");
        manager.addStudent("liam@example.com", "Liam", "9");
        manager.addStudent("sophia@example.com", "Sophia", "10");
        manager.addStudent("noah@example.com", "Noah", "11");
        manager.addStudent("isabella@example.com", "Isabella", "12");
        manager.addStudent("elijah@example.com", "Elijah", "13");
        manager.addStudent("mia@example.com", "Mia", "14");
        manager.addStudent("james@example.com", "James", "15");

        manager.addInstructor("dube@example.com", "Professor Dube", "CS1");
        manager.addInstructor("smith@example.com", "Professor Smith", "CS2");
        manager.addInstructor("johnson@example.com", "Professor Johnson", "CS3");
        manager.addInstructor("lee@example.com", "Professor Lee", "CS4");
        manager.addInstructor("drpepper@example.com", "Dr. Pepper", "History1"); // The best instructor

        manager.addCourse("CS1", "810", "2:00pm", "Professor Dube", "Monday - Wednesday");
        manager.addCourse("CS2", "811", "2:00pm", "Professor Smith", "Monday - Wednesday");
        manager.addCourse("CS3", "812", "2:00pm", "Professor Johnson", "Monday - Wednesday");
        manager.addCourse("CS4", "813", "2:00pm", "Professor Lee", "Monday - Wednesday");
        manager.addCourse("History1", "814", "2:00pm", "Dr. Pepper", "Monday - Wednesday");

        manager.enrollStudent("1", "CS1");
        manager.enrollStudent("2", "CS1");
        manager.enrollStudent("3", "CS1");

        manager.enrollStudent("4", "CS2");
        manager.enrollStudent("5", "CS2");
        manager.enrollStudent("6", "CS2");

        manager.enrollStudent("7", "CS3");
        manager.enrollStudent("8", "CS3");
        manager.enrollStudent("9", "CS3");

        manager.enrollStudent("10", "CS4");
        manager.enrollStudent("11", "CS4");
        manager.enrollStudent("12", "CS4");

        manager.enrollStudent("13", "History1");
        manager.enrollStudent("14", "History1");
        manager.enrollStudent("15", "History1");

        manager.addAssignment("CS1", "Assignment 1", 100);
        manager.addAssignment("CS1", "Assignment 2", 100);
        manager.addAssignment("CS1", "Assignment 3", 100);
        manager.addAssignment("CS1", "Assignment 4", 100);
        manager.addAssignment("CS1", "Assignment 5", 100);

        manager.addAssignment("CS2", "Assignment 1", 100);
        manager.addAssignment("CS2", "Assignment 2", 100);
        manager.addAssignment("CS2", "Assignment 3", 100);
        manager.addAssignment("CS2", "Assignment 4", 100);
        manager.addAssignment("CS2", "Assignment 5", 100);

        manager.addAssignment("CS3", "Assignment 1", 100);
        manager.addAssignment("CS3", "Assignment 2", 100);
        manager.addAssignment("CS3", "Assignment 3", 100);
        manager.addAssignment("CS3", "Assignment 4", 100);
        manager.addAssignment("CS3", "Assignment 5", 100);

        manager.addAssignment("CS4", "Assignment 1", 100);
        manager.addAssignment("CS4", "Assignment 2", 100);
        manager.addAssignment("CS4", "Assignment 3", 100);
        manager.addAssignment("CS4", "Assignment 4", 100);
        manager.addAssignment("CS4", "Assignment 5", 100);

        manager.addAssignment("History1", "Assignment 1", 100);
        manager.addAssignment("History1", "Assignment 2", 100);
        manager.addAssignment("History1", "Assignment 3", 100);
        manager.addAssignment("History1", "Assignment 4", 100);
        manager.addAssignment("History1", "Assignment 5", 100);
    }
    
}
