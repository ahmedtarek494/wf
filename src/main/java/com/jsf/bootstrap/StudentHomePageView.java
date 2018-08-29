package com.jsf.bootstrap;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.wf.bussines.services.GradesService;
import com.wf.controllers.dto.CenterDto;
import com.wf.controllers.dto.GradesDto;

@ManagedBean
@RequestScope
public class StudentHomePageView implements Serializable {

	@Autowired
	GradesService gradesService;
	
 private ArrayList<GradesDto> gradeslistdto;


public ArrayList<GradesDto> getGradeslistdto() {
	return gradeslistdto;
}


public void setGradeslistdto(ArrayList<GradesDto> gradeslistdto) {
	this.gradeslistdto = gradeslistdto;
}

	
	
	 @PostConstruct
	    private void init()  {
	    	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	        ServletContext servletContext = (ServletContext) externalContext.getContext();
		WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext).
	                                   getAutowireCapableBeanFactory().
	                                   autowireBean(this);
		
		try {
			gradeslistdto=gradesService.getGradesByUserId(1001);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    }


	
		
	
	


	
	
	
	
	
}
