package com.jbk.dao;

import java.util.List;

import com.jbk.entities.Student;

public interface StudentDao {

	public int createStudent(Student student);
	
	public List<Student> getAllStudent();
	
	public int createMultipleStudent(List<Student> studentlist);
	
	public int deleteStudent(long id) ;
	
	public int updateStudent(Student student);
}
