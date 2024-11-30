package com.jbk.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entities.User;
import com.jbk.service.UserServiceImpl;



@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;

	@PostMapping("/create-user")
	public String createUser(@RequestBody @Valid User user) {
		int status = userServiceImpl.createUser(user);

		switch (status) {
		case 1 :{

			return"User has been Added Successfully";
		}
		case 2 :{

			return"User already exists in the System";
		}
		case 3 :{

			return"User could not be found in the system";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + status);
		}


	}

	@DeleteMapping("/delete-user")
	public String deleteByUser(@RequestParam (name ="username")String username) {
		int status = userServiceImpl.deleteUser(username);

		switch (status) {                                                          

		case 1 :{                                      

			return"User has been Deleted Successfully";     
		} 
		case 2 :{                                          

			return"User does not System";        
		}

		case 3 :{                                                              

			return"User could not be found in the system";                        
		}                                                                      
		default:                                                               
			throw new IllegalArgumentException("Unexpected value: " + status);    
		}                                                                      

	}
	
	@GetMapping("/by-username/{username}")
	public Object getUserByUserName(@PathVariable @Valid String username) {
		User user = userServiceImpl.getUserByUsername(username);
		return user;
	}

}