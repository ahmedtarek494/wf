/**
 * 
 */
package com.wf.utilities;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author ahmed tarek
 * @author ahmed thabet
 *
 */
public class SpringContext implements ApplicationContextAware{

	private static ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
	    return applicationContext;
	}
}
