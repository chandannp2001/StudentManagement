package com.student.DAOImpl;

import java.util.List;

import com.student.Model.Student;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentDAOImpl simp = new StudentDAOImpl();
		Student s = new Student("Chandan N Pn", "chandan@gmail.com", 27);
////		simp.addStudent(s);
//		List<Student> l =simp.searchStudentsByAge(30);
//	    for(Student s1:l)
//	    {
//	    	System.out.println(s1);
//	    }
//		Student s1 =simp.getStudentByEmail("chandannp2001@gmail.com");
//		System.out.println(s1);
//		s1.setEmail("chandannp2001@gmail.com");
//		simp.updateStudent(s1);
//		simp.deleteStudent(2);
//		simp.addStudent(s);
//		Student s1 =simp.getStudentById(3);
		simp.deleteStudent(3);
//		s1.setAge(30);
//		simp.updateStudent(s1);

	}

}
