package com.wf.Daos;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wf.entities.Center;
import com.wf.entities.User;


@Repository
public class UserDaoimpl extends AbstractDao implements UserDao,Serializable {

	

	private static final long serialVersionUID = 1L;

	@Override
	
	public int addUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("before2");
		getSession().save(user);
		System.out.println("before3");
		getSession().flush();
		System.out.println("before4");
		System.out.println("password : "+user.getId());
		getSession().clear();
		return user.getId();
	}

	@Override
	public void updateUserToSetPassword(User user) {
		// TODO Auto-generated method stub
		getSession().update(user);
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
		System.out.println("size : "+criteria.list().size());
		return criteria.list();
	}

	@Override
	public User findUserByUsernameAndPass(String username,String pass) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		criteria.add(Restrictions.eq("password", pass));
		
		return (User) criteria.uniqueResult();	}

	@Override
	public List<User> findAllByCenter(Center center) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("center", center));
		criteria.add(Restrictions.eq("isstudent", 0));
		
		
		return criteria.list();
	}


		
}


