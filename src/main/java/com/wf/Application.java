/**
 * 
 */
package com.wf;

import java.io.Serializable;
import java.util.EnumSet;
import java.util.Properties;

import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.wf.utilities.SpringContext;

/**
 * @author ahmedtarek
 *
 */


@Configuration
@EnableAutoConfiguration(exclude = {
	    org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@ComponentScan
@EnableScheduling
public class Application extends SpringBootServletInitializer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 400348586420922920L;
	protected final Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(applicationClass, args);

	}
	
    @Autowired
    private Environment env;
    
    
    @Bean
    SpringContext springContext() {
    	return new SpringContext();
    }
	@Bean
    public DataSource dataSource() {
		
        /*DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
        return dataSource;
        */
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        
        dataSource.setUrl("jdbc:mysql://35.202.139.180:3306/wf_dev?autoReconnect=true&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        
//      dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//      dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/wftest?autoReconnect=true&useSSL=false");
//      dataSource.setUsername("root");
//      dataSource.setPassword("123456");
        return dataSource;
    }

    
	 @Bean
	    public ServletRegistrationBean servletRegistrationBean() {
	        FacesServlet servlet = new FacesServlet();
	        return new ServletRegistrationBean(servlet, "*.jsf");
	    }
	

	 
	 
	 
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.wf.entities" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
     }
    
    
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
        properties.put("current_session_context_class", env.getRequiredProperty("current_session_context_class"));
        properties.put("hibernate.jdbc.batch_size", env.getRequiredProperty("hibernate.jdbc.batch_size"));
        //c3p0 configuration 
        properties.put("hibernate.c3p0.acquire_increment", env.getRequiredProperty("hibernate.c3p0.acquire_increment"));
        properties.put("hibernate.c3p0.idle_test_period", env.getRequiredProperty("hibernate.c3p0.idle_test_period"));
        properties.put("hibernate.c3p0.max_size", env.getRequiredProperty("hibernate.c3p0.max_size"));
        properties.put("hibernate.c3p0.max_statements", env.getRequiredProperty("hibernate.c3p0.max_statements"));
        properties.put("hibernate.c3p0.min_size", env.getRequiredProperty("hibernate.c3p0.min_size"));
        properties.put("hibernate.c3p0.timeout", env.getRequiredProperty("hibernate.c3p0.timeout"));
        
        //properties.put("hibernate.c3p0.unreturnedConnectionTimeout=30", env.getRequiredProperty("hibernate.c3p0.unreturnedConnectionTimeout=30"));
        properties.put("hibernate.c3p0.debugUnreturnedConnectionStackTraces", env.getRequiredProperty("hibernate.c3p0.debugUnreturnedConnectionStackTraces"));
        properties.put("hibernate.c3p0.maxConnectionAge", env.getRequiredProperty("hibernate.c3p0.maxConnectionAge"));
        properties.put("hibernate.c3p0.maxIdleTime", env.getRequiredProperty("hibernate.c3p0.maxIdleTime"));
        properties.put("hibernate.c3p0.maxIdleTimeExcessConnections", env.getRequiredProperty("hibernate.c3p0.maxIdleTimeExcessConnections"));
        
        System.out.println("proprtyyyy  :"+ properties.getProperty("hibernate.c3p0.maxConnectionAge"));
        return properties;
	}

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory  sessionFactory) {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(sessionFactory);
       return txManager;
    }
    
    
    
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}

    
	private static Class<Application> applicationClass = Application.class;
	}
	
	