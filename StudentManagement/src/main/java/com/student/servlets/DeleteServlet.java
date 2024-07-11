package com.student.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.DAOImpl.StudentDAOImpl;
import com.student.Model.Student;


import java.io.IOException;
import java.util.List;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        StudentDAOImpl studentDAO = new StudentDAOImpl();
        boolean deleted = studentDAO.deleteStudent(id);

        if (deleted) {
            request.setAttribute("message", "Student deleted successfully.");
        } else {
            request.setAttribute("message", "Failed to delete student.");
        }

        List<Student> students = studentDAO.getAllStudents();

        request.setAttribute("students", students);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
