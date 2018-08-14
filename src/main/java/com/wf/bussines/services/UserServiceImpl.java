package com.wf.bussines.services;

import java.io.Serializable;

/**
 * 
 */



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.Daos.UserDao;
import com.wf.controllers.dto.UserDto;
import com.wf.entities.Center;
import com.wf.entities.User;


@Service
public class UserServiceImpl extends ServicesManager implements UserService,Serializable {

	/* (non-Javadoc)
	 * @see com.dashda.service.components.UserService#findListOfUsers()
	 */

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserDao userDao;

	
	
	
	@Override
	public void createUser(UserDto user) throws Exception {
		// TODO Auto-generated method stub
		User u1=new User();
		u1.setId(user.getId());
		u1.setName(user.getName());
		u1.setGender(user.getGender());
		u1.setIsstudent(user.getIsstudent());
		
		Center c1=new Center(user.getCenter().getId(),user.getCenter().getCentername());
		u1.setCenter(c1);
		u1.setMobilenumber(user.getMobilenumber());
		System.out.println("before 1");
		userDao.addUser(u1);
		
	}
		

	
}
