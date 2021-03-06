package com.wf.bussines.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.wf.controllers.dto.UserDto;
import com.wf.entities.User;

/**
 * 
 */






public interface UserService  {

	
	

	public int createUser( UserDto user) throws Exception;
	
	
	public UserDto loginService( String username,String Password) throws Exception;
	
	public ArrayList<UserDto> getUsersByCenter( int CenterID) throws Exception;
	
	public void editStudentInfo(UserDto user) throws Exception;
	
	public void deleteStudentInfo(UserDto user) throws Exception;
	
}
