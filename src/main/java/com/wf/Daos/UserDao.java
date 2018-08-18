package com.wf.Daos;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.annotation.Bean;

import com.wf.entities.Center;
import com.wf.entities.User;

public interface UserDao {

	@Bean
	 public void addUser(User user);
	    
	    public void editUser(User user, int userId);
	 
	    public void deleteUser(int userId);
	 
	    public User find(int userId);
	 
	    public List <User> findAll();
	    
	    public List <User> findAllByCenter(Center center);
	    
	    public User findUserByUsernameAndPass(String username,String Password);
}


