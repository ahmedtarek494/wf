package com.jsf.bootstrap;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.wf.bussines.services.CenterService;
import com.wf.bussines.services.UserService;
import com.wf.controllers.dto.CenterDto;
import com.wf.controllers.dto.UserDto;
import com.wf.enums.CenterNameEnum;
import com.wf.utilities.EditStudentBean;
import com.wf.utilities.SessionUtils;
import com.wf.utilities.SpringContext;

@ManagedBean
@SessionScoped
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
	 private ArrayList<CenterDto> centerlistdto;
	public ArrayList<CenterDto> getCenterlistdto() {
		return centerlistdto;
	}
	public void setCenterlistdto(ArrayList<CenterDto> centerlistdto) {
		this.centerlistdto = centerlistdto;
	}
	public ArrayList<UserDto> getUserslistdto() {
		return userslistdto;
	}
	public void setUserslistdto(ArrayList<UserDto> userslistdto) {
		this.userslistdto = userslistdto;
	}

	
	
	
	@Autowired
	private transient UserService userservice;
	
	
	  public UserService getUserservice() {
		  if(userservice==null)
	     userservice=(UserService) SpringContext.getApplicationContext().getBean("userservice");
		return userservice;
	}
	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	
	
	
	@Autowired
	private transient CenterService centerservice;
	public CenterService getCenterservice() {
		if(centerservice==null)
			centerservice=(CenterService) SpringContext.getApplicationContext().getBean("centerservice");

		return centerservice;
	}
	public void setCenterservice(CenterService centerservice) {
		this.centerservice = centerservice;
	}
	
	private static final long serialVersionUID = 1L;
	private boolean student=false;
	private boolean grade=false;
	private ArrayList<UserDto> userslist;
	private boolean dropdownbool=false;
	public boolean isDropdownbool() {
		return dropdownbool;
	}
	public void setDropdownbool(boolean dropdownbool) {
		this.dropdownbool = dropdownbool;
	}

	private String studentcentervalue;
	
	public String getStudentcentervalue() {
		return studentcentervalue;
	}
	public void setStudentcentervalue(String studentcentervalue) {
		this.studentcentervalue = studentcentervalue;
	}
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
	
	public void handleAjaxStudent(int centerid) {
	
		
		System.out.println("handle ajax student");
			student=true;
		 grade=false;
		 
	      try {
	       System.out.println("beforeeeeee");
	             
	     this.userslistdto= getUserservice().getUsersByCenter(centerid);
	     
	     this.studentcentervalue=userslistdto.get(0).getCenter().getCentername();
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
	
	public void handleAjaxDropDown() {
		dropdownbool=true;
		try
		{
			
		
		centerlistdto=getCenterservice().getAllCenters();
		}
		  catch(Exception e)
	      {
	    	  System.out.println("exp "+ e.getMessage());
	    	  
	      }
		System.out.println("handle ajax dropdown");
	}
	
	
	public String directEditpage(UserDto selectedSudent) {
		

		HttpSession session = SessionUtils.getSession();
		
		session.setAttribute("userDTO", selectedSudent);
		
		System.out.println("name : "+ selectedSudent.getName());
		
		//session.setAttribute("Name", editStudentBean.setName(););
		
		return "/faces/admineditStudent.xhtml?faces-redirect=true";
	}
	
	public void deleteStudent(UserDto selectedSudent) {
		

		HttpSession session = SessionUtils.getSession();
		
		session.setAttribute("userDTO", selectedSudent);
		
		System.out.println("name : "+ selectedSudent.getName());
		
		//session.setAttribute("Name", editStudentBean.setName(););
		
		try {
			userservice.deleteStudentInfo(selectedSudent);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
