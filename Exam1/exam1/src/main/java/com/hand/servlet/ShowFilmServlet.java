package com.hand.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.service.FilmService;

public class ShowFilmServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9176525406575944732L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
			IOException {
		System.out.println("========显示电影列表=========");
		//3.1、列表显示界面:显示所有的film,显示的字段有film_id,title,description,language(需要关联language表)
		 List<Map> lists = null;
		try {
			lists = FilmService.getFilmList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getSession().setAttribute("filmList", lists);
		System.out.println("========电影列表加入session=========");
	}
}
