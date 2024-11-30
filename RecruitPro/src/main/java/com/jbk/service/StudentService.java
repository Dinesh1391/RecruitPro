package com.jbk.service;

import java.util.List;

import com.jbk.entities.Student;

public interface StudentService {

	public int createStudent(Student student);
	
	public List<Student> getAllStudent();
	
	public int createMultipleStudent(List<Student> studentlist);
	
	public int deleteStudent(long id) ;
	
	public int updateStudent(Student student);
}
