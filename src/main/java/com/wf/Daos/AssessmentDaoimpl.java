package com.wf.Daos;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wf.entities.AssessmentLookup;

@Repository

public class AssessmentDaoimpl extends AbstractDao implements AssessmentDao,Serializable {

	private static final long serialVersionUID = 1L;
	

	@Override
	public void addAssessment(AssessmentLookup assessment) {
		// TODO Auto-generated method stub
		getSession().save(assessment);
		System.out.println("saved//////////////////");
		getSession().flush();
		System.out.println("flushed////////////////////");
		getSession().clear();
		System.out.println("cleared///////////////////");
	}
	
	

}
