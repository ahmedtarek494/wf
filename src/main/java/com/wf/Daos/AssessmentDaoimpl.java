package com.wf.Daos;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wf.entities.AssessmentLookup;
import com.wf.entities.Center;

@Repository

public class AssessmentDaoimpl extends AbstractDao implements AssessmentDao,Serializable {

	private static final long serialVersionUID = 1L;
	

	@Override
	public int addAssessment(AssessmentLookup assessment) {
		// TODO Auto-generated method stub
		getSession().save(assessment);
		System.out.println("saved//////////////////");
		getSession().flush();
		System.out.println("flushed////////////////////");
		getSession().clear();
		System.out.println("cleared///////////////////");
		
		return assessment.getId();
	}


	@Override
	public List<AssessmentLookup> findAll() {
		// TODO Auto-generated method stub
Criteria criteria = getSession().createCriteria(AssessmentLookup.class);
		
		
		
		// TODO Auto-generated method stub
		return criteria.list();
	}
	
	

}
