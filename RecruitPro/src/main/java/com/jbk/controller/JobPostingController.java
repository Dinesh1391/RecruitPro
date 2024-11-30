package com.jbk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entities.JobPosting;
import com.jbk.service.JobPostingServiceImpl;

@RestController
@RequestMapping("/jobPosting")
public class JobPostingController {

	@Autowired
	JobPostingServiceImpl jobPostingServiceImpl;
	
	@PostMapping("/create-job-post")
	public String createJobPosting(@RequestBody JobPosting jobPosting) {
		int status = jobPostingServiceImpl.createJobPosting(jobPosting);
		System.out.println("Status =>" + status);
		switch (status) {
		case 1: {
			return "Job Post has been added successfully!";
		}
		case 2: {
			return "Job Post already exists in the system.";
		}
		case 3: {
			return "Job Post could not be found in the system.";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + status);
		}
	}
}
