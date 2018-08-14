package com.wf.Daos;

import java.util.List;

import org.springframework.context.annotation.Bean;

import com.wf.entities.User;

public interface UserDao {

	@Bean
	 public void addUser(User user);
	    
	    public void editUser(User user, int userId);
	 
	    public void deleteUser(int userId);
	 
	    public User find(int userId);
	 
	    public List <User> findAll();
	    
	    public User findUserByUsername(String username);
}
