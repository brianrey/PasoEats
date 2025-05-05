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
    JButton bStudentLoginClose = new JButton("Close Tab");

    // making student menu components
    JPanel pStudentContainer = new JPanel();
    JPanel pStudentText = new JPanel();
    JLabel lStudentText = new JLabel("Please Choose One: ");
    JButton bStudentGradeSum = new JButton("View Grade Summary");
    JButton bStudentModName = new JButton("Modify My Name");
    JButton bStudentModEmail = new JButton("Modify My Email");
    JButton bStudentExport = new JButton("Export Data");
    JButton bStudentClose = new JButton("Close Tab");
    
    // making manage student menu components
    JPanel pManageStudentContainer = new JPanel();
    JPanel pManageStudentText = new JPanel();
    JLabel lManageStudentText = new JLabel("Please Choose One: ");
    JButton bManageStudentAdd = new JButton("Add New Student");
    JButton bManageStudentDisplay = new JButton("Display All Students");
    JButton bManageStudentClose = new JButton("Close Tab");

    // making add student menu components
    JPanel pAddStudentContainer = new JPanel();
    JPanel pAddStudentText = new JPanel();
    JPanel pAddStudentName = new JPanel();
    JPanel pAddStudentID = new JPanel();
    JPanel pAddStudentEmail = new JPanel();
    JPanel pAddStudentButtons = new JPanel();
    JLabel lAddStudentText = new JLabel("Enter Student Information: ");
    JLabel lAddStudentName = new JLabel("Student Name: ");
    JLabel lAddStudentID = new JLabel("Student ID: ");
    JLabel lAddStudentEmail = new JLabel("Student Email: ");
    JTextField tfAddStudentName = new JTextField(null, 15);
    JTextField tfAddStudentID = new JTextField(null, 15);
    JTextField tfAddStudentEmail = new JTextField(null, 15);
    JButton bAddStudentSumbit = new JButton("Sumbit");
    JButton bAddStudentClose = new JButton("Close Tab");


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
        pLoginContainer.setSize(250, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        frame.add(tabManager);
        frame.pack();
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // event handler implement
        LoginListener loginListener = new LoginListener();
        bLoginInstructor.addActionListener(loginListener);
        bLoginStudent.addActionListener(loginListener);
        bLoginClose.addActionListener(loginListener);
    }
    // login event handler
    private class LoginListener implements ActionListener{
        @Override
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
        tabManager.setSelectedComponent(pInstructorContainer);

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
        @Override
        public void actionPerformed(ActionEvent a){
            Object source = a.getSource();
            if(source == bInstructorAssignement){
                manageAssignmentsMenu();
            } else if(source == bInstructorCourses){
                manageCoursesMenu();
            } else if(source == bInstructorExport){
                exportStudentData();
            } else if(source == bInstructorInstructor){
                manageInstructorsMenu();
            } else if(source == bInstructorStudent){
                manageStudentsMenu();
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
        tabManager.setSelectedComponent(pStudentLoginContainer);

        // event handlers
        StudentLoginListener studentLoginListener = new StudentLoginListener();
        bStudentLoginLogin.addActionListener(studentLoginListener);
        bStudentLoginClose.addActionListener(studentLoginListener);
    }
    // student login logic
    private class StudentLoginListener implements ActionListener{
        @Override
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
        tabManager.setSelectedComponent(pStudentContainer);

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
        @Override
        public void actionPerformed(ActionEvent a){
            Object source = a.getSource();
            if(source == bStudentGradeSum){
                gradeSummary();;
            }
            else if(source == bStudentModName){
                changeStudentName();
            }
            else if(source == bStudentModEmail){
                changeStudentEmail();;
            }
            else if(source == bStudentExport){
                exportStudentData();
            }
            else if(source == bStudentClose){
                closeTab();
            }
        }
    }

    // manage student menu 
    private void manageStudentsMenu(){
        // adding components to panels
        pManageStudentText.add(lManageStudentText);
        pManageStudentContainer.add(pManageStudentText);
        pManageStudentContainer.add(bManageStudentAdd);
        pManageStudentContainer.add(bManageStudentDisplay);
        pManageStudentContainer.add(bManageStudentClose);

        // tab settings
        pManageStudentContainer.setLayout(new GridLayout(4, 1, 5, 5));
        tabManager.addTab("Manage Students Menu", pManageStudentContainer);
        tabManager.setSelectedComponent(pManageStudentContainer);

        // event handlers
        ManageStudentsListener manageStudentsListener = new ManageStudentsListener();
        bManageStudentAdd.addActionListener(manageStudentsListener);
        bManageStudentDisplay.addActionListener(manageStudentsListener);
        bManageStudentClose.addActionListener(manageStudentsListener);
    }
    // manage student menu event handler
    private class ManageStudentsListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent a){
            Object source = a.getSource();
            if(source == bManageStudentAdd){
                addStudentMenu();
            }
            else if(source == bManageStudentDisplay){
                displayStudents();
            }
            else if(source == bManageStudentClose){
                closeTab();
            }
        }
    }

    // add student menu
    private void addStudentMenu(){
        // adding components to panels
        pAddStudentText.add(lAddStudentText);
        pAddStudentName.add(lAddStudentName);
        pAddStudentName.add(tfAddStudentName);
        pAddStudentEmail.add(lAddStudentEmail);
        pAddStudentEmail.add(tfAddStudentEmail);
        pAddStudentID.add(lAddStudentID);
        pAddStudentID.add(tfAddStudentID);
        pAddStudentButtons.add(bAddStudentSumbit);
        pAddStudentButtons.add(bAddStudentClose);
        // putting in container panel
        pAddStudentContainer.add(pAddStudentText);
        pAddStudentContainer.add(pAddStudentName);
        pAddStudentContainer.add(pAddStudentEmail);
        pAddStudentContainer.add(pAddStudentID);
        pAddStudentContainer.add(pAddStudentButtons);

        // tab settings
        pAddStudentContainer.setLayout(new GridLayout(5, 1, 5, 5));
        tabManager.addTab("Add Student Menu", pAddStudentContainer);
        tabManager.setSelectedComponent(pAddStudentContainer);

        // event handlers
        AddStudentListener addStudentListener = new AddStudentListener();
        bAddStudentSumbit.addActionListener(addStudentListener);
        bAddStudentClose.addActionListener(addStudentListener);
    }
    // add student menu logic
    private class AddStudentListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent a) {
            Object source = a.getSource();
            if(source == bAddStudentSumbit){
                String name = tfAddStudentName.getText();
                String email = tfAddStudentEmail.getText();
                String ID = tfAddStudentID.getText();
                // validates entrys and adds new student
                if(name.isEmpty() || email.isEmpty() || ID.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please Fill All Fields", "Null Text Field(s)", JOptionPane.ERROR_MESSAGE);
                }
                else if(manager.getStudent(ID) != null){
                    JOptionPane.showMessageDialog(null, "Student ID " + ID + " Already Exists", "Invalid ID Entry", JOptionPane.ERROR_MESSAGE);
                }
                else if(!email.contains("@") || !email.contains(".")){
                    JOptionPane.showMessageDialog(null, "Email Format Looks Invalid", "Invalid Email Entry", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    manager.addStudent(email, name, ID);
                    JOptionPane.showMessageDialog(null, "Student " + name + " Successfully Added", "Student Added", JOptionPane.DEFAULT_OPTION);
                }
            }
            else if(source == bAddStudentClose){
                closeTab();
            }
        }
    }

    // display students
    private void displayStudents(){

    }

    // manage assignment menu & logic
    private void manageAssignmentsMenu(){
        System.out.println("managing assignments...");
    }

    // manage instructors menu & logic
    private void manageInstructorsMenu(){
        System.out.println("managing instructors...");
    }

    // manage courses menu & logic
    private void manageCoursesMenu(){
        System.out.println("managing courses...");
    }



    // grade summary 
    private void gradeSummary(){
        System.out.println("student grade summary...");
    }
    // change student name 
    private void changeStudentName(){
        System.out.println("change student name...");
    }
    // change student email
    private void changeStudentEmail(){
        System.out.println("change student email...");
    }
    // export student data 
    private void exportStudentData(){
        System.out.println("exporting...");
    }
}
