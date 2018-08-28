package com.jsf.bootstrap;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.wf.bussines.services.UserService;


@RequestScope
@ManagedBean
public class User {
	private String userName;
	
	private String password;
	
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
	


	public String login() throws Exception {
		
		
		
		 FacesContext context = FacesContext.getCurrentInstance();
      try {
       System.out.println("beforeeeeee");
             
		String nextPage= userservice.loginService(userName, password);
		context.getExternalContext().redirect(nextPage);
		System.out.println("after");

		return nextPage;
      }
      catch(Exception e)
      {
    	checkFaliureLoginException=true;  
    	  System.out.println("exp "+ e.getMessage());
    	  setFaliureLoginExeption(e.getMessage());
    	  return "test";
      }
		
	//	return "output";
	}
	
	
}
