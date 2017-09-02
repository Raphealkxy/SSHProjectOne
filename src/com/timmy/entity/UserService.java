package com.timmy.entity;

import org.springframework.transaction.annotation.Transactional;

import com.timmy.action.useraction;

@Transactional
public class UserService {
	
	private UserDao userDao;
	
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	public void add()
	{
		System.out.println("userservice...............");
		userDao.add();
	}


	public User login(User user) {
		
		return userDao.loginUser(user);
	}

}
