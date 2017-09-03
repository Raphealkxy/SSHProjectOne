package com.timmy.entity;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CustomerService {
	
	
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	public void add(Customer customer)
	{
		customerDao.add(customer);
	}
	public List<Customer> findAll() {
		
		List<Customer> lists=customerDao.findAll();
		return lists;
	}
	public Customer findone(int cid) {
		return customerDao.findone(cid);
	}
	public void delete(Customer c) {
                     customerDao.delete(c);		
	}
	public void update(Customer c) {
              customerDao.update(c);		
	}
	public PageBean listPage(int currentPage) {
		PageBean pageBean=new PageBean();
		pageBean.setCurrentPage(currentPage);
		int  total=customerDao.findtotal();
		pageBean.setTotalcount(total);
		int pagesize=3;
		pageBean.setPageSize(pagesize);
		int pagetotal;
		if(total%pagesize==0)
		{
			pagetotal=total/pagesize;
		}else{
			pagetotal=total/pagesize+1;
		}
		pageBean.setTotalPage(pagetotal);
		
		int begin=(currentPage-1)*pagesize;
		pageBean.setBegin(begin);
		
		List<Customer>customers=customerDao.findlist(begin,pagesize);
		pageBean.setList(customers);
		return pageBean;
	}
	

}
