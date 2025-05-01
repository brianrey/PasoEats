import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI{
    private Manager manager;
    // making main containers
    private JFrame frame = new JFrame("Course Manager");
    private JTabbedPane tabManager = new JTabbedPane();

    // making login menu components
    JPanel pLoginContainer = new JPanel();
    JPanel pLoginText = new JPanel();
    JPanel pLoginButtons = new JPanel();
    JLabel loginText = new JLabel("Please select your role:");
    JButton bLoginInstructor = new JButton("Instructor");
    JButton bLoginStudent = new JButton("Student");

    // making instructor menu components
    JPanel pInstructorContainer = new JPanel();
    JPanel pInstructorText = new JPanel();
    JPanel pInstructorStudent = new JPanel();
    JPanel pInstructorInstructor = new JPanel();
    JPanel pInstructorAssignment = new JPanel();
    JPanel pInstructorCourses = new JPanel();
    JPanel pInstructorExport = new JPanel();
    JLabel lInstructorText = new JLabel("Please choose one: ");
    JButton bInstructorStudent = new JButton("Manage Students");
    JButton bInstructorInstructor = new JButton("Manage Instructors");
    JButton bInstructorAssignement = new JButton("Manage Assignments");
    JButton bInstructorCourses = new JButton("Manage Courses");
    JButton bInstructorExport = new JButton("Export Student Data");

    // constructor
    public GUI(Manager manager){
        this.manager = manager;
    }

    // login menu
    public void launchLogin(){
        // adding components to panels
        pLoginText.add(loginText);
        pLoginButtons.add(bLoginInstructor);
        pLoginButtons.add(bLoginStudent);
        pLoginContainer.add(pLoginText);
        pLoginContainer.add(pLoginButtons);
        // tab settings
        pLoginContainer.setLayout(new GridLayout(2, 1, 5, 5));
        tabManager.addTab("Login", pLoginContainer);
        // frame settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        frame.add(tabManager);
        frame.setVisible(true);
        frame.pack();

        // event handler implement
        LoginListener loginListener = new LoginListener();
        bLoginInstructor.addActionListener(loginListener);
        bLoginStudent.addActionListener(loginListener);
    }
    // login event handler
    private class LoginListener implements ActionListener{
        public void actionPerformed(ActionEvent a){
            Object source = a.getSource();
            if(source == bLoginInstructor){
                instructorMenu();
                return;
            } else if(source == bLoginStudent){
                studentMenu();
                return;
            }
        }
    }

    // instructor menu
    private void instructorMenu(){
        // adding components to panels
        pInstructorText.add(lInstructorText);
        pInstructorStudent.add(bInstructorStudent);
        pInstructorInstructor.add(bInstructorInstructor);
        pInstructorAssignment.add(bInstructorAssignement);
        pInstructorCourses.add(bInstructorCourses);
        pInstructorExport.add(bInstructorExport);
        pInstructorContainer.add(pInstructorText);
        pInstructorContainer.add(pInstructorStudent);
        pInstructorContainer.add(pInstructorInstructor);
        pInstructorContainer.add(pInstructorAssignment);
        pInstructorContainer.add(pInstructorCourses);
        pInstructorContainer.add(pInstructorExport);
        // tab settings
        pInstructorContainer.setLayout(new GridLayout(0, 1, 5, 5));
        tabManager.addTab("Instructor Menu", pInstructorContainer);
        frame.pack();

        // event handlers
        InstructorListener instructorListener = new InstructorListener();
        bInstructorAssignement.addActionListener(instructorListener);
        bInstructorCourses.addActionListener(instructorListener);
        bInstructorExport.addActionListener(instructorListener);
        bInstructorInstructor.addActionListener(instructorListener);
        bInstructorStudent.addActionListener(instructorListener);

    }
    // instructor menu event handler
    private class InstructorListener implements ActionListener{
        public void actionPerformed(ActionEvent a){
            Object source = a.getSource();
            if(source == bInstructorAssignement){
                manageAssignments();
            } else if(source == bInstructorCourses){
                manageCourses();
            } else if(source == bInstructorExport){
                exportStudentData();
            } else if(source == bInstructorInstructor){
                manageInstructors();
            } else if(source == bInstructorStudent){
                manageStudents();
            }
        }
    }

    // student menu & logic
    private void studentMenu(){
        System.out.println("student menu");
    }


    // manage student menu & logic
    private void manageStudents(){
        System.out.println("managing students...");
    }

    // manage assignment menu & logic
    private void manageAssignments(){
        System.out.println("managing assignments...");
    }

    // manage instructors menu & logic
    private void manageInstructors(){
        System.out.println("managing instructors...");
    }

    // manage courses menu & logic
    private void manageCourses(){
        System.out.println("managing courses...");
    }



    // export student data 
    private void exportStudentData(){
        System.out.println("exporting...");
    }

    // grade summary 

    // change student name 

    // change student email

}
