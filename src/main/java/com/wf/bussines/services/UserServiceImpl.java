package com.wf.bussines.services;

import java.io.Serializable;

/**
 * 
 */



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.Daos.UserDao;
import com.wf.controllers.dto.CenterDto;
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




	@Override
	public String loginService(String username,String password) throws Exception {
		// TODO Auto-generated method stub
		UserDto userdto= new UserDto(); 
		userdto.setUsername(username);
		
		User user= userDao.findUserByUsernameAndPass(username,password);
		
		if(user==null)
			throw new Exception("Incorrect Username or Password");
		else
		{
			userdto.setId(user.getId());
			userdto.setName(user.getName());
			userdto.setGender(user.getGender());
			userdto.setMobilenumber(user.getMobilenumber());
			Center center=user.getCenter();
			CenterDto centerdto=new CenterDto(center.getId(), center.getCentername());
			
			userdto.setCenter(centerdto);
			
			userdto.setIsstudent(user.getIsstudent());
			
			if(user.getIsstudent()==1)
				return "adminHomePage";
				
			else	if(user.getIsstudent()==0)
				return "output";
			
			
			
			
			
			
			
		}
		return null;
			
			
		
		
	}
		

	
}
