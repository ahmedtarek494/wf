package com.wf.Daos;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.wf.entities.GradesStudentView;

@Repository
public class GradesTopStudentDaoImpl extends AbstractDao implements GradesTopStudentDao,Serializable {

	private static final long serialVersionUID = 1L;
	
	public List<GradesStudentView> getTopTenStudent()
	{
		
		Criteria criteria = getSession().createCriteria(GradesStudentView.class);
		
		
		return criteria.list();
	}

}
