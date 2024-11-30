package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entities.Student;
import com.jbk.service.StudentServiceImpl;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentServiceImpl studentServiceImpl;
	
	
	@PostMapping("/create-student")
	public String createStudent(@RequestBody  Student student) {
		
		int status = studentServiceImpl.createStudent(student);
		switch (status) {
		case 1: {
			return "Student has been added successfully!";
		}
		case 2: {
			return "Student already exists in the system.";
		}
		case 3: {
			return "Student could not be found in the system.";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + status);
		}
	}
	
	@GetMapping("/fetchAll")
	public List<Student> getAllStudent(){
		
		List<Student> list = studentServiceImpl.getAllStudent();
		if(list!=null) {
			return list;
		}else {
			return null;
		}
	}
	
	@PostMapping("/get-multiple")
	public String createMultipleStudent(@RequestBody List<Student> studentlist) {
		
		int status = studentServiceImpl.createMultipleStudent(studentlist);
		switch (status) {
		case 1: {
			return "Student has been added successfully!";
		}
		case 2: {
			return "Student already exists in the system.";
		}
		case 3: {
			return "Student could not be found in the system.";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + status);
		}
		
	}
	
	
	@DeleteMapping("/delete-student/{id}")
	public String deleteStudent(@PathVariable long id) {
		int status = studentServiceImpl.deleteStudent(id);
		
		switch (status) {
		case 1: {
			return "Student delete successfully!";
		}
		case 2: {
			return "Student already  deleted in system.";
		}
		case 3: {
			return "Student could not be found in the system.";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + status);
		}
		
	}
	
	@PutMapping("/update")
	public String updateStudent(@RequestBody Student student) {
	    int status = studentServiceImpl.updateStudent(student);
	    switch (status) {
	        case 1:{
	            return "Update successful";
	        }
	        case 2:{
	            return "Student not found";
	        }
	        case 3:{
	            return "Error during update";
	        }
	        default:{
	            throw new IllegalArgumentException("Unexpected value: " + status);
	    }
	    }
	}

}
