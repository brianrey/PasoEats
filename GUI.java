import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/*
 * TODO: 
 * 
 * Check for bugs
 * 
 * STUDENT: 
 *      grade summary
 *      export data
 *  INSTRUCTOR: 
 *      fix assignment always being null in edit assignment menu
 *      grade summary
 *      manage courses
 *      export data
 *  
 */

public class GUI{
    private Manager manager;
    private Student loggedInStudent;
    private Student instructorGradeStudent;

    // making main containers
    private JFrame frame = new JFrame("Course Manager");
    private JTabbedPane tabManager = new JTabbedPane();

    // making login menu components
    JPanel pLoginContainer = new JPanel();
    JPanel pLoginText = new JPanel();
    JLabel lLoginText = new JLabel("Please Select Your Role:");
    JButton bLoginInstructor = new JButton("Instructor");
    JButton bLoginStudent = new JButton("Student");

    // making student login components
    JPanel pStudentLoginContainer = new JPanel();
    JPanel pStudentLoginText = new JPanel();
    JLabel lStudentLoginText = new JLabel("Please Enter Your Student ID: ");
    JTextField tfStudentLogin = new JTextField();
    JButton bStudentLoginLogin = new JButton("Login");
    JButton bStudentLoginClose = new JButton("Close Tab");

    // making student menu components
    JPanel pStudentContainer = new JPanel();
    JPanel pStudentContainerText = new JPanel();
    JPanel pStudentText = new JPanel();
    JLabel lStudentIntro = new JLabel();
    JLabel lStudentText = new JLabel("Please Choose One: ");
    JButton bStudentGradeSum = new JButton("View Grade Summary");
    JButton bStudentModName = new JButton("Modify My Name");
    JButton bStudentModEmail = new JButton("Modify My Email");
    JButton bStudentExport = new JButton("Export Data");
    JButton bStudentClose = new JButton("Close Tab");

    // making change student name components
    JPanel pChangeStudentNameContainer = new JPanel();
    JLabel lChangeStudentNameText = new JLabel("Current Name: ");
    JLabel lChangeStudentNameCurr = new JLabel();
    JLabel lChangeStudentNameNew = new JLabel("Enter New Name: ");
    JTextField tfChangeStudentNameNew = new JTextField();
    JButton bChangeStudentNameSubmit = new JButton("Submit");
    JButton bChangeStudentNameClose = new JButton("Close Tab");

    // making change student email components
    JPanel pChangeStudentEmailContainer = new JPanel();
    JLabel lChangeStudentEmailText = new JLabel("Change Email For: ");
    JLabel lChangeStudentEmailName = new JLabel();
    JLabel lChangeStudentEmailLabel = new JLabel("Current Email: ");
    JLabel lChangeStudentEmailCurr = new JLabel();
    JLabel lChangeStudentEmailNew = new JLabel("Enter New Email: ");
    JTextField tfChangeStudentEmailNew = new JTextField();
    JButton bChangeStudentEmailSubmit = new JButton("Submit");
    JButton bChangeStudentEmailClose = new JButton("Close Tab");

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
    
    // making manage student menu components
    JPanel pManageStudentContainer = new JPanel();
    JPanel pManageStudentText = new JPanel();
    JLabel lManageStudentText = new JLabel("Please Choose One: ");
    JButton bManageStudentAdd = new JButton("Add New Student");
    JButton bManageStudentDisplay = new JButton("Display Student");
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
    JButton bAddStudentSumbit = new JButton("Submit");
    JButton bAddStudentClose = new JButton("Close Tab");

    // making display student components
    JPanel pDisplayStudentContainer = new JPanel();
    JPanel pDisplayStudent = new JPanel();
    JTextField tfDisplayStudent = new JTextField(null, 20);
    JLabel lDisplayStudentText = new JLabel("Enter An ID To Retrieve: ");
    JLabel lDisplayStudentNameLabel = new JLabel("Student's Name: ");
    JLabel lDisplayStudentName = new JLabel();
    JLabel lDisplayStudentIDLabel = new JLabel("Student's ID: ");
    JLabel lDisplayStudentID = new JLabel();
    JLabel lDisplayStudentEmailLabel = new JLabel("Student's Email: ");
    JLabel lDisplayStudentEmail = new JLabel();
    JButton bDisplayStudentSubmit = new JButton("Submit");
    JButton bDisplayStudentClose = new JButton("Close Tab");

