package com.timmy.entity;

import org.springframework.orm.hibernate5.HibernateTemplate;

public class CustomerDao {
	
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public void add(Customer customer)
	{
		hibernateTemplate.save(customer);
	}

}
