package com.hand.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PermissionFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String servletPath = req.getServletPath();
		System.out.println("servletPath="+servletPath);
		HttpSession session = req.getSession();
		String flag = (String) session.getAttribute("flag");
		System.out.println("flag="+flag);
		
		if("login_success".equals(flag)){
			chain.doFilter(request, response);
		}else {
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}
		
		
//		if (servletPath != null
//				&& (servletPath.equals("/cust/login.jsp") || (servletPath.equals("/index.jsp"))||
//						servletPath.equals("/loginServlet"))) {
//			chain.doFilter(request, response);
//		}else {
//			if (flag!=null&&flag.equals("login_success")) {
//				chain.doFilter(request, response);
//			}else if(flag!=null&&flag.equals("login_error")){
//				req.setAttribute("msg", "登陆失败，请重新登陆！<br>");
//				req.setAttribute("returnUri", servletPath);
//				RequestDispatcher rd=req.getRequestDispatcher("/cust/login.jsp");
//				rd.forward(req, resp);
//			}else {
//				req.setAttribute("msg", "您尚未登陆，请登陆！<br>");
//				req.setAttribute("returnUri", servletPath);
//				RequestDispatcher rd=req.getRequestDispatcher("/cust/login.jsp");
//				rd.forward(req, resp);
//			}
//		}

		

	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}
