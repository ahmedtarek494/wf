package com.wf.bussines.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.wf.exceptions.AuthenticationException;
import com.wf.utilities.SessionUtils;


@Service("userservice")
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
	public int createUser(UserDto user) throws Exception {
		// TODO Auto-generated method stub
		User u1=new User();
		int userid=0;
		u1.setId(user.getId());
		u1.setName(user.getName());
		u1.setGender(user.getGender());
		u1.setIsstudent(1);
		
		Center c1=new Center();
		c1.setId(user.getCenter().getId());
		u1.setCenter(c1);
		u1.setMobilenumber(user.getMobilenumber());
		u1.setParentnumber(user.getParentnumber());
		//u1.setUsername(user.getName());
		//u1.setPassword("wfmath"+userDao.addUser(u1));
		System.out.println("before 1");
		
		userid=userDao.addUser(u1);
		
		u1.setUsername(String.valueOf(userid));
		u1.setPassword("wfmath"+userid);
		userDao.updateUserToSetPassword(u1);
		
		
		
		return userid;
	}




	@Override
	public UserDto loginService(String username,String password) throws Exception {
		// TODO Auto-generated method stub
		UserDto userdto= new UserDto(); 
		userdto.setUsername(username);
		
		User user= userDao.findUserByUsernameAndPass(username,password);
		
		if(user==null)
			throw new AuthenticationException("Incorrect Username or Password");
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
			

			
			
			
			return userdto;
			
			
			
		}
		
			
			
		
		
	}




	@Override
	public ArrayList<UserDto> getUsersByCenter(int CenterID) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<UserDto> userlist=new ArrayList<UserDto>();
		
		Center center1=new Center();
		center1.setId(CenterID);
		List<User> user=userDao.findAllByCenter(center1) ;
		System.out.println("list size : "+user.size());
		if(user==null)
			throw new Exception("No Students Available");
		else {
			for (User u:user)
			{
				UserDto userdto= new UserDto(); 
				userdto.setUsername(u.getUsername());
				userdto.setPassword(u.getPassword());
				userdto.setId(u.getId());
				userdto.setName(u.getName());
				userdto.setGender(u.getGender());
				userdto.setMobilenumber(u.getMobilenumber());
				userdto.setParentnumber(u.getParentnumber());
				Center center=u.getCenter();
				CenterDto centerdto=new CenterDto(center.getId(), center.getCentername());
				
				userdto.setCenter(centerdto);
				
				userdto.setIsstudent(u.getIsstudent());
				
				userlist.add(userdto);
				
			}
			
			return userlist;
			
		}
	}




	@Override
	public void editStudentInfo(UserDto user) throws Exception {
		// TODO Auto-generated method stub
		User user1=new User();
		user1.setId(user.getId());
		user1.setName(user.getName());
		user1.setGender(user.getGender());
		user1.setMobilenumber(user.getMobilenumber());
		user1.setParentnumber(user.getParentnumber());
		Center c1=new Center();
		c1.setId(user.getCenter().getId());
		c1.setCentername(user.getCenter().getCentername());
		user1.setCenter(c1);
		//user1.setUsername(user.getUsername());
		user1.setPassword(user.getPassword());
		user1.setIsstudent(1);
		
		try {
			userDao.editStudentInformation(user1);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}




	@Override
	public void deleteStudentInfo(UserDto user) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = SessionUtils.getSession();
		
		user=(UserDto) session.getAttribute("userDTO");
		//userdto.getId();
		User user1=new User();
		user1.setId(user.getId());
		user1.setName(user.getName());
		user1.setGender(user.getGender());
		user1.setMobilenumber(user.getMobilenumber());
		user1.setParentnumber(user.getParentnumber());
		Center c1=new Center();
		c1.setId(user.getCenter().getId());
		c1.setCentername(user.getCenter().getCentername());
		user1.setCenter(c1);
		user1.setUsername(user.getUsername());
		user1.setPassword(user.getPassword());
		user1.setIsstudent(1);
		
		try {
			userDao.deleteStudentInformation(user1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
		

	
}
