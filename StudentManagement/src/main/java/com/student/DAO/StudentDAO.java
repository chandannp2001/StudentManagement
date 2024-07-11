package com.student.DAO;

import java.util.List;
import com.student.Model.*;

public interface StudentDAO {
	
	// Create operation
    boolean addStudent(Student student);

    // Read operations
    Student getStudentById(int id);
    List<Student> getAllStudents();

    // Update operation
    boolean updateStudent(Student student);

    // Delete operation
    boolean deleteStudent(int id);
    
    List<Student> searchStudentsById(int id);
    List<Student> searchStudentsByName(String name);
    List<Student> searchStudentsByEmail(String email);
    List<Student> searchStudentsByAge(int age);

}
