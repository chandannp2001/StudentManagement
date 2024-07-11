To run appllication you need eclipse IDE and MySQL database and Tomcat server .
Import Code to IDE and create a database named "student_db" and Tabel named Students having columns Id(int,autoincrement),Name(varchar()),Email(varchar()),Age(int).
Change the database details like url,username, password according to yours database in the  class named "DatabaseUtil" in "com.student.util" package.

After successfully completion of above setup steps.Run the application using tomcat server and index .jsp page will  execute and it contains Login Form.
Login credentials -
 UserName:"student" 
 Password -"12345" 

 After Successfull login you redirect to Home page containing List of Students ,Delete and Edit option and a button to Add Student details and View all Students option. 
