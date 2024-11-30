package com.jbk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.UserDaoImpl;
import com.jbk.dto.LoginRequest;
import com.jbk.entities.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDaoImpl userDaoImpl;

	@Override
	public int createUser(User user) {
		int status = userDaoImpl.createUser(user);
		return status;
	}

	@Override
	public int deleteUser(String username) {
		int status = userDaoImpl.deleteUser(username);
		return status;
	}

	

	@Override
	public User getUserByUsername(String username) {

		User user = userDaoImpl.getUserByUsername(username);
		return user;
	}

	@Override
	public User LoginUser(LoginRequest loginRequest) {
		User user = userDaoImpl.loginuser(loginRequest);
		return user;
	}

}
