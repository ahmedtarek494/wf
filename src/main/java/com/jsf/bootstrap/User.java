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
		System.out.println("after");
		return nextPage;
      }
      catch(Exception e)
      {
    	  System.out.println("exp "+ e.getMessage());
    	  return "test";
      }
		
	//	return "output";
	}
	
	
}
