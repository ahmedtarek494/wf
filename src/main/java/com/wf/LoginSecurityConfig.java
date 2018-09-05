package com.wf;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*@Configuration
@EnableWebSecurity*/
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {

	/*@Autowired
	DataSource dataSource;
	
	@Override
	public void configure(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		
		authenticationMgr.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username,password from user where isstudent=0")
	.
		authenticationMgr.inMemoryAuthentication()
			.withUser("jduser").password("jdu@123").authorities("ROLE_USER")
			.and()
			.withUser("jdadmin").password("jda@123").authorities("ROLE_USER","ROLE_ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		
		http.authorizeRequests()
			.antMatchers("/faces/adminHomePage.xhtml").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
			.and()
				.formLogin().loginPage("/index.html").permitAll()
				.defaultSuccessUrl("/faces/adminHomePage.xhtml")
				.failureUrl("/faces/addStudent.xhtml")
				.usernameParameter("username").passwordParameter("password");				
			
		
	}*/
}
