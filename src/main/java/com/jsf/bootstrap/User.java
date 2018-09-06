package com.jsf.bootstrap;


import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.wf.bussines.services.UserService;
import com.wf.controllers.dto.UserDto;
import com.wf.utilities.SessionUtils;


@ManagedBean
@ApplicationScoped
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userName;
	
	private String password;
	
	UserDto user=new UserDto();
	
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}


	public static final String AUTH_KEY = "app.user.name";
	
	@Autowired
	 UserService userservice;
	
	
	  @PostConstruct
	    private void init() {
	    	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	        ServletContext servletContext = (ServletContext) externalContext.getContext();
		WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext).
	                                   getAutowireCapableBeanFactory().
	                                   autowireBean(this);
		
		
	    }
	
	  
	 private String faliureLoginExeption;
	 private boolean checkFaliureLoginException;
	 
	  
	public boolean isCheckFaliureLoginException() {
		return checkFaliureLoginException;
	}
	public void setCheckFaliureLoginException(boolean checkFaliureLoginException) {
		this.checkFaliureLoginException = checkFaliureLoginException;
	}
	public String getFaliureLoginExeption() {
		return faliureLoginExeption;
	}
	public void setFaliureLoginExeption(String faliureLoginExeption) {
		this.faliureLoginExeption = faliureLoginExeption;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	  public boolean isLoggedIn() {
	    return FacesContext.getCurrentInstance().getExternalContext()
	        .getSessionMap().get(AUTH_KEY) != null;
	  }
	
	  public void logout() {
			HttpSession session = SessionUtils.getSession();
			session.invalidate();
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	public String login() throws Exception {
		
		
		
		 FacesContext context = FacesContext.getCurrentInstance();
      try {
       System.out.println("beforeeeeee");
             
        user= userservice.loginService(userName, password);
//		context.getExternalContext().redirect("studentHomePage.xhtml");
		System.out.println("after");
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);	
		session.setAttribute("username", userName);
		int role=user.getIsstudent();
		session.setAttribute("role", role);
		
		if(user.getIsstudent()==0)
			context.getExternalContext().redirect("/faces/adminHomePage.xhtml");			
		else	if(user.getIsstudent()==1)
			context.getExternalContext().redirect("/HomePage");		
		/*FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(
		        AUTH_KEY, userName);*/
	return null;
      }
      catch(Exception e)
      {
    	checkFaliureLoginException=true;  
    System.out.println("exp");
    	e.printStackTrace();
    	  setFaliureLoginExeption("Service not available , Please try again later ");
    	  return "/";
      }
		
	//	return "output";
	}
	
	
}
