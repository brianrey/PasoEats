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
    JPanel pContainer = new JPanel();
    JPanel pText = new JPanel();
    JPanel pStudent = new JPanel();
    JPanel pInstructor = new JPanel();
    JPanel pAssignment = new JPanel();
    JPanel pCourses = new JPanel();
    JPanel pExport = new JPanel();
    JLabel lText = new JLabel("Please choose one: ");
    JButton bStudent = new JButton("Manage Students");
    JButton bInstructor = new JButton("Manage Instructors");
    JButton bAssignement = new JButton("Manage Assignments");
    JButton bCourses = new JButton("Manage Courses");
    JButton bExport = new JButton("Export Data");

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
            }
            else if(source == bLoginStudent){
                studentMenu();
            }
        }
    }

    // instructor menu & logic
    private void instructorMenu(){
        // adding components to panels
        pText.add(lText);
        pStudent.add(bStudent);
        pInstructor.add(bInstructor);
        pAssignment.add(bAssignement);
        pCourses.add(bCourses);
        pExport.add(bExport);
        pContainer.add(pText);
        pContainer.add(pStudent);
        pContainer.add(pInstructor);
        pContainer.add(pAssignment);
        pContainer.add(pCourses);
        pContainer.add(pExport);
        // tab settings
        pContainer.setLayout(new GridLayout(0, 1, 5, 5));
        tabManager.addTab("Instructor Menu", pContainer);
        frame.pack();

        // event handlers

    }

    // student menu & logic
    private void studentMenu(){

    }

    // manage student menu & logic

    // manage assignment menu & logic

    // manage instructors menu & logic

    // manage courses menu & logic



    // export teacher data 

    // export student data 

    // grade summary 

    // change student name 

    // change student email

}
