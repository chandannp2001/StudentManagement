package com.student.servlets;

import com.student.DAOImpl.StudentDAOImpl;
import com.student.Model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));

        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setEmail(email);
        student.setAge(age);

        StudentDAOImpl studentDAO = new StudentDAOImpl();
        boolean updated = studentDAO.updateStudent(student);

        if (updated) {
            // Set a success message
            request.setAttribute("message", "Student updated successfully.");
        } else {
            // Optionally, set an error message if update fails
            request.setAttribute("message", "Failed to update student.");
        }

        List<Student> students = studentDAO.getAllStudents();

        request.setAttribute("students", students);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
