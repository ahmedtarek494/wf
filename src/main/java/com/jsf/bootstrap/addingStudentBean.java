package com.jsf.bootstrap;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.appengine.repackaged.org.antlr.runtime.EarlyExitException;
import com.wf.bussines.services.UserService;
import com.wf.controllers.dto.CenterDto;
import com.wf.controllers.dto.UserDto;


@RequestScope
@ManagedBean
public class addingStudentBean {

	
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
	
	String fullName;
	String gender;
	String mobileNumber;
	int Center;
	
	String successfulMessage;
	String faliureMessage;
	boolean checkValue;
	boolean checkValueFailure;
	
	

	public boolean isCheckValueFailure() {
		return checkValueFailure;
	}
	public void setCheckValueFailure(boolean checkValueFailure) {
		this.checkValueFailure = checkValueFailure;
	}
	public boolean isCheckValue() {
		return checkValue;
	}
	public void setCheckValue(boolean checkValue) {
		this.checkValue = checkValue;
	}
	public String getSuccessfulMessage() {
		return successfulMessage;
	}
	public void setSuccessfulMessage(String successfulMessage) {
		this.successfulMessage = successfulMessage;
	}
	public String getFaliureMessage() {
		return faliureMessage;
	}
	public void setFaliureMessage(String faliureMessage) {
		this.faliureMessage = faliureMessage;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public int getCenter() {
		return Center;
	}
	public void setCenter(int center) {
		Center = center;
	}

	public void addStudent() throws Exception {
	
	//	FacesContext context=FacesContext.getCurrentInstance();	
		
		UserDto userdto=new UserDto();
	userdto.setName(this.fullName);
	userdto.setGender(this.gender);
	userdto.setMobilenumber(this.mobileNumber);
	CenterDto c1=new CenterDto();
	c1.setId(this.Center);
	//c1.setCentername("basamel");
	userdto.setCenter(c1);
	
	try {
	 int userid= userservice.createUser(userdto);

	 checkValue=true;
	setSuccessfulMessage("Well done! You successfully added student, Student id is "+userid);
	
	//context.addMessage(null, new FacesMessage("Successful transaction ,student has been added , USER ID  is "+userid));
	
	}
	catch (Exception e) {
		// TODO: handle exception
	//	context.addMessage(null, new FacesMessage("Try again ,wrong transaction"));
		checkValueFailure=true;
	setFaliureMessage("Warning! Try again to add student");		
	}
	}
	
	
	
}
