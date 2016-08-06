package com.hand.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {
	private String encodingString = null;

	public void init(FilterConfig filterConfig) throws ServletException {
		encodingString = filterConfig.getInitParameter("encoding");
		if (encodingString == null) {
			throw new ServletException("EncodingFilter字符编码为空！！ ！");
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(encodingString);
		response.setCharacterEncoding(encodingString);
		chain.doFilter(request, response);
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}
