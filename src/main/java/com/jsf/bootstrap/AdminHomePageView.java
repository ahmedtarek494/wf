package com.jsf.bootstrap;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.wf.bussines.services.UserService;
import com.wf.controllers.dto.UserDto;
import com.wf.enums.CenterNameEnum;

@ManagedBean
@RequestScope
public class AdminHomePageView  implements Serializable{

	
	
	
	 @PostConstruct
	    private void init() {
	    	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	        ServletContext servletContext = (ServletContext) externalContext.getContext();
		WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext).
	                                   getAutowireCapableBeanFactory().
	                                   autowireBean(this);
	    }
	
	/**
	 * 
	 */
	
	 private ArrayList<UserDto> userslistdto;
	
	public ArrayList<UserDto> getUserslistdto() {
		return userslistdto;
	}
	public void setUserslistdto(ArrayList<UserDto> userslistdto) {
		this.userslistdto = userslistdto;
	}

	@Autowired
	UserService userservice;
	private static final long serialVersionUID = 1L;
	private boolean student=false;
	private boolean grade=false;
	private ArrayList<UserDto> userslist;
	
	public ArrayList<UserDto> getUserslist() {
		return userslist;
	}
	public void setUserslist(ArrayList<UserDto> userslist) {
		this.userslist = userslist;
	}
	public boolean isStudent() {
		return student;
	}
	public void setStudent(boolean student) {
		this.student = student;
	}
	
	public boolean isGrade() {
		return grade;
	}
	
	public void setGrade(boolean grade) {
		this.grade = grade;
	}
	
	public void handleAjaxStudent() {
	
		
		System.out.println("handle ajax student");
			student=true;
		 grade=false;
		 FacesContext context = FacesContext.getCurrentInstance();
	      try {
	       System.out.println("beforeeeeee");
	             
	     this.userslistdto= userservice.getUsersByCenter(CenterNameEnum.BASMALA_OCTOBER);
			System.out.println("after");
			
	      }
	      catch(Exception e)
	      {
	    	  System.out.println("exp "+ e.getMessage());
	    	  
	      }
			
	
		 
	
	System.out.println("student in student handle: "+student);
	System.out.println("grade in student handle: "+grade);
	}
	
	public void handleAjaxGrade() {
		grade=true;
		student=false;
		System.out.println("handle ajax grade");
	}
}
