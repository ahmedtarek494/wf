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
	public void Creategradeform( AssessmentLookup assessment){
		// TODO Auto-generated method stub


		Query query = getSession().createSQLQuery("CALL student_grade("+assessment.getId()+")");
       	//String hqlInsert = "insert into Grades(userid) select id from User";
		System.out.println("before query");
		int updateCount = query.executeUpdate();
		System.out.println("count of student added :"+ updateCount);
	
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

	@Override
	public int updateGrades(List<Grades> grades) {
		// TODO Auto-generated method stub
		int row=0;
		for(Grades g: grades)
		{
			Query query = getSession().createQuery("update Grades set usergrade = :usergrade" +
    				" where userid = :userid and assessmenttype=:assessmenttype");
query.setParameter("usergrade", g.getUsergrade());
query.setParameter("userid",g.getUser());
query.setParameter("assessmenttype",g.getAssesmenttype());
  row=query.executeUpdate();
		System.out.println("query updated");
			
			  
			 
		}
		return row;
	}

}
