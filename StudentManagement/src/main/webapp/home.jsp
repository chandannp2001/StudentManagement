<%@ page import="java.util.List" %>
<%@ page import="com.student.Model.Student" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Management</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .container {
            margin-top: 50px;
        }
        .navbar {
            position: sticky;
            top: 0;
            z-index: 1000;
            background-color:  #007bff;
        }
        .navbar a {
            color: white;
        }
        .table {
            margin-top: 20px;
            background-color: #f9f9f9; /* Changed background color */
        }
        .table th {
            background-color: #4CAF50; /* Changed header background color */
            color: white;
        }
        .table td {
            border: 1px solid #dee2e6;
        }
        .btn {
            margin-right: 5px;
        }
        .btn-warning {
            background-color: #ffcc00; /* Changed color for Edit button */
            border-color: #ffcc00;
        }
        .btn-danger {
            background-color: #e60000; /* Changed color for Delete button */
            border-color: #e60000;
        }
        .btn-outline-success {
            color: #28a745;
            border-color: #28a745;
        }
        .btn-outline-success:hover {
            color: white;
            background-color: #28a745;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#">Student Management</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="add.jsp">Add Student</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ReadServlet">View All Students</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0" action="search" method="get">
                <select class="form-control mr-sm-2" name="searchBy" required>
                    <option value="" disabled selected>Search By</option>
                    <option value="id">ID</option>
                    <option value="name">Name</option>
                    <option value="email">Email</option>
                    <option value="age">Age</option>
                </select>
                <input class="form-control mr-sm-2" type="search" name="query" placeholder="Search" aria-label="Search" required>
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>

    <div class="container">
        <%-- Check if students list is not null and not empty --%>
        <%
            List<Student> students = (List<Student>) request.getAttribute("students");
            String message = (String) request.getAttribute("message");
            if (students != null && !students.isEmpty()) {
        %>
        <%-- Check for a success message --%>
        <%
            if (message != null) {
        %>
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            <%= message %>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <% } %>

        <h2>Student List</h2>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Age</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <% for (Student student : students) { %>
                <tr>
                    <td><%= student.getId() %></td>
                    <td><%= student.getName() %></td>
                    <td><%= student.getEmail() %></td>
                    <td><%= student.getAge() %></td>
                    <td>
                        <a href="update.jsp?id=<%= student.getId() %>" class="btn btn-warning">Edit</a>
                        <a href="delete?id=<%= student.getId() %>" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete the student <%= student.getId() %>?');">Delete</a>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <% } else { %>
        <div class="alert alert-info" role="alert">
            No students found.
        </div>
        <% } %>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <%-- Display the alert message if present --%>
    <%
        if (message != null) {
    %>
    <script>
        alert("<%= message %>");
    </script>
    <% } %>
</body>
</html>
