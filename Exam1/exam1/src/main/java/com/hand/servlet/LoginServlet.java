package com.hand.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.bean.Customer;
import com.hand.service.CheckCustomerService;

public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2203805670032041121L;

	@Override
	public void init() throws ServletException {
		System.out.println("============init===============");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException {
		System.out.println("============doGet===============");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException {
		System.out.println("============doPost===============");
		String fristname = req.getParameter("fristname");

		System.out.println("用户名：" + fristname);

		Customer customer = new Customer();
		
		customer.setFirstName(fristname);
		
		customer = CheckCustomerService.CheckUser(customer);
		req.getSession().setAttribute("customer", customer);

		RequestDispatcher rd = null;

		if (customer != null) {
			System.out.println(customer.getFirstName()+"用户登录成功");
			req.getSession().setAttribute("flag", "login_success");
			rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
		} else {
			req.getSession().setAttribute("flag", "login_error");
			
			req.setAttribute("msg", "用户名或密码错误！！！");
			System.out.println(fristname+"登录失败！！");
			resp.sendRedirect(req.getContextPath() + "/login.jsp");
		}
	}

	@Override
	public void destroy() {
		System.out.println("============destory===============");
		super.destroy();
	}
}