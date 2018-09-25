package com.jsf.bootstrap;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.support.WebApplicationContextUtils;


@ManagedBean
@RequestScope
public class AdminMaterialUploadBean {

	
	@PostConstruct
    private void init() {
    	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        ServletContext servletContext = (ServletContext) externalContext.getContext();
	WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext).
                                   getAutowireCapableBeanFactory().
                                   autowireBean(this);
	
	
    }
	
	private Part file;

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}
	
}
