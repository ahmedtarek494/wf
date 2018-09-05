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
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "AuthFilter", urlPatterns = { "*.xhtml" })
public class AuthenticationFilter implements Filter {

	public AuthenticationFilter() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {

			HttpServletRequest reqt = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			HttpSession ses = reqt.getSession(false);

			String reqURI = reqt.getRequestURI();
			System.out.println("url :" +reqURI);

			if (reqURI.indexOf("/test.xhtml") >= 0
					|| (ses != null && ses.getAttribute("username") != null )
					)
			{
				
				
				System.out.println("status :" +reqURI.indexOf("admin"));
				if((ses != null && ses.getAttribute("username") != null && (reqURI.contains("admin")||reqURI.contains("student"))))
				{
					System.out.println("session :" +ses.getAttribute("username"));
				System.out.println("status admin:" +reqURI.contains("admin"));
				System.out.println("status student:" +reqURI.contains("student"));

				System.out.println("role :" + ses.getAttribute("role"));
				
				if(reqURI.indexOf("admin") >= 0 && ses.getAttribute("role").equals(0))
				chain.doFilter(request, response);
				
				else if(reqURI.indexOf("admin") >= 0 && ses.getAttribute("role").equals(1))
				{
					 System.out.println("2");
					/*resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
					  resp.getWriter().println("<html><body><p>Use "
						+ "Access denied!</p></body></html>");*/
				}
				else	 if(reqURI.indexOf("student") >= 0 && ses.getAttribute("role").equals(1))
				 					 chain.doFilter(request, response);
				 
				
				}
				else
				chain.doFilter(request, response);
				
				
			}
			else
				resp.sendRedirect(reqt.getContextPath() + "/");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void destroy() {

	}
}
