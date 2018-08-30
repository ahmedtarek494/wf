package com.wf.Daos;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.wf.entities.AssessmentLookup;
import com.wf.entities.Grades;
import com.wf.entities.User;


@Repository
public class GradesDaoImpl extends AbstractDao implements GradesDao,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void Creategradeform(List <User> user, Grades grade) {
		// TODO Auto-generated method stub
	/*	String hqlInsert = "insert into Grades(userid,assessmenttype) select id,"+grade.getAssesmenttype().getId()+" from user";
		System.out.println("before query");
		int updateCount = getSession().createQuery(hqlInsert).executeUpdate();
		
		System.out.println("count :"+ updateCount);*/
		int count = 0;
		for(User u: user)
		{
			Grades tempgrade =new Grades();
			tempgrade.setAssesmenttype(grade.getAssesmenttype());
			tempgrade.setUser(u);
			getSession().save(tempgrade);
			
		/*	  
			  count++;
	            if ( (count % 20) == 0) {
	            	getSession().flush();
	            	getSession().clear();
	            	System.out.println("20");
	            }   */
			System.out.println( "session : "+getSession().getTenantIdentifier());
		}
		
		getSession().flush();
		System.out.println("flush");
		
		getSession().clear();
	
	}

	@Override
	public List<Grades> getGradesByCenterAndtype(User objcenter, AssessmentLookup type) {
		Criteria criteria = getSession().createCriteria(Grades.class);
		criteria.add(Restrictions.eq("userid", objcenter));
		criteria.add(Restrictions.eq("assessmenttype", type));
		
		return criteria.list();	}
	public List<Grades> findGradeByUserID(User user) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Grades.class);
		criteria.add(Restrictions.eq("userid", user));
		
		return criteria.list();
	}

}