    // making manage assignments components
    JPanel pManageAssignmentsContainer = new JPanel();
    JPanel pManageAssignmentsText = new JPanel();
    JLabel lManageAssignmentsText = new JLabel("Please Choose One: ");
    JButton bManageAssignmentsAdd = new JButton("Add Assignment to Course");
    JButton bManageAssignmentsViewGrade = new JButton("View Student's Grades");
    JButton bManageAssignmentsModGrade = new JButton("Modify Assignment Grade");
    JButton bManageAssignmentsClose = new JButton("Close Tab");

    // making add assignment components
    JPanel pAddAssignmentContainer = new JPanel();
    JLabel lAddAssignmentCourseNameLabel = new JLabel("Enter Course Name to Add To: ");
    JTextField tfAddAssignmentCourseName = new JTextField();
    JLabel lAddAssignmentAssignmentNameLabel = new JLabel("Enter Assignment Name: ");
    JTextField tfAddAssignmentAssignmentName = new JTextField();
    JLabel lAddAssignmentMaxScoreLabel = new JLabel("Enter Max Score: ");
    JTextField tfAddAssignmentMaxScore = new JTextField();
    JButton bAddAssignmentSubmit = new JButton("Submit");
    JButton bAddAssignmentClose = new JButton("Close");

    // making edit assignment components
    JPanel pEditAssignmentContainer = new JPanel();
    JLabel lEditAssignmentID = new JLabel("Enter Student ID: ");
    JTextField tfEditAssignmentID = new JTextField();
    JLabel lEditAssignmentAssignment = new JLabel("Enter Assignment Name: ");
    JTextField tfEditAssignmentAssignment = new JTextField();
    JLabel lEditAssignmentScore = new JLabel("Enter New Score: ");
    JTextField tfEditAssignmentScore = new JTextField();
    JButton bEditAssignmentSubmit = new JButton("Submit");
    JButton bEditAssignmentClose = new JButton("Close Tab");

    // making instructor student grade summary components
    JPanel pInstructorStudentGradeContainer = new JPanel();
    JLabel lInstructorStudentGradeContainer = new JLabel("Enter Student To View: ");
    JTextField tfInstructorStudentGradeID = new JTextField();
    JButton bInstructorStudentGradeSubmit = new JButton("Submit");
    JButton bInstructorStudentGradeClose = new JButton("Close");

    // making manage instructors components
    JPanel pManageInstructorsContainer = new JPanel();
    JPanel pManageInstructorsText = new JPanel();
    JLabel lManageInstructorsText = new JLabel("Please Choose One: ");
    JButton bManageInstructorsAdd = new JButton("Add New Instructor");
    JButton bManageInstructorsDisplay = new JButton("Display Instructor");
    JButton bManageInstructorsClose = new JButton("Close Tab");

    // making add instructor menu components
    JPanel pAddInstructorContainer = new JPanel();
    JPanel pAddInstructorText = new JPanel();
    JPanel pAddInstructorName = new JPanel();
    JPanel pAddInstructorCourse = new JPanel();
    JPanel pAddInstructorEmail = new JPanel();
    JPanel pAddInstructorButtons = new JPanel();
    JLabel lAddInstructorText = new JLabel("Enter Instructor Information: ");
    JLabel lAddInstructorName = new JLabel("Instructor Name: ");
    JLabel lAddInstructorCourse = new JLabel("Instructor Course: ");
    JLabel lAddInstructorEmail = new JLabel("Instructor Email: ");
    JTextField tfAddInstructorName = new JTextField(null, 15);
    JTextField tfAddInstructorCourse = new JTextField(null, 15);
    JTextField tfAddInstructorEmail = new JTextField(null, 15);
    JButton bAddInstructorSumbit = new JButton("Submit");
    JButton bAddInstructorClose = new JButton("Close Tab");

