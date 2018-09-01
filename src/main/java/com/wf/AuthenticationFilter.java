package com.wf;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsf.bootstrap.User;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
    private FilterConfig config;

    public void doFilter(ServletRequest req, ServletResponse resp,
        FilterChain chain) throws IOException, ServletException {
      if (((HttpServletRequest) req).getSession().getAttribute(
          User.AUTH_KEY) == null) {
        ((HttpServletResponse) resp).sendRedirect("/");
      } else {
        chain.doFilter(req, resp);
      }
    }

    public void init(FilterConfig config) throws ServletException {
      this.config = config;
    }

    public void destroy() {
      config = null;
    }

}
