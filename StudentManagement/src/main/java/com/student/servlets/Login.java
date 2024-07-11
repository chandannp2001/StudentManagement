package com.student.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Collect parameters from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        HttpSession session = request.getSession();
        
        
        if(username.equals("admin")&& password.equals("12345")) {
        
            request.getRequestDispatcher("/ReadServlet").forward(request, response);
            return;
        }else {
        	session.setAttribute("errorMSG", "Invalid Credentials! Try again ");
            request.getRequestDispatcher("index.jsp").include(request, response);
            return;
        }
     }
}
