public class Main {
    public static void main(String[] args) {
        Course course = new Course("CS1", "810", "2:00pm", "Professor Dube", "Monday - Wednsday");

        course.printDetails();

        Student mike = new Student("Mike", "mike@example.com");
        Student bob = new Student("Bob", "bob@example.com");

        course.addStudent(mike);
        course.addStudent(bob);
        course.printStudentRoster();
    }
}