package com.wf.bussines.services;

import java.io.Serializable;

/**
 * 
 */


import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wf.Daos.UserDao;
import com.wf.entities.User;




/**
 * @author ahmed tarek
 *
 */
@Transactional(rollbackFor = Exception.class)
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
	


	

	
	protected User getUser(String username) throws Exception {
		User user = userDao.findUserByUsername(username);
	
		return user;
	}
	
	
	
}
