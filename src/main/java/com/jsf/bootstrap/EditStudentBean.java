package com.jsf.bootstrap;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.wf.Daos.UserDao;
import com.wf.bussines.services.UserService;
import com.wf.controllers.dto.CenterDto;
import com.wf.controllers.dto.UserDto;
import com.wf.utilities.SessionUtils;

@RequestScope
@ManagedBean
public class EditStudentBean implements Serializable {

	private static final long serialVersionUID = -8563412184846944419L;

	
	
	@PostConstruct
    private void init() {
    	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        ServletContext servletContext = (ServletContext) externalContext.getContext();
	WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext).
                                   getAutowireCapableBeanFactory().
                                   autowireBean(this);
	
	
    }

	
	@Autowired
	private UserService userservice;	
	
	
	
	int id;
	String name;
	String gender;
	String mobilenumber;
	String parentnumber;
	int center;
	String username;
	String password;
	
	
	// for confirmation message
	String successfulMessage;
	String faliureMessage;
	boolean checkValueSuccessful;
	boolean checkValueFailure;
	
	
	
	
	
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



	public boolean isCheckValueSuccessful() {
		return checkValueSuccessful;
	}



	public void setCheckValueSuccessful(boolean checkValueSuccessful) {
		this.checkValueSuccessful = checkValueSuccessful;
	}



	public boolean isCheckValueFailure() {
		return checkValueFailure;
	}



	public void setCheckValueFailure(boolean checkValueFailure) {
		this.checkValueFailure = checkValueFailure;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getMobilenumber() {
		return mobilenumber;
	}



	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}



	public String getParentnumber() {
		return parentnumber;
	}



	public void setParentnumber(String parentnumber) {
		this.parentnumber = parentnumber;
	}



	public int getCenter() {
		return center;
	}



	public void setCenter(int center) {
		this.center = center;
	}



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



	public EditStudentBean() {

		HttpSession session = SessionUtils.getSession();
		
		UserDto userdto=(UserDto) session.getAttribute("userDTO");
		this.id=userdto.getId();
		this.name=userdto.getName();
		this.gender=userdto.getGender();
		this.mobilenumber=userdto.getMobilenumber();
		this.parentnumber=userdto.getParentnumber();
		this.center=userdto.getCenter().getId();
		//this.username=userdto.getUsername();
		this.password=userdto.getPassword();
		
		
		System.out.println(userdto.getGender());
		System.out.println(userdto.getMobilenumber());
	}
	
	public void editStudent() {

//        HttpSession session = SessionUtils.getSession();
//		
//		UserDto userdto=(UserDto) session.getAttribute("userDTO");
//		
		UserDto userDto1=new UserDto();
		userDto1.setId(this.id);
		userDto1.setName(this.name);
		userDto1.setGender(this.gender);
		userDto1.setMobilenumber(this.mobilenumber);
		userDto1.setParentnumber(this.parentnumber);
		CenterDto c1=new CenterDto();
		c1.setId(this.center);
		userDto1.setCenter(c1);
		//userDto1.setUsername(this.username);
		userDto1.setPassword(this.password);
		System.out.println("parent number in dto"+parentnumber);
		try {
			userservice.editStudentInfo(userDto1);
			checkValueSuccessful=true;
			setSuccessfulMessage("Well done! You successfully updated your student");
		} catch (Exception e) {
			// TODO: handle exception
			checkValueFailure=true;
			setFaliureMessage("Warning! Try again to update student");
		}
		 
		
		
	}

	
}
