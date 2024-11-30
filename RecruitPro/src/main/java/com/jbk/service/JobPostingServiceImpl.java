package com.jbk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.JobPostingDaoImpl;
import com.jbk.entities.JobPosting;

@Service
public class JobPostingServiceImpl implements JobPostingService {

	@Autowired
	JobPostingDaoImpl jobPostingDaoImpl;
	
	@Override
	public int createJobPosting(JobPosting jobPosting) {

		int status = jobPostingDaoImpl.createJobPosting(jobPosting);
		return status;
	}

}
