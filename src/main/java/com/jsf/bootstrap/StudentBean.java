package com.jsf.bootstrap;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.wf.Daos.UserDao;
import com.wf.bussines.services.UserService;
import com.wf.controllers.dto.CenterDto;
import com.wf.controllers.dto.UserDto;


@Scope(value = "session")

@Component(value = "studentBean")
@ManagedBean @SessionScoped

public class StudentBean implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

/*	@ManagedProperty(value = "#{UserDao}")
	UserDao userdao;*/
	
	
	@Autowired
	UserService userservice;
	
	
	private String firstName;
	private String lastName;
	private String standard;

	
	  @PostConstruct
	    private void init() {
	    	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	        ServletContext servletContext = (ServletContext) externalContext.getContext();
		WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext).
	                                   getAutowireCapableBeanFactory().
	                                   autowireBean(this);
	    }
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String createStudentForm() throws Exception {
		
		 FacesContext context = FacesContext.getCurrentInstance();
             UserDto user =new UserDto();
             user.setName("ahmed");
             user.setIsstudent(1);
             user.setGender("male");
             user.setMobilenumber("03143115");
             
            
             CenterDto center=new CenterDto(1,"basmala");
             
             user.setCenter(center);
          
       System.out.println("beforeeeeee");
             
		userservice.createUser(user);
		
		
		return "output";
	}
}