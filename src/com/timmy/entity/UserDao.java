package com.timmy.entity;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

public class UserDao {
	
	private HibernateTemplate hibernateTemplate;
	
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	public void add()
	{
		System.out.println("userdao...........");
		//User user=new User();
		//user.setUid(1);
//		user.setPassword("12345");
//		user.setUsername("kxyq");
//		hibernateTemplate.save(user);
	}


	


	public User loginUser(User user) {
		@SuppressWarnings("unchecked")
		List<User> list=(List<User>) hibernateTemplate.find("from User where username=? and password=?",user.getUsername(),user.getPassword());
		if(list!=null&&list.size()!=0)
		{
			User u=list.get(0);
			return u;
		}
		return null;
	}

}
