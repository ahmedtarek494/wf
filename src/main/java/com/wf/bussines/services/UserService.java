package com.wf.bussines.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.wf.controllers.dto.UserDto;
import com.wf.entities.User;

/**
 * 
 */






public interface UserService {

	
	

	public void createUser( UserDto user) throws Exception;
	
	
	public String loginService( String username,String Password) throws Exception;
	
	public ArrayList<UserDto> getUsersByCenter( int CenterID) throws Exception;
	
}
