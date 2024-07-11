package com.student.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.DAOImpl.StudentDAOImpl;
import com.student.Model.Student;


@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Collect parameters from the request
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));

        // Create a new student object
        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setAge(age);

        // Use StudentDAOImpl to add the student to the database
        StudentDAOImpl studentDAO = new StudentDAOImpl();
        boolean added = studentDAO.addStudent(student);

        if (added) {
            request.setAttribute("message", "Student added successfully.");
        } else {
            request.setAttribute("message", "Failed to add student.");
        }

        List<Student> students = studentDAO.getAllStudents();

        request.setAttribute("students", students);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}

