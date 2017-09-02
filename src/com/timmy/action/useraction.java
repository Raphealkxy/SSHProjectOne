package com.timmy.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.timmy.entity.User;
import com.timmy.entity.UserService;

public class useraction extends ActionSupport{

	private String username;
	private String password;
	
	private UserService userService;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String login()
	{
		//System.out.println(username);
		User user=new User();
		user.setPassword(password);
		user.setUsername(username);
		User userexist=userService.login(user);
		if(userexist!=null)
		{
			HttpServletRequest request=ServletActionContext.getRequest();
			request.getSession().setAttribute("user", userexist);
		//	System.out.println(userexist.getUsername());
			return "loginSuccess";

		}else{
			return "login";

		}
	}

	@Override
	public String execute() throws Exception {
		userService.add();
		return "login";
	}
	
	
	
	

}
