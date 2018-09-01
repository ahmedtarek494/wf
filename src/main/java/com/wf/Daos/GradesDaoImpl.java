package com.wf.Daos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.wf.entities.AssessmentLookup;
import com.wf.entities.Grades;
import com.wf.entities.User;

import javassist.convert.Transformer;


@Repository
public class GradesDaoImpl extends AbstractDao implements GradesDao,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void Creategradeform(List<User> user, Grades grade) {
		// TODO Auto-generated method stub
	/*	String hqlInsert = "insert into Grades(userid,assessmenttype) select id,"+grade.getAssesmenttype().getId()+" from User";
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
			
			  
			  count++;
	            if ( (count % 20) == 0) {
	            	getSession().flush();
	            	getSession().clear();
	            	System.out.println("20");
	            }   
			System.out.println( "session : "+getSession().getTenantIdentifier());
		}
		
		getSession().flush();
		System.out.println("flush");
		
		getSession().clear();
	
	}

	@Override
	public List<Grades> getGradesByCenterAndtype(User objcenter, AssessmentLookup type) {
		/*Query query = getSession().createQuery("from Grades where userid in(select id from User where center=:center1  )");
		query.setParameter("center1", objcenter.getCenter().getId());*/
		
		Criteria criteria = getSession().createCriteria(Grades.class).add(Restrictions.eq("assessmenttype", type)).createCriteria("userid").add(Restrictions.eq("center", objcenter.getCenter()));
	//	criteria.add(Restrictions.eq("userid", objcenter));
	//	criteria.add(Restrictions.eq("assessmenttype", type));
	
		return criteria.list();	}
	public List<Grades> findGradeByUserID(User user) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(Grades.class);
		criteria.add(Restrictions.eq("userid", user));
		
		return criteria.list();
	}
	
	public List<Grades> getTopTenStudent()
	{
//		String sql="SELECT SUM(g.usergrade) AS total_grades from Grades as g group by userid order by total_grades desc";
//		Query query= getSession().createQuery(sql);
//
//		Criteria criteria=getSession().createCriteria(Grades.class);
//		criteria.setProjection(Projections.sum("usergrade"));
//		criteria.setProjection(Projections.groupProperty("userid"));
//		criteria.setResultTransformer(Transformers.aliasToBean(Grades.class)).list();

		Criteria criteria=getSession().createCriteria(Grades.class);
		criteria.setProjection(Projections.sum("usergrade"));
		criteria.setProjection(Projections.groupProperty("userid"));
		criteria.setResultTransformer(Transformers.aliasToBean(Grades.class)).list();
		System.out.println("criteria list : "+criteria);
		return criteria.list();

		
		
	}

}