    // making display instructor components
    JPanel pDisplayInstructorContainer = new JPanel();
    JPanel pDisplayInstructor = new JPanel();
    JTextField tfDisplayInstructor = new JTextField(null, 20);
    JLabel lDisplayInstructorText = new JLabel("Enter A Name To Retrieve: ");
    JLabel lDisplayInstructorNameLabel = new JLabel("Instructor's Name: ");
    JLabel lDisplayInstructorName = new JLabel();
    JLabel lDisplayInstructorCourseLabel = new JLabel("Instructor's Course: ");
    JLabel lDisplayInstructorCourse = new JLabel();
    JLabel lDisplayInstructorEmailLabel = new JLabel("Instructor's Email: ");
    JLabel lDisplayInstructorEmail = new JLabel();
    JButton bDisplayInstructorSubmit = new JButton("Submit");
    JButton bDisplayInstructorClose = new JButton("Close Tab");

    // constructor
    public GUI(Manager manager){
        this.manager = manager;
    }

    private void closeTab(Component currTab){
        tabManager.remove(currTab);
    }

    // login menu
    public void startApp(){
        // adding components to panels
        pLoginText.add(lLoginText);
        pLoginContainer.add(pLoginText);
        pLoginContainer.add(bLoginStudent);
        pLoginContainer.add(bLoginInstructor);

        // tab settings
        pLoginContainer.setLayout(new GridLayout(3, 1, 10, 5));
        tabManager.addTab("Login", pLoginContainer);

        // frame settings
        pLoginContainer.setSize(250, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        frame.add(tabManager);
        frame.pack();
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // event handler implement
        StartListener startListener = new StartListener();
        bLoginInstructor.addActionListener(startListener);
        bLoginStudent.addActionListener(startListener);
    }

    // start event handler
    private class StartListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent a){
            Object source = a.getSource();
            if(source == bLoginInstructor){
                instructorMenu();
            } else if(source == bLoginStudent){
                studentLoginMenu();
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
    // student login event handler
    private class StudentLoginListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent a){
            Object source = a.getSource();
            if(source == bStudentLoginLogin){
                String studentID = tfStudentLogin.getText();
                // verify student & continue
                if(studentID.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please Fill All Fields", "Null Text Field(s)", JOptionPane.ERROR_MESSAGE);
                }
                else if(manager.getStudent(studentID) == null){
                    JOptionPane.showMessageDialog(null, "Please enter a valid ID", "Nonexistant Item", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    loggedInStudent = manager.getStudent(studentID);
                    studentMenu(loggedInStudent.getName());
                }
            }
            else if(source == bStudentLoginClose){
                closeTab(pStudentLoginContainer);
            }
        }
    }

