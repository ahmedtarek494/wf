package com.wf.Daos;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.wf.entities.Grades;


@Repository
public class GradesDaoImpl extends AbstractDao implements GradesDao,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int Creategradeform(Grades grade) {
		// TODO Auto-generated method stub
		String hqlInsert = "insert into Grades(userid,assessmenttype) select id,"+grade.getAssesmenttype().getId()+" from user";
		System.out.println("before query");
		int updateCount = getSession().createQuery(hqlInsert).executeUpdate();
		
		System.out.println("count :"+ updateCount);
		
		
		return updateCount;
	}

}
