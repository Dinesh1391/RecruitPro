package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.StudentDaoImpl;
import com.jbk.entities.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDaoImpl studentDaoImpl;
	
	@Override
	public int createStudent(Student student) {

		int status = studentDaoImpl.createStudent(student);
		return status;
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> list = studentDaoImpl.getAllStudent();
		return list;
	}

	public int createMultipleStudent(List<Student> studentlist) {
		
		int status = studentDaoImpl.createMultipleStudent(studentlist);
		return status;
		
	}

	public int deleteStudent(long id) {
		
		int status = studentDaoImpl.deleteStudent(id);
		return status;
		
	}

	@Override
	public int updateStudent(Student student) {
		
	    int updateStudent = studentDaoImpl.updateStudent(student);
	    return updateStudent;
	}

	

	

}
