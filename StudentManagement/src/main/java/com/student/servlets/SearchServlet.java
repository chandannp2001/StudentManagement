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

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDAOImpl studentDAO;

    public SearchServlet() {
        this.studentDAO = new StudentDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchBy = request.getParameter("searchBy");
        String query = request.getParameter("query");

        List<Student> students = null;
        switch (searchBy) {
            case "id":
                students = studentDAO.searchStudentsById(Integer.parseInt(query));
                break;
            case "name":
                students = studentDAO.searchStudentsByName(query);
                break;
            case "email":
                students = studentDAO.searchStudentsByEmail(query);
                break;
            case "age":
                students = studentDAO.searchStudentsByAge(Integer.parseInt(query));
                break;
        }

        request.setAttribute("students", students);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
