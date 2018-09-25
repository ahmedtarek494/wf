package com.wf.bussines.services;

import java.io.Serializable;

/**
 * 
 */



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;

import com.wf.Daos.UserDao;
import com.wf.exceptions.ExceptionHandler;




/**
 * @author ahmed tarek
 *
 */
@Transactional(rollbackFor = ExceptionHandler.class)
public abstract class ServicesManager implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * THIS ATTRIBUTE NOT USED
	 */
	/*@Autowired
	PropertySourcesPlaceholderConfigurer properties;*/
	
	
	@Autowired
	UserDao userDao;

	protected final Logger log = LoggerFactory.getLogger(ServicesManager.class);
	


	
/*
	
	protected User getUser(String username) throws Exception {
		User user = userDao.findUserByUsername(username);
	
		return user;
	}
	*/
	
	
}
