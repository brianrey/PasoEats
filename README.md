# PasoEats
# CS 231 - Course Management System (Java)

## Objective
This project aims to design and implement a simplified course management system using Java. It will serve as a practical exercise to demonstrate your understanding of object-oriented programming (OOP) principles and data structures for managing academic information.

## System Requirements
The course management system should encompass the following core functionalities:

### Course Information
- Store and display basic course details: 
  - Course Name (e.g., "Introduction to Programming")
  - Meeting Time (e.g., "MWF 10:00 AM - 10:50 AM") 
  - Room Number (e.g., "Bldg 52, Rm E27")
  - Instructor information (e.g., Name)

### Student Roster
- Allow adding and storing student names, emails etc

### Assignment & Grading
- Store assignment details (e.g., Assignment Name like "Homework 1", "Midterm Exam"). You might consider storing max possible points for each assignment.
- Record grades for each student on each assignment.

### Grade Calculation & Access & Export
- Calculate the average grade for a specific student based on their recorded assignment grades (e.g., total points earned / total points possible, or simple average percentage).
- Determine a letter grade for a student based on their average, using a predefined scale (e.g., 90-100% = A, 80-89% = B, 70-79% = C, 60-69% = D, <60% = F). This scale should be clearly defined within your system or documentation.
- Provide mechanisms for an instructor to view all student grades and averages.
- Provide mechanisms for a student to view their own grades, average, and letter grade.
- Implement functionality to export grade information to a plain text file (.txt):
  - An instructor should be able to generate a text file with information about a student, their assignment grades, and their overall average/letter grade (if available).
  - A student should also be able to generate a text file containing their own name, assignment grades, and their overall average/letter grade.

## Tasks
To successfully complete this project, you will need to undertake the following tasks:

### Design
- Create comprehensive class diagrams to model the system's structure. Include all relevant classes (e.g., Course, Student, Assignment, Grade) and their attributes and methods.
- Identify the relationships between these classes.
- Ensure your design adheres to fundamental OOP principles.

### OOP Principles
- Provide a detailed explanation of how your design incorporates the four fundamental OOP principles:
  - Encapsulation: How data is protected and accessed.
  - Abstraction: How complex implementation details are hidden.
  - Inheritance: (If applicable) How classes might inherit properties/behaviors.
  - Polymorphism: (If applicable) How objects can be treated as different instances of their parent class.

### Data Structures
- Describe the data structures you will use to implement the system's functionalities (e.g., storing lists of students, mapping students to grades, storing assignments). Examples might include Array, ArrayList etc.
- Justify your choices based on the specific requirements.

### Implementation
- Write the Java code to implement the system based on your design.
- Include necessary methods for:
  - Adding/managing class information.
  - Adding students to the roster.
  - Adding assignments.
  - Recording student grades for assignments.
  - Calculating student averages and letter grades.
  - Displaying relevant information for instructors and students.
- You may utilize GitHub for collaborative development (if applicable) and version control.

### Demonstration
- You will be required to demonstrate your working system. Specific instructions for the demonstration format and schedule will be provided later.

## Submission and Deadlines

### Thursday 16 April 2025 (100 points)
- Submit a PDF document named CS231_GROUP_NAME.pdf
- This document should include:
  - The first version of the system design (Class diagrams).
  - Explanations of how you applied OOP principles in your design.
  - Descriptions and justifications for the chosen data structures.
- One person from each group should submit the document.

#### Grading Rubric (for this submission only)
- Design (60%): The system is well-designed using OOP principles, and class diagrams clearly represent the system's structure and relationships.
- Data Structures (30%): Appropriate data structures are chosen, justified, and seem suitable for the task.
- Document Clarity (10%): The submitted document is clear, concise, well-organized, and easy to read.

### Thursday 24 April 2025 (100 points)
- Submit a revised version of the system design based on feedback received.

### Wednesday 6 / Thursday 7 May (100 points)
- Demonstrate the current system code with core classes implemented and basic interactions working (e.g., adding students, adding assignments).

### Thursday 15 May (150 points)
- Submit the final code and document.
