package com.wf.Daos;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.wf.entities.Center;


@Repository

public class CenterDaoImpl extends AbstractDao implements CenterDao,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<Center> findAll() {
		
		Criteria criteria = getSession().createCriteria(Center.class);
		
		
		
		// TODO Auto-generated method stub
		return criteria.list();
	}

}
