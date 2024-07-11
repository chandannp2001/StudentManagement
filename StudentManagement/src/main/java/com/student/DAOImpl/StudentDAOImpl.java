package com.student.DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.student.DAO.StudentDAO;
import com.student.Model.Student;
import com.student.util.DatabaseUtil;

public class StudentDAOImpl implements StudentDAO {//id    , name   , email  ,   age     students
	
	private Connection connection;

    private static final String INSERT_STUDENT = "INSERT INTO students (name, email, age) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_STUDENTS = "SELECT * FROM students";
    private static final String SELECT_STUDENT_BY_ID = "SELECT * FROM students WHERE id = ?";
    private static final String UPDATE_STUDENT = "UPDATE students SET name = ?, email = ?, age = ? WHERE id = ?";
    private static final String DELETE_STUDENT = "DELETE FROM students WHERE id = ?";
    private static final String SEARCH_STUDENTS_BY_ID = "SELECT * FROM students WHERE id = ?";
    private static final String SEARCH_STUDENTS_BY_NAME = "SELECT * FROM students WHERE name LIKE ?";
    private static final String SEARCH_STUDENTS_BY_EMAIL = "SELECT * FROM students WHERE email LIKE ?";
    private static final String SEARCH_STUDENTS_BY_AGE = "SELECT * FROM students WHERE age = ?";

    public StudentDAOImpl() {
        DatabaseUtil dbUtil = new DatabaseUtil();
        this.connection = dbUtil.getConnection();
    }

    @Override
    public boolean addStudent(Student student) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getAge());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                students.add(extractStudentFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public Student getStudentById(int id) {
        Student student = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                student = extractStudentFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public boolean updateStudent(Student student) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setInt(4, student.getId());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteStudent(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT)) {
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Student> searchStudentsById(int id) {
        List<Student> students = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_STUDENTS_BY_ID)) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                students.add(extractStudentFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public List<Student> searchStudentsByName(String name) {
        List<Student> students = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_STUDENTS_BY_NAME)) {
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                students.add(extractStudentFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public List<Student> searchStudentsByEmail(String email) {
        List<Student> students = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_STUDENTS_BY_EMAIL)) {
            preparedStatement.setString(1, "%" + email + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                students.add(extractStudentFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public List<Student> searchStudentsByAge(int age) {
        List<Student> students = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_STUDENTS_BY_AGE)) {
            preparedStatement.setInt(1, age);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                students.add(extractStudentFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    private Student extractStudentFromResultSet(ResultSet rs) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));
        student.setEmail(rs.getString("email"));
        student.setAge(rs.getInt("age"));
        return student;
    }
}
