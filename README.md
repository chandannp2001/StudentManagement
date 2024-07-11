Student Management System Overview The Student Management System is a web-based application designed to manage student records. It allows users to add, update, delete, and search for students. The system is built using Java, JSP, Servlets, and MySQL.

To run appllication you need eclipse IDE and MySQL database and Tomcat server .
Import Code to IDE and create a database named "student_db" and Tabel named Students having columns Id(int,autoincrement),Name(varchar()),Email(varchar()),Age(int).
Change the database details like url,username, password according to yours database in the  class named "DatabaseUtil" in "com.student.util" package.

How to Run
Deploy the application: -> Deploy the application on the Apache Tomcat server.

Access the application: -> Open a web browser and go to http://localhost:8080/StudentManagement/.

Using the Application: -> Home Page: Displays options to add a student or view the student list. -> Add Student: Fill in the student details and submit the form to add a new student. ->View Students: Displays all students. Options are available to update or delete each student. ->Search Students: Use the search bar to find students by ID, name, email, or age.

After successfully completion of above setup steps.Run the application using tomcat server and acess web application the first page contains Login Form.
Login credentials -
 UserName:"admin" 
 Password -"12345" 

 After Successfull login you redirect to Home page containing List of Students ,Delete and Edit option and a button to Add Student details and View all Students option. 
 A search bar for to Search Students: Use the search bar to find students by ID, name, email, or age.

 Functionality of Features:
 
 1)  Add Student: When a user fills in the student details and clicks the "Submit" button, the form data is sent to the CreateServlet. CreateServlet collects the data, creates a new Student object, and uses StudentDAOImpl to add the student to the database. After adding the student, the user is redirected back to the home page (home.jsp) with a success message.
 
 2)  View All Students: When a user clicks the "View  All Students" button, the request is sent to the ReadServlet. ReadServlet retrieves the list of students from the database using StudentDAOImpl and sets this list as a request attribute. The user is forwarded to home.jsp, which displays the list of students.
   
 3)  Update Student: When a user clicks the "Edit" button next to a student, they are redirected to an update form (update.jsp). After updating the details and submitting the form, the data is sent to the UpdateServlet. UpdateServlet updates the student details in the database and redirects back to home.jsp with a success message.
    
 4)  Delete Student: When a user clicks the "Delete" button next to a student, a confirmation pop-up appears. Upon confirmation, the request is sent to the DeleteServlet. DeleteServlet deletes the student from the database and redirects back to home.jsp with a success message.
      
 5)  Search Students: Users can search for students using the search bar on the home page. The search form sends the search parameters to the SearchServlet. SearchServlet retrieves the matching students from the database and forwards the list to home.jsp for display.

