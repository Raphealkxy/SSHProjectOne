package com.timmy.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.timmy.entity.Customer;
import com.timmy.entity.CustomerService;
import com.timmy.entity.PageBean;

public class customerAction extends ActionSupport implements ModelDriven<Customer> {

	private CustomerService customerService;
	
	private Customer customer=new Customer();
	
	private int currentPage;
	

	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public CustomerService getCustomerService() {
		return customerService;
	}


	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}


	@Override
	public String execute() throws Exception {
		return NONE;
	}


	@Override
	public Customer getModel() {
		return customer;
	}
	
	public String add()
	{
		customerService.add(customer);
		
		System.out.println("add..................");
		return "addsuccess";
	}
	
	public String toaddpage()
	{
		
		
		return "toaddpage";
	}
	
	public String list()
	{
		
		List<Customer>customers=customerService.findAll();
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("list", customers);
		return "listsuccess";
	}
	
	public String deleteCus()
	{
		Customer c=findone();
		if(c!=null)
		{customerService.delete(c);}
		
		return "deletesuccess";
	}
	
	public Customer findone()
	{
		
		return customerService.findone(customer.getCid());
	}
	
	public String updateCus()
	{
		
		return "update";
	}
	
	public String showCustomer()
	{
		Customer c=findone();
       HttpServletRequest request=ServletActionContext.getRequest();
       request.getSession().setAttribute("customer", c);
		
		return "showcustomer";
	}
	
	public String update()
	{
		//Customer c=findone();
       customerService.update(customer);
//		System.out.println(customer.getCid()+"::"+customer.getCustLevel());
		return "update";
	}
	
	public String listPage()
	{
		PageBean pageBean=customerService.listPage(currentPage);
		if(pageBean!=null)
		{
			HttpServletRequest request=ServletActionContext.getRequest();
			request.getSession().setAttribute("pageBean", pageBean);
		}
		return "listPage";
	}

}
