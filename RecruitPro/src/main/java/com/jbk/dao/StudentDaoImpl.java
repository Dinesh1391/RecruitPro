package com.jbk.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entities.Student;

@Repository
public class StudentDaoImpl implements StudentDao {


	@Autowired
	SessionFactory sessionFactory;

	@Override
	public int createStudent(Student student) {

		try {
			Session session = sessionFactory.openSession();
			Student dbStudent = session.get(Student.class, student.getId());
			if(dbStudent == null) {
				session.save(student);
				session.beginTransaction().commit();
				return 1;
			}else {
				return 2;
			}
		} catch (Exception e) {

			e.printStackTrace();
			return 3;
		}
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> list=null;

		try {
			Session session = sessionFactory.openSession();
			list=session.createQuery("From Student",Student.class).getResultList();
			session.beginTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public int createMultipleStudent(List<Student> studentlist) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {

			if(studentlist!=null && !studentlist.isEmpty()) {
				for(Student student: studentlist) {
					session.save(student);
				}
				transaction.commit();
				return 1;
			}else {
				return 2;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return 3;
		}
	}

	@Override
	public int deleteStudent(long id) {
		Session session = sessionFactory.openSession();
		Student student=null;
		try {
			student = session.get(Student.class,id);
			if(student!=null) {
				session.delete(student);
				session.beginTransaction().commit();
				return 1;
			}else {
				return 2;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 3;
		}

	}

	@Override
	public int updateStudent(Student student) {
	    Session session = sessionFactory.openSession();
	    Transaction transaction = null;
	    try {
	        transaction = session.beginTransaction();
	        Student dbStudent = session.get(Student.class, student.getId());
	        if (dbStudent != null) {
	            dbStudent.setFullName(student.getFullName());
	            dbStudent.setEmail(student.getEmail());
	            dbStudent.setContactNumber(student.getContactNumber());
	            dbStudent.setDepartment(student.getDepartment());
	            dbStudent.setGraduationYear(student.getGraduationYear());
	            dbStudent.setPassword(student.getPassword());
	            session.update(dbStudent); 
	            transaction.commit();
	            return 1; 
	        } else {
	            return 2; 
	        }
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	        return 3; 
	    }
	}

}
