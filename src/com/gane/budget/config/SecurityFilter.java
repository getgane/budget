package com.gane.budget.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "myFilter", urlPatterns = "/*")
public class SecurityFilter implements Filter {

	private static final String RESOURCE_PATH = "/jsps/";
	@Override
	public void init(final FilterConfig filterConfig) throws ServletException {
		System.out.println("StaticResourceFilter initialized");
	}

	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response,
			final FilterChain chain) throws IOException, ServletException {
		String path = ((HttpServletRequest) request).getServletPath();
		System.out.println("In filter");
		if (path.toLowerCase().startsWith(RESOURCE_PATH)) {
			System.out.println("filtered if");
			request.getRequestDispatcher(path).forward(request, response);
		} else {
			System.out.println("fitered else");
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		System.out.println("StaticResourceFilter destroyed");
	}
}
