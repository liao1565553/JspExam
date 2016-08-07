package com.hand.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.service.LanguageService;

public class GetLanguageServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1078731655919390362L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException {
		System.out.println("请求获得language 表数据");
		List<Map<?, ?>> languageList=null;
		 try {
			languageList= LanguageService.getLanguageList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 req.getSession().setAttribute("languageList", languageList);
		RequestDispatcher rd =  req.getRequestDispatcher("addFilm.jsp");
		rd.forward(req, resp);
	}
}