    // student menu
    private void studentMenu(String studentName){
        // setting text 
        lStudentIntro.setText("Hello " + studentName + "!");
        // adding components to panels
        pStudentContainerText.add(lStudentIntro);
        pStudentContainerText.add(lStudentText);
        pStudentContainer.add(pStudentContainerText);
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
                gradeSummary(loggedInStudent);
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
                closeTab(pStudentContainer);
            }
        }
    }

    // change student name 
    private void changeStudentName(){
        // setting text
        lChangeStudentNameCurr.setText(loggedInStudent.getName());

        // adding components to panels
        pChangeStudentNameContainer.add(lChangeStudentNameText);
        pChangeStudentNameContainer.add(lChangeStudentNameCurr);
        pChangeStudentNameContainer.add(lChangeStudentNameNew);
        pChangeStudentNameContainer.add(tfChangeStudentNameNew);
        pChangeStudentNameContainer.add(bChangeStudentNameSubmit);
        pChangeStudentNameContainer.add(bChangeStudentNameClose);

        // tab settings
        pChangeStudentNameContainer.setLayout(new GridLayout(3, 2, 5, 5));
        tabManager.addTab("Change Student Name", pChangeStudentNameContainer);
        tabManager.setSelectedComponent(pChangeStudentNameContainer);

        // event handlers
        ChangeStudentNameListener changeStudentNameListener = new ChangeStudentNameListener();
        bChangeStudentNameSubmit.addActionListener(changeStudentNameListener);
        bChangeStudentNameClose.addActionListener(changeStudentNameListener);
    }
    private class ChangeStudentNameListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent a){
            Object source = a.getSource();
            if(source == bChangeStudentNameSubmit){
                String newName = tfChangeStudentNameNew.getText();
                if(newName.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please Fill All Fields", "Null Text Field(s)", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    loggedInStudent.setName(newName);
                    lChangeStudentNameCurr.setText(loggedInStudent.getName());
                    JOptionPane.showMessageDialog(null, "New Name Set To: " + loggedInStudent.getName(), "Change Made", JOptionPane.PLAIN_MESSAGE);
                }
            }
            else if(source == bChangeStudentNameClose){
                closeTab(pChangeStudentNameContainer);
            }
        }
    }

    // change student email
    private void changeStudentEmail(){
        // setting text
        lChangeStudentEmailName.setText(loggedInStudent.getName());
        lChangeStudentEmailCurr.setText(loggedInStudent.getEmail());

        // adding components to panels
        pChangeStudentEmailContainer.add(lChangeStudentEmailText);
        pChangeStudentEmailContainer.add(lChangeStudentEmailName);
        pChangeStudentEmailContainer.add(lChangeStudentEmailLabel);
        pChangeStudentEmailContainer.add(lChangeStudentEmailCurr);
        pChangeStudentEmailContainer.add(lChangeStudentEmailNew);
        pChangeStudentEmailContainer.add(tfChangeStudentEmailNew);
        pChangeStudentEmailContainer.add(bChangeStudentEmailSubmit);
        pChangeStudentEmailContainer.add(bChangeStudentEmailClose);

        // tab settings
        pChangeStudentEmailContainer.setLayout(new GridLayout(4, 2, 5, 5));
        tabManager.addTab("Change Student Email", pChangeStudentEmailContainer);
        tabManager.setSelectedComponent(pChangeStudentEmailContainer);

        // event handlers
        ChangeStudentEmailListener changeStudentEmailListener = new ChangeStudentEmailListener();
        bChangeStudentEmailSubmit.addActionListener(changeStudentEmailListener);
        bChangeStudentEmailClose.addActionListener(changeStudentEmailListener);
    }
    private class ChangeStudentEmailListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent a){
            Object source = a.getSource();
            if(source == bChangeStudentEmailSubmit){
                String newEmail = tfChangeStudentEmailNew.getText();
                if(newEmail.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please Fill All Fields", "Null Text Field(s)", JOptionPane.ERROR_MESSAGE);
                }
                else if(!newEmail.contains("@") || !newEmail.contains(".")){
                    JOptionPane.showMessageDialog(null, "Email Looks Invalid", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    loggedInStudent.setEmail(newEmail);
                    lChangeStudentEmailCurr.setText(loggedInStudent.getEmail());
                    JOptionPane.showMessageDialog(null, "New Email Set To: " + loggedInStudent.getEmail(), "Change Made", JOptionPane.PLAIN_MESSAGE);
                }
            }
            else if(source == bChangeStudentEmailClose){
                closeTab(pChangeStudentEmailContainer);
            }
        }
    }

    // export student data 
    private void exportStudentData(){
        System.out.println("exporting...");
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
                closeTab(pInstructorContainer);
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
                displayStudent();
            }
            else if(source == bManageStudentClose){
                closeTab(pManageStudentContainer);
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
                closeTab(pAddStudentContainer);
            }
        }
    }

    // display students
    private void displayStudent(){
        // adding components to panels
        pDisplayStudentContainer.add(lDisplayStudentText);
        pDisplayStudentContainer.add(tfDisplayStudent);
        pDisplayStudentContainer.add(lDisplayStudentNameLabel);
        pDisplayStudentContainer.add(lDisplayStudentName);
        pDisplayStudentContainer.add(lDisplayStudentIDLabel);
        pDisplayStudentContainer.add(lDisplayStudentID);
        pDisplayStudentContainer.add(lDisplayStudentEmailLabel);
        pDisplayStudentContainer.add(lDisplayStudentEmail);
        pDisplayStudentContainer.add(bDisplayStudentSubmit);
        pDisplayStudentContainer.add(bDisplayStudentClose);

        // tab settings
        pDisplayStudentContainer.setLayout(new GridLayout(5,2,5,5));
        tabManager.addTab("Display Student", pDisplayStudentContainer);
        tabManager.setSelectedComponent(pDisplayStudentContainer);

        // event handlers
        DisplayStudentListener displayStudentListener = new DisplayStudentListener();
        bDisplayStudentSubmit.addActionListener(displayStudentListener);
        bDisplayStudentClose.addActionListener(displayStudentListener);
    }
    // display students event listener
    private class DisplayStudentListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent a) {
           Object source = a.getSource();
           if(source == bDisplayStudentSubmit){
                String ID = tfDisplayStudent.getText();
                // verifying input and displaying student
                if(ID.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please Fill All Fields", "Null Text Field(s)", JOptionPane.ERROR_MESSAGE);
                }
                else if(manager.getStudent(ID) == null){
                    JOptionPane.showMessageDialog(null, "Student At ID " + ID + " Does Not Exist", "Nonexistant Student", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    Student student = manager.getStudent(ID);
                    lDisplayStudentName.setText(student.getName());
                    lDisplayStudentID.setText(student.getID());
                    lDisplayStudentEmail.setText(student.getEmail());
                }
           }
           else if(source == bDisplayStudentClose){
                closeTab(pDisplayStudentContainer);
           }
        }
    }

    // manage assignment menu
    private void manageAssignmentsMenu(){
        // adding components to panels
        pManageAssignmentsText.add(lManageAssignmentsText);
        pManageAssignmentsContainer.add(pManageAssignmentsText);
        pManageAssignmentsContainer.add(bManageAssignmentsAdd);
        pManageAssignmentsContainer.add(bManageAssignmentsViewGrade);
        pManageAssignmentsContainer.add(bManageAssignmentsModGrade);
        pManageAssignmentsContainer.add(bManageAssignmentsClose);

        // tab settings
        pManageAssignmentsContainer.setLayout(new GridLayout(5, 1, 5, 5));
        tabManager.addTab("Manage Assignments", pManageAssignmentsContainer);
        tabManager.setSelectedComponent(pManageAssignmentsContainer);

        // event handlers
        ManageAssignmentsListener manageAssignmentsListener = new ManageAssignmentsListener();
        bManageAssignmentsAdd.addActionListener(manageAssignmentsListener);
        bManageAssignmentsViewGrade.addActionListener(manageAssignmentsListener);
        bManageAssignmentsModGrade.addActionListener(manageAssignmentsListener);
        bManageAssignmentsClose.addActionListener(manageAssignmentsListener);
    }
    // manage assignment event listener
    private class ManageAssignmentsListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent a) {
            Object source = a.getSource();
            if(source == bManageAssignmentsAdd){
                addAssignmentMenu();
            }
            else if(source == bManageAssignmentsViewGrade){
                instructorGradeSummaryMenu();
            }
            else if(source == bManageAssignmentsModGrade){
                editAssignmentMenu();
            }
            else if(source == bManageAssignmentsClose){
                closeTab(pManageAssignmentsContainer);
            }
        }
    }

    // add assignments menu
    private void addAssignmentMenu(){
        // adding components to panels
        pAddAssignmentContainer.add(lAddAssignmentCourseNameLabel);
        pAddAssignmentContainer.add(tfAddAssignmentCourseName);
        pAddAssignmentContainer.add(lAddAssignmentAssignmentNameLabel);
        pAddAssignmentContainer.add(tfAddAssignmentAssignmentName);
        pAddAssignmentContainer.add(lAddAssignmentMaxScoreLabel);
        pAddAssignmentContainer.add(tfAddAssignmentMaxScore);
        pAddAssignmentContainer.add(bAddAssignmentSubmit);
        pAddAssignmentContainer.add(bAddAssignmentClose);

        // tab settings 
        pAddAssignmentContainer.setLayout(new GridLayout(4,2,5,5));
        tabManager.addTab("Add Assignment", pAddAssignmentContainer);
        tabManager.setSelectedComponent(pAddAssignmentContainer);

        // event handlers
        AddAssignmentListener addAssignmentListener = new AddAssignmentListener();
        bAddAssignmentSubmit.addActionListener(addAssignmentListener);
        bAddAssignmentClose.addActionListener(addAssignmentListener);
    }
    private class AddAssignmentListener implements ActionListener{
         @Override
        public void actionPerformed(ActionEvent a){
            Object source = a.getSource();
            if(source == bAddAssignmentSubmit){
                String courseName = tfAddAssignmentCourseName.getText();
                String assignmentName = tfAddAssignmentAssignmentName.getText();
                String scoreTemp = tfAddAssignmentMaxScore.getText();

                // validating input and adding assignment
                if(courseName.isEmpty() || assignmentName.isEmpty() || scoreTemp.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please Fill All Fields", "Null Text Field(s)", JOptionPane.ERROR_MESSAGE);
                }
                try{
                    int maxScore = Integer.parseInt(scoreTemp);
                    if(maxScore < 0){
                        throw new IllegalArgumentException();
                    }
                    else if(manager.getCourse(courseName) == null){
                        JOptionPane.showMessageDialog(null, "Course Not Found", "Nonexistant Item", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        manager.addAssignment(courseName, assignmentName, maxScore);
                        JOptionPane.showMessageDialog(null, "Assignment " + assignmentName + " Successfully Added", "Item Added", JOptionPane.PLAIN_MESSAGE);
                    }
                }
                catch(IllegalArgumentException e){
                    JOptionPane.showMessageDialog(null, "Please Enter a Positive Whole Number", "Illegal Argument Exception", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if(source == bAddAssignmentClose){
                closeTab(pAddAssignmentContainer);
            }
        }
    }

    private void instructorGradeSummaryMenu(){
        // adding components to panels
        pInstructorStudentGradeContainer.add(lInstructorStudentGradeContainer);
        pInstructorStudentGradeContainer.add(tfInstructorStudentGradeID);
        pInstructorStudentGradeContainer.add(bInstructorStudentGradeSubmit);
        pInstructorStudentGradeContainer.add(bInstructorStudentGradeClose);

        // tab settings
        pInstructorStudentGradeContainer.setLayout(new GridLayout(2, 2, 5, 5));
        tabManager.addTab("Student Grade Summary", pInstructorStudentGradeContainer);
        tabManager.setSelectedComponent(pInstructorStudentGradeContainer);

        // event handlers
        GradeSummaryListener gradeSummaryListener = new GradeSummaryListener();
        bInstructorStudentGradeSubmit.addActionListener(gradeSummaryListener);
        bInstructorStudentGradeClose.addActionListener(gradeSummaryListener);
    }
    private class GradeSummaryListener implements ActionListener{
         @Override
        public void actionPerformed(ActionEvent a){
            Object source = a.getSource();
            if(source == bInstructorStudentGradeSubmit){
                String ID = tfInstructorStudentGradeID.getText();
                if(ID.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please Fill All Fields", "Null Text Field(s)", JOptionPane.ERROR_MESSAGE);
                }
                else if(manager.getStudent(ID) == null){
                    JOptionPane.showMessageDialog(null, "Student At ID " + ID + " Does Not Exist", "Nonexistant Student", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    instructorGradeStudent = manager.getStudent(ID);
                    gradeSummary(instructorGradeStudent);
                }
            }
            else if(source == bInstructorStudentGradeClose){
                closeTab(pInstructorStudentGradeContainer);
            }
        }
    }

    private void editAssignmentMenu(){
        // adding components to panels
        pEditAssignmentContainer.add(lEditAssignmentID);
        pEditAssignmentContainer.add(tfEditAssignmentID);
        pEditAssignmentContainer.add(lEditAssignmentAssignment);
        pEditAssignmentContainer.add(tfEditAssignmentAssignment);
        pEditAssignmentContainer.add(lEditAssignmentScore);
        pEditAssignmentContainer.add(tfEditAssignmentScore);
        pEditAssignmentContainer.add(bEditAssignmentSubmit);
        pEditAssignmentContainer.add(bEditAssignmentClose);

        // tab settings 
        pEditAssignmentContainer.setLayout(new GridLayout(4, 2, 5, 5));
        tabManager.addTab("Edit Student Assignment", pEditAssignmentContainer);
        tabManager.setSelectedComponent(pEditAssignmentContainer);

        // event handlers
        EditAssignmentListener editAssignmentListener = new EditAssignmentListener();
        bEditAssignmentSubmit.addActionListener(editAssignmentListener);
        bEditAssignmentClose.addActionListener(editAssignmentListener);
    }
    private class EditAssignmentListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent a) {
            Object source = a.getSource();
            if(source == bEditAssignmentSubmit){
                String ID = tfEditAssignmentID.getText();
                String assignmentName = tfEditAssignmentAssignment.getText();
                String scoreTemp = tfEditAssignmentScore.getText();
                if(ID.isEmpty() || assignmentName.isEmpty() || scoreTemp.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please Fill All Fields", "Null Text Field(s)", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try{
                    int score = Integer.parseInt(scoreTemp);
                    Student currStudent = manager.getStudent(ID);
                    Assignment assignment = currStudent.getAssignment(assignmentName);
                    if(score < 0){
                        throw new IllegalArgumentException();
                    }
                    else if(manager.getStudent(ID) == null){
                        JOptionPane.showMessageDialog(null, "Student At ID " + ID + " Does Not Exist", "Nonexistant Item", JOptionPane.ERROR_MESSAGE);
                    }
                    // @Bug -- assignment always shows as not found
                    else if(assignment == null){
                        JOptionPane.showMessageDialog(null, "Assignment " + assignmentName + " Not Found", "Nonexistant Item", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        assignment.setScore(score);
                        JOptionPane.showMessageDialog(null, "Assignment " + assignmentName + " Successfully Changed To Grade " + score, "Assignment Changed", JOptionPane.PLAIN_MESSAGE);
                    }
                }
                catch(IllegalArgumentException e){
                    JOptionPane.showMessageDialog(null, "Please Enter a Positive Whole Number", "Illegal Argument Exception", JOptionPane.ERROR_MESSAGE);

                }
            }
            else if(source == bEditAssignmentClose){
                closeTab(pEditAssignmentContainer);
            }
        }
    }

    // manage instructors menu & logic
    private void manageInstructorsMenu(){
        // adding components to panels
        pManageInstructorsText.add(lManageInstructorsText);
        pManageInstructorsContainer.add(pManageInstructorsText);
        pManageInstructorsContainer.add(bManageInstructorsAdd);
        pManageInstructorsContainer.add(bManageInstructorsDisplay);
        pManageInstructorsContainer.add(bManageInstructorsClose);

        // tab settings
        pManageInstructorsContainer.setLayout(new GridLayout(4, 1, 5, 5));
        tabManager.addTab("Manage Instructors Menu", pManageInstructorsContainer);
        tabManager.setSelectedComponent(pManageInstructorsContainer);

        // event handlers
        ManageInstructorsListener manageInstructorsListener = new ManageInstructorsListener();
        bManageInstructorsAdd.addActionListener(manageInstructorsListener);
        bManageInstructorsDisplay.addActionListener(manageInstructorsListener);
        bManageInstructorsClose.addActionListener(manageInstructorsListener);
    }
    private class ManageInstructorsListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent a) {
            Object source = a.getSource();
            if(source == bManageInstructorsAdd){
                addInstructorMenu();
            }
            else if(source == bManageInstructorsDisplay){
                displayInstructor();
            }
            else if(source == bManageInstructorsClose){
                closeTab(pManageInstructorsContainer);
            }
        }        
    }

    // add Instructor menu
    private void addInstructorMenu(){
        // adding components to panels
        pAddInstructorText.add(lAddInstructorText);
        pAddInstructorName.add(lAddInstructorName);
        pAddInstructorName.add(tfAddInstructorName);
        pAddInstructorEmail.add(lAddInstructorEmail);
        pAddInstructorEmail.add(tfAddInstructorEmail);
        pAddInstructorCourse.add(lAddInstructorCourse);
        pAddInstructorCourse.add(tfAddInstructorCourse);
        pAddInstructorButtons.add(bAddInstructorSumbit);
        pAddInstructorButtons.add(bAddInstructorClose);
        // putting in container panel
        pAddInstructorContainer.add(pAddInstructorText);
        pAddInstructorContainer.add(pAddInstructorName);
        pAddInstructorContainer.add(pAddInstructorEmail);
        pAddInstructorContainer.add(pAddInstructorCourse);
        pAddInstructorContainer.add(pAddInstructorButtons);

        // tab settings
        pAddInstructorContainer.setLayout(new GridLayout(5, 1, 5, 5));
        tabManager.addTab("Add Instructor Menu", pAddInstructorContainer);
        tabManager.setSelectedComponent(pAddInstructorContainer);

        // event handlers
        AddInstructorListener addInstructorListener = new AddInstructorListener();
        bAddInstructorSumbit.addActionListener(addInstructorListener);
        bAddInstructorClose.addActionListener(addInstructorListener);
    }
    // add Instructor menu logic
    private class AddInstructorListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent a) {
            Object source = a.getSource();
            if(source == bAddInstructorSumbit){
                String name = tfAddInstructorName.getText();
                String email = tfAddInstructorEmail.getText();
                String course = tfAddInstructorCourse.getText();
                // validates entrys and adds new student
                if(name.isEmpty() || email.isEmpty() || course.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please Fill All Fields", "Null Text Field(s)", JOptionPane.ERROR_MESSAGE);
                }
                else if(manager.getInstructor(name) != null){
                    JOptionPane.showMessageDialog(null, "Instructor Named " + name + " Already Exists", "Invalid Entry", JOptionPane.ERROR_MESSAGE);
                }
                else if(!email.contains("@") || !email.contains(".")){
                    JOptionPane.showMessageDialog(null, "Email Format Looks Invalid", "Invalid Entry", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    manager.addInstructor(email, name, course);
                    JOptionPane.showMessageDialog(null, "Instructor " + name + " Successfully Added", "Instructor Added", JOptionPane.DEFAULT_OPTION);
                }
            }
            else if(source == bAddInstructorClose){
                closeTab(pAddInstructorContainer);
            }
        }
    }

    // display instructor
    private void displayInstructor(){
        // adding components to panels
        pDisplayInstructorContainer.add(lDisplayInstructorText);
        pDisplayInstructorContainer.add(tfDisplayInstructor);
        pDisplayInstructorContainer.add(lDisplayInstructorNameLabel);
        pDisplayInstructorContainer.add(lDisplayInstructorName);
        pDisplayInstructorContainer.add(lDisplayInstructorCourseLabel);
        pDisplayInstructorContainer.add(lDisplayInstructorCourse);
        pDisplayInstructorContainer.add(lDisplayInstructorEmailLabel);
        pDisplayInstructorContainer.add(lDisplayInstructorEmail);
        pDisplayInstructorContainer.add(bDisplayInstructorSubmit);
        pDisplayInstructorContainer.add(bDisplayInstructorClose);

        // tab settings
        pDisplayInstructorContainer.setLayout(new GridLayout(5,2,5,5));
        tabManager.addTab("Display Instructor", pDisplayInstructorContainer);
        tabManager.setSelectedComponent(pDisplayInstructorContainer);

        // event handlers
        DisplayInstructorListener displayInstructorListener = new DisplayInstructorListener();
        bDisplayInstructorSubmit.addActionListener(displayInstructorListener);
        bDisplayInstructorClose.addActionListener(displayInstructorListener);
    }
    // display Instructor event listener
    private class DisplayInstructorListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent a) {
           Object source = a.getSource();
           if(source == bDisplayInstructorSubmit){
                String name = tfDisplayInstructor.getText();
                // verifying input and displaying Instructor
                if(name.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please Fill All Fields", "Null Text Field(s)", JOptionPane.ERROR_MESSAGE);
                }
                else if(manager.getInstructor(name) == null){
                    JOptionPane.showMessageDialog(null, "Instructor With Name: " + name + " Does Not Exist", "Nonexistant Item", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    Instructor instructor = manager.getInstructor(name);
                    lDisplayInstructorName.setText(instructor.getName());
                    lDisplayInstructorCourse.setText(instructor.getCourseName());
                    lDisplayInstructorEmail.setText(instructor.getEmail());
                }
           }
           else if(source == bDisplayInstructorClose){
                closeTab(pDisplayInstructorContainer);
           }
        }
    }

    // manage courses menu & logic
    private void manageCoursesMenu(){
        System.out.println("managing courses...");
    }


    // grade summary
    private void gradeSummary(Student student){
        System.out.println("grade summary for " + student.getName());
    }
    
}