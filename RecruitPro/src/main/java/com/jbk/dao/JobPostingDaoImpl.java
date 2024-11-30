package com.jbk.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entities.JobPosting;

@Repository
public class JobPostingDaoImpl implements JobPostingDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public int createJobPosting(JobPosting jobPosting) {
		
		Session session = sessionFactory.openSession();
		JobPosting dbJobPosting = session.get(JobPosting.class, jobPosting.getId());
		try {
			if(dbJobPosting == null) {
				session.save(jobPosting);
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

}
