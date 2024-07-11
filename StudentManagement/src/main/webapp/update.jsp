<%@ page import="com.student.DAOImpl.StudentDAOImpl" %>
<%@ page import="com.student.Model.Student" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Student</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .container {
            max-width: 600px;
            margin-top: 50px;
            background-color: #f9f9f9;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .form-group label {
            color: #495057;
        }
        .form-control {
            border-radius: 8px;
        }
        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
            border-radius: 8px;
        }
        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #004085;
        }
        .header {
            text-align: center;
            margin-bottom: 20px;
        }
        .header h2 {
            color: #343a40;
        }
        .header p {
            color: #6c757d;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h2>Update Student</h2>
            <p>Updating details for student ID: <strong><%= Integer.parseInt(request.getParameter("id")) %></strong></p>
        </div>
        <%
            int id = Integer.parseInt(request.getParameter("id"));
            StudentDAOImpl studentDAO = new StudentDAOImpl();
            Student student = studentDAO.getStudentById(id);
        %>
        <form action="update" method="post">
            <input type="hidden" name="id" value="<%= student.getId() %>">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" class="form-control" id="name" name="name" value="<%= student.getName() %>" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" value="<%= student.getEmail() %>" required>
            </div>
            <div class="form-group">
                <label for="age">Age:</label>
                <input type="number" class="form-control" id="age" name="age" value="<%= student.getAge() %>" required>
            </div>
            <button type="submit" class="btn btn-primary btn-block">Update</button>
        </form>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
