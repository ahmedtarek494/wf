package com.wf.Daos;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wf.entities.User;


@Repository
public class UserDaoimpl extends AbstractDao implements UserDao,Serializable {

	

	private static final long serialVersionUID = 1L;

	@Override
	
	public void addUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("before2");
		getSession().save(user);
		System.out.println("before3");
		getSession().flush();
		System.out.println("before4");
		getSession().clear();
		
	}

	@Override
	public void editUser(User user, int userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User find(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(User.class);
		return criteria.list();
	}

	@Override
	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
