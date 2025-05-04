import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI{
    private Manager manager;
    private Student currStudent;

    // making main containers
    private JFrame frame = new JFrame("Course Manager");
    private JTabbedPane tabManager = new JTabbedPane();

    // making login menu components
    JPanel pLoginContainer = new JPanel();
    JPanel pLoginText = new JPanel();
    JLabel lLoginText = new JLabel("Please Select Your Role:");
    JButton bLoginInstructor = new JButton("Instructor");
    JButton bLoginStudent = new JButton("Student");
    JButton bLoginClose = new JButton("Close Tab");

    // making instructor menu components
    JPanel pInstructorContainer = new JPanel();
    JPanel pInstructorText = new JPanel();
    JLabel lInstructorText = new JLabel("Please Choose One: ");
    JButton bInstructorStudent = new JButton("Manage Students");
    JButton bInstructorInstructor = new JButton("Manage Instructors");
    JButton bInstructorAssignement = new JButton("Manage Assignments");
    JButton bInstructorCourses = new JButton("Manage Courses");
    JButton bInstructorExport = new JButton("Export Student Data");
    JButton bInstructorClose = new JButton("Close Tab");

    // making student login components
    JPanel pStudentLoginContainer = new JPanel();
    JPanel pStudentLoginText = new JPanel();
    JLabel lStudentLoginText = new JLabel("Please Enter Your Student ID: ");
    JTextField tfStudentLogin = new JTextField();
    JButton bStudentLoginLogin = new JButton("Login");
    JButton bStudentLoginClose = new JButton("Close");

    // making student menu components
    JPanel pStudentContainer = new JPanel();
    JPanel pStudentText = new JPanel();
    JLabel lStudentText = new JLabel("Please Choose One: ");
    JButton bStudentGradeSum = new JButton("View Grade Summary");
    JButton bStudentModName = new JButton("Modify My Name");
    JButton bStudentModEmail = new JButton("Modify My Email");
    JButton bStudentExport = new JButton("Export Data");
    JButton bStudentClose = new JButton("Close Tab");


    // constructor
    public GUI(Manager manager){
        this.manager = manager;
    }

    private void closeTab(){
        int x = tabManager.getSelectedIndex();
        if(x != -1){
            tabManager.removeTabAt(x);
        }
    }

    // login menu
    public void startApp(){
        // adding components to panels
        pLoginText.add(lLoginText);
        pLoginContainer.add(pLoginText);
        pLoginContainer.add(bLoginInstructor);
        pLoginContainer.add(bLoginStudent);
        pLoginContainer.add(bLoginClose);

        // tab settings
        pLoginContainer.setLayout(new GridLayout(4, 1, 10, 5));
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
        bLoginClose.addActionListener(loginListener);
    }
    // login event handler
    private class LoginListener implements ActionListener{
        public void actionPerformed(ActionEvent a){
            Object source = a.getSource();
            if(source == bLoginInstructor){
                instructorMenu();
            } else if(source == bLoginStudent){
                studentLoginMenu();
            } else if(source == bLoginClose){
                closeTab();
            }
        }
    }

    // instructor menu
    private void instructorMenu(){
        // adding components to panels
        pInstructorText.add(lInstructorText);
        pInstructorContainer.add(pInstructorText);
        pInstructorContainer.add(bInstructorStudent);
        pInstructorContainer.add(bInstructorInstructor);
        pInstructorContainer.add(bInstructorAssignement);
        pInstructorContainer.add(bInstructorCourses);
        pInstructorContainer.add(bInstructorExport);
        pInstructorContainer.add(bInstructorClose);

        // tab settings
        pInstructorContainer.setLayout(new GridLayout(7, 1, 10, 5));
        tabManager.addTab("Instructor Menu", pInstructorContainer);
        frame.pack();

        // event handlers
        InstructorListener instructorListener = new InstructorListener();
        bInstructorAssignement.addActionListener(instructorListener);
        bInstructorCourses.addActionListener(instructorListener);
        bInstructorExport.addActionListener(instructorListener);
        bInstructorInstructor.addActionListener(instructorListener);
        bInstructorStudent.addActionListener(instructorListener);
        bInstructorClose.addActionListener(instructorListener);

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
            } else if(source == bInstructorClose){
                closeTab();
            }
        }
    }

    // student login menu
    private void studentLoginMenu(){
        // adding components to panels
        pStudentLoginText.add(lStudentLoginText);
        pStudentLoginContainer.add(pStudentLoginText);
        pStudentLoginContainer.add(tfStudentLogin);
        pStudentLoginContainer.add(bStudentLoginLogin);
        pStudentLoginContainer.add(bStudentLoginClose);

        //tab settings
        pStudentLoginContainer.setLayout(new GridLayout(4, 1, 5, 5));
        tabManager.addTab("Student Login", pStudentLoginContainer);
        frame.pack();

        // event handlers
        StudentLoginListener studentLoginListener = new StudentLoginListener();
        bStudentLoginLogin.addActionListener(studentLoginListener);
        bStudentLoginClose.addActionListener(studentLoginListener);
    }
    // student login logic
    private class StudentLoginListener implements ActionListener{
        public void actionPerformed(ActionEvent a){
            Object source = a.getSource();
            if(source == bStudentLoginLogin){
                String studentID = tfStudentLogin.getText();
                currStudent = manager.getStudent(studentID);
                // verify student & continue
                if(currStudent != null){
                    studentMenu();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please enter a valid ID", "Illegal ID", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if(source == bStudentLoginClose){
                closeTab();
            }
        }
    }

    // student menu
    private void studentMenu(){
        // adding components to panels
        pStudentText.add(lStudentText);
        pStudentContainer.add(pStudentText);
        pStudentContainer.add(bStudentGradeSum);
        pStudentContainer.add(bStudentModName);
        pStudentContainer.add(bStudentModEmail);
        pStudentContainer.add(bStudentExport);
        pStudentContainer.add(bStudentClose);

        // tab settings
        pStudentContainer.setLayout(new GridLayout(6, 1, 5, 5));
        tabManager.addTab("Student Menu", pStudentContainer);
        frame.pack();

        //event handlers
        StudentListener studentListener = new StudentListener();
        bStudentGradeSum.addActionListener(studentListener);
        bStudentModName.addActionListener(studentListener);
        bStudentModEmail.addActionListener(studentListener);
        bStudentExport.addActionListener(studentListener);
        bStudentClose.addActionListener(studentListener);
    }
    // student menu event handler
    private class StudentListener implements ActionListener{
        public void actionPerformed(ActionEvent a){
            Object source = a.getSource();
            if(source == bStudentGradeSum){
                System.out.println("grade sum");
            }
            else if(source == bStudentModName){
                System.out.println("mod name");
            }
            else if(source == bStudentModEmail){
                System.out.println("mod email");
            }
            else if(source == bStudentExport){
                exportStudentData();
            }
            else if(source == bStudentClose){
                closeTab();
            }
        }
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



    // grade summary 

    // change student name 

    // change student email
    private void changeStudentEmail(){
        System.out.println("change student email...");
    }
    // export student data 
    private void exportStudentData(){
        System.out.println("exporting...");
    }
}
